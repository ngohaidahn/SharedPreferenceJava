package com.example.saveobjecttosharedpreferences.data_local;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.HashSet;
import java.util.Set;

public class MySharedPreferences {
    //viet ham put,get
    private static final String MY_SHARED_PREFERENCES = "MY_SHARED_PREFERENCES";
    private Context mContext; //bien moi truong

    public MySharedPreferences(Context mContext) {
        this.mContext = mContext;
    }
    //kieu true, false



    //luu du lieu dang String
    public void putStringValue(String key, String value) {
        //ham put du lieu vao
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue(String key) {
        //ham lay du lieu ra
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCES, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, "");
    }



}
