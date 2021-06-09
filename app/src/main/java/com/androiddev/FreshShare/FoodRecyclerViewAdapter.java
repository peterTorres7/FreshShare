package com.androiddev.FreshShare;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.androiddev.FreshShare.models.FoodItem;
import com.squareup.picasso.Picasso;

import java.util.List;


/**
 * Adapter used to show a simple grid of products.
 */
public class FoodRecyclerViewAdapter extends RecyclerView.Adapter<FoodCardViewHolder> {

    private List<FoodItem> foodList;

    FoodRecyclerViewAdapter(List<FoodItem> foodList) {
        this.foodList = foodList;
    }

    @NonNull
    @Override
    public FoodCardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.food_card, parent, false);
        return new FoodCardViewHolder(layoutView);
    }

    @Override
    public void onBindViewHolder(@NonNull FoodCardViewHolder holder, int position) {
        if (foodList != null) {
            FoodItem m = this.foodList.get(position);
            holder.name.setText(m.name);
            holder.aboutFull = m.about;
            String aboutBrief = m.about.substring(0,m.about.length()/2);
            holder.about.setText(aboutBrief);
            holder.imageUrl = m.imageUrl;
            Picasso.get().load(m.getImageUrl()).into(holder.matchImage);
        }
    }

    @Override
    public int getItemCount () {
        return foodList.size();
    }

    public void setItemsList(List<FoodItem> m) {
        this.foodList = m;
    }
}