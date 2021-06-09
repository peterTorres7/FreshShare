package com.androiddev.FreshShare.datamodels;

import com.androiddev.FreshShare.models.FoodItem;
import com.androiddev.FreshShare.models.Vendor;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.ListenerRegistration;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class DataModel {

    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public DataModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void addItem(FoodItem f) {
        CollectionReference foodItemRef = db.collection("Food_Items");
        foodItemRef.add(f);
    }

    public void addVendor(Vendor v) {
        CollectionReference vendorRef = db.collection("Vendor_Items");
        vendorRef.add(v);
    }

    public void getItems(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("Food_Items")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    public void getVendors(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("Vendor_Items")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    public void updateItemById(FoodItem f) {
        DocumentReference todoItemRef = db.collection("Food_Items").document(f.uid);
        Map<String, Object> data = new HashMap<>();
        data.put("name", f.name);
        data.put("about", f.about);
        data.put("imageUrl", f.imageUrl);
        data.put("lat", f.lat);
        data.put("longitude",f.longitude);
        todoItemRef.update(data);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(ListenerRegistration::remove);
    }
}