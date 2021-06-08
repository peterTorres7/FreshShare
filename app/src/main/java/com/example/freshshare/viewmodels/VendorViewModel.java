package com.example.freshshare.viewmodels;


import com.example.freshshare.datamodels.DataModel;
import com.example.freshshare.models.Vendor;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.function.Consumer;

public class VendorViewModel {

    private DataModel vendorModel;

    public VendorViewModel() {
        vendorModel = new DataModel();
    }

    public void addVendor(Vendor v) {
        vendorModel.addVendor(v);
    }

    public void getVendors(Consumer<ArrayList<Vendor>> responseCallback) {
        vendorModel.getVendors(
                (QuerySnapshot querySnapshot) -> {
                    if (querySnapshot != null) {
                        ArrayList<Vendor> vendors = new ArrayList<>();
                        for (DocumentSnapshot itemSnap : querySnapshot.getDocuments()) {
                            Vendor m = itemSnap.toObject(Vendor.class);
                            assert m != null;
                            m.uid = itemSnap.getId();
                            vendors.add(m);
                        }
                        responseCallback.accept(vendors);

                    }
                },
                (databaseError -> System.out.println("Error reading Todo Items: " + databaseError))
        );
    }


    public void clear() {
        vendorModel.clear();
    }
}