
package com.example.freshshare.models;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class FoodItem implements Parcelable {
    public String uid;
    public String name;
    public String about;
    public String imageUrl;
    public String lat;
    public String longitude;

    public FoodItem(){

    }

    public FoodItem(String name, String about, String imageUrl, String lat, String longitude) {
        this.name = name;
        this.about = about;
        this.imageUrl = imageUrl;
        this.lat = lat;
        this.longitude = longitude;
    }

    public FoodItem(Parcel in) {
        name = in.readString();
        about = in.readString();
        imageUrl = in.readString();
        lat = in.readString();
        longitude = in.readString();
    }

    public static final Creator<FoodItem> CREATOR = new Creator<FoodItem>() {
        @Override
        public FoodItem createFromParcel(Parcel in) {
            return new FoodItem(in);
        }

        @Override
        public FoodItem[] newArray(int size) {
            return new FoodItem[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(about);
        dest.writeString(imageUrl);
        dest.writeString(lat);
        dest.writeString(longitude);
    }

    public String getImageUrl() {
        return imageUrl;
    }
}