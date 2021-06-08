package com.example.freshshare.datamodels;

import com.example.freshshare.models.Vendor;
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

public class VendorDataModel {
    private FirebaseFirestore db;
    private List<ListenerRegistration> listeners;

    public VendorDataModel() {
        db = FirebaseFirestore.getInstance();
        listeners = new ArrayList<>();
    }

    public void addItem(Vendor f) {
        CollectionReference todoItemsRef = db.collection("Vendor_Items");
        todoItemsRef.add(f);
    }

    public void getItems(Consumer<QuerySnapshot> dataChangedCallback, Consumer<FirebaseFirestoreException> dataErrorCallback) {
        ListenerRegistration listener = db.collection("Vendor_Items")
                .addSnapshotListener((queryDocumentSnapshots, e) -> {
                    if (e != null) {
                        dataErrorCallback.accept(e);
                    }

                    dataChangedCallback.accept(queryDocumentSnapshots);
                });
        listeners.add(listener);
    }

    public void updateItemById(Vendor f) {
        DocumentReference todoItemRef = db.collection("Vendor_Items").document(f.uid);
        Map<String, Object> data = new HashMap<>();
        data.put("vendorName", f.name);
        data.put("address", f.address);
        data.put("email", f.email);
        data.put("imageUrl", f.imageUrl);
        todoItemRef.update(data);
    }

    public void clear() {
        // Clear all the listeners onPause
        listeners.forEach(ListenerRegistration::remove);
    }
}