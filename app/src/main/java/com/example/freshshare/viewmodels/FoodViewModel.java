package com.example.freshshare.viewmodels;

import com.example.freshshare.datamodels.DataModel;
import com.example.freshshare.models.FoodItem;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class FoodViewModel {

    private DataModel foodModel;

    public FoodViewModel() {
        foodModel = new DataModel();
    }

    public void addItems(FoodItem f) {
        foodModel.addItem(f);
    }

    public void getItems(Consumer<ArrayList<FoodItem>> responseCallback) {
        foodModel.getItems(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<FoodItem> items = new ArrayList<>();
                        for (DocumentSnapshot itemSnap : querySnapshot.getDocuments()) {
                            FoodItem m = itemSnap.toObject(FoodItem.class);
                            assert m != null;
                            m.uid = itemSnap.getId();
                            items.add(m);
                        }
                        responseCallback.accept(items);
                    }
                },
                (databaseError -> System.out.println("Error reading Todo Items: " + databaseError))
        );
    }

    public void updateItems(FoodItem f) {
        foodModel.updateItemById(f);
    }

    public void clear() {
        foodModel.clear();
    }
}