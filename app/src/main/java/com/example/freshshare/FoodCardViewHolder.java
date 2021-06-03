package com.example.freshshare;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.toolbox.NetworkImageView;
import com.example.freshshare.models.FoodItem;

public class FoodCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView matchImage;
    public TextView name;
    public TextView about;

    public FoodCardViewHolder(@NonNull View itemView) {
        super(itemView);
        matchImage = itemView.findViewById(R.id.match_image);
        name = itemView.findViewById(R.id.food_name);
        about = itemView.findViewById(R.id.food_about);
    }


}