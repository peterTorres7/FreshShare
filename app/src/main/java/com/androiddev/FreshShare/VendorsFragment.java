package com.androiddev.FreshShare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androiddev.FreshShare.models.Vendor;
import com.androiddev.FreshShare.viewmodels.VendorViewModel;

import java.util.ArrayList;

public class VendorsFragment extends Fragment {
    public ArrayList vendorList = new ArrayList();
    private VendorViewModel viewModel = new VendorViewModel();
    private RecyclerView recyclerView;
    public VendorRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment with the ProductGrid theme
        View view = inflater.inflate(R.layout.fragment_vendors, container, false);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.matches_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.matches_grid_spacing_small);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false));
        adapter = new VendorRecyclerViewAdapter(vendorList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new VendorGridDecoration(largePadding, smallPadding));
        getVendors();


        return view;
    }

    public void getVendors(){
        viewModel.getVendors(
                (ArrayList<Vendor> vendor) -> {
                    adapter.setVendorList(vendor);
                    adapter.notifyDataSetChanged();
                });
    }
}
