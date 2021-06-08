package com.example.freshshare.models;

import android.os.Parcel;
import android.os.Parcelable;

public class VendorItem implements Parcelable{
    public String uid;
    public String vendorName;
    public String email;
    public String address;
    public String imageUrl;
    public VendorItem(){

    }

    public VendorItem(String vendorName, String address, String email, String foodType, String imageUrl) {
        this.vendorName = vendorName;
        this.address = address;
        this.email = email;
        this.imageUrl = imageUrl;
    }

    public VendorItem(Parcel in) {
        vendorName = in.readString();
        address = in.readString();
        email = in.readString();
        imageUrl = in.readString();
    }

    public static final Parcelable.Creator<VendorItem> CREATOR = new Parcelable.Creator<VendorItem>() {
        @Override
        public VendorItem createFromParcel(Parcel in) {
            return new VendorItem(in);
        }

        @Override
        public VendorItem[] newArray(int size) {
            return new VendorItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(vendorName);
        dest.writeString(address);
        dest.writeString(email);
        dest.writeString(imageUrl);
    }

    public String getImageUrl() {
        return imageUrl;
    }
}