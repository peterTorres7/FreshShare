package com.androiddev.freshshare;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class VendorCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView vendorImage;
    public TextView vendorName;
    public String imageUrl;
    public TextView address;
    public TextView email;


    public VendorCardViewHolder(@NonNull View itemView) {
        super(itemView);
        vendorImage = itemView.findViewById(R.id.vendor_image);
        vendorName = itemView.findViewById(R.id.vendor_name);
        address = itemView.findViewById(R.id.vendor_address);
        email = itemView.findViewById(R.id.vendor_email);
    }
}