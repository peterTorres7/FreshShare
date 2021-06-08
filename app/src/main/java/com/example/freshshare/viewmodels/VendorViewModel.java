package com.example.freshshare.viewmodels;

import com.example.freshshare.datamodels.VendorDataModel;
import com.example.freshshare.models.VendorItem;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class VendorViewModel {

    private VendorDataModel vendorModel;

    public VendorViewModel() {
        vendorModel = new VendorDataModel();
    }

    public void addItems(VendorItem f) {
        vendorModel.addItem(f);
    }

    public void getItems(Consumer<ArrayList<VendorItem>> responseCallback) {
        vendorModel.getItems(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<VendorItem> items = new ArrayList<>();
                        for (DocumentSnapshot itemSnap : querySnapshot.getDocuments()) {
                            VendorItem m = itemSnap.toObject(VendorItem.class);
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

    public void updateItems(VendorItem f) {
        vendorModel.updateItemById(f);
    }

    public void clear() {
        vendorModel.clear();
    }
}