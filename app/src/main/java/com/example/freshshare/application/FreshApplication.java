package com.example.freshshare.application;

import android.app.Application;
import android.content.Context;
import androidx.appcompat.app.AppCompatDelegate;

public class FreshApplication extends Application {
    private static FreshApplication instance;
    private static Context appContext;

    public static FreshApplication getInstance() {
        return instance;
    }

    public static Context getAppContext() {
        return appContext;
    }

    public void setAppContext(Context mAppContext) {
        this.appContext = mAppContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        this.setAppContext(getAppContext());
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }
}