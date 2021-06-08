package com.example.freshshare;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.freshshare.models.FoodItem;
import com.example.freshshare.viewmodels.FoodViewModel;

public class AddFoodItemActivity extends AppCompatActivity {
    FoodViewModel foodViewModel;
    private EditText foodName;
    private EditText foodDescription;
    private EditText imageURL;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_food);

        foodViewModel = new FoodViewModel();
        foodName = findViewById(R.id.foodName);
        foodDescription = findViewById(R.id.foodDescription);
        imageURL = findViewById(R.id.imageURL);
    }

    public void addItem(View view){
        if(foodName.getText().toString().isEmpty()){
            foodName.setError("Please Enter Name of the Food");
            return;
        }
        if(foodDescription.getText().toString().isEmpty()){
            foodDescription.setError("Please Enter the Description of the Food");
            return;
        }
        if(imageURL.getText().toString().isEmpty()){
            imageURL.setError("Please Enter Image URl");
            return;
        }

        FoodItem f = new FoodItem(foodName.getText().toString(),foodDescription.getText().toString(),
                imageURL.getText().toString(), null,null);
        foodViewModel.addItems(f);

        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);

    }

}
