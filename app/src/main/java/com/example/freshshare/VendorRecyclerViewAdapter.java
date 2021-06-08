package com.example.freshshare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.freshshare.models.VendorItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class VendorRecyclerViewAdapter extends RecyclerView.Adapter<VendorCardViewHolder> {

    private List<VendorItem> vendorList;

    VendorRecyclerViewAdapter(List<VendorItem> vendorList) {
        this.vendorList = vendorList;
    }

    @NonNull
    @Override
    public VendorCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vendor_card, parent, false);
        return new VendorCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull VendorCardViewHolder holder, int position) {
        if (vendorList != null) {
            VendorItem m = this.vendorList.get(position);
            holder.vendorName.setText(m.vendorName);
            holder.address.setText(m.address);
            holder.email.setText(m.email);
            holder.imageUrl = m.imageUrl;
            Picasso.get().load(m.getImageUrl()).into(holder.vendorImage);
        }
    }

    @Override
    public int getItemCount () {
        return vendorList.size();
    }

    public void setItemsList(List<VendorItem> m) {
        this.vendorList = m;
    }
}