package com.androiddev.freshshare;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.androiddev.freshshare.models.FoodItem;
import com.androiddev.freshshare.viewmodels.FoodViewModel;

import java.util.ArrayList;

public class FoodItemsFragment extends Fragment {
    public ArrayList foodList = new ArrayList();
    private FoodViewModel viewModel = new FoodViewModel();
    private RecyclerView recyclerView;
    public FoodRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(
            @NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment with the ProductGrid theme
        View view = inflater.inflate(R.layout.food_fragment, container, false);
        int largePadding = getResources().getDimensionPixelSize(R.dimen.matches_grid_spacing);
        int smallPadding = getResources().getDimensionPixelSize(R.dimen.matches_grid_spacing_small);
        recyclerView = view.findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2, GridLayoutManager.VERTICAL, false));
        adapter = new FoodRecyclerViewAdapter(foodList);
        recyclerView.setAdapter(adapter);
        recyclerView.addItemDecoration(new FoodGridDecoration(largePadding, smallPadding));
        getItems();


        return view;
    }

    public void getItems(){
        viewModel.getItems(
                (ArrayList<FoodItem> foodItems) -> {
                    adapter.setItemsList(foodItems);
                    adapter.notifyDataSetChanged();
                });
    }
}
