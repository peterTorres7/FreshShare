package com.example.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;

import static androidx.core.content.ContextCompat.startActivity;


public class FoodCardViewHolder extends RecyclerView.ViewHolder {

    public ImageView matchImage;
    public TextView name;
    public TextView about;
    public String imageUrl;
    public String aboutFull;

    public FoodCardViewHolder(@NonNull View itemView) {
        super(itemView);
        matchImage = itemView.findViewById(R.id.match_image);
        name = itemView.findViewById(R.id.food_name);
        about = itemView.findViewById(R.id.food_about);

        matchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle b = new Bundle();
                b.putString(Constants.KEY_NAME, name.getText().toString());
                b.putString(Constants.KEY_ABOUT, aboutFull);
                b.putString(Constants.KEY_URL, imageUrl);

                Intent intent = new Intent(matchImage.getContext(),FoodDescriptionActivity.class);
                intent.putExtras(b);
                matchImage.getContext().startActivity(intent);
            }
        });
    }




}