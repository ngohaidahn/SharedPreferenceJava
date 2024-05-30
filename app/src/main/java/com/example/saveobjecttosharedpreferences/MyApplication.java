package com.example.saveobjecttosharedpreferences;

import android.app.Application;

import com.example.saveobjecttosharedpreferences.data_local.DataLocalManager;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //khoi tao datalocalmanager
        DataLocalManager.init(getApplicationContext());
    }
}
