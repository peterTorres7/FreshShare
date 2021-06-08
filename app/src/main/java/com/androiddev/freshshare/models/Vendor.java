
package com.androiddev.freshshare.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

    @IgnoreExtraProperties
    public class Vendor implements Parcelable {
        public String uid;
        public String address;
        public String email;
        public String imageUrl;
        public String name;


        public Vendor(){

        }

        public Vendor(String name, String address, String imageUrl, String email) {
            this.name = name;
            this.address = address;
            this.imageUrl = imageUrl;
            this.email = email;
        }

        public Vendor(Parcel in) {
            name = in.readString();
            address = in.readString();
            imageUrl = in.readString();
            email = in.readString();
        }

        public static final Creator<com.androiddev.freshshare.models.FoodItem> CREATOR = new Creator<com.androiddev.freshshare.models.FoodItem>() {
            @Override
            public com.androiddev.freshshare.models.FoodItem createFromParcel(Parcel in) {
                return new com.androiddev.freshshare.models.FoodItem(in);
            }

            @Override
            public com.androiddev.freshshare.models.FoodItem[] newArray(int size) {
                return new com.androiddev.freshshare.models.FoodItem[size];
            }
        };

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(name);
            dest.writeString(address);
            dest.writeString(imageUrl);
            dest.writeString(email);
        }

        public String getImageUrl() {
            return imageUrl;
        }

}
