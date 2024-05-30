package com.example.saveobjecttosharedpreferences.data_local;

import android.content.Context;

import com.example.saveobjecttosharedpreferences.model.User;
import com.google.gson.Gson;
import com.google.gson.JsonArray;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class DataLocalManager {
    //key luu 1 cai string
    private static final String PREF_OBJECT_USER = "PREF_OBJECT_USER";
    private static final String PREF_LIST_USER = "PREF_LIST_USER";
    //dinh nghia xem luu gi vao Shared


    private static DataLocalManager instance;
    private MySharedPreferences mySharedPreferences;

    public static void init(Context context) {
        //ham khoi tao
        instance = new DataLocalManager();
        instance.mySharedPreferences = new MySharedPreferences(context);
    }

    public static DataLocalManager getInstance() {
        if (instance == null) {
            instance = new DataLocalManager();
        }
        return instance;
    }

    public static void setUser(User user) {
        //su dung gson de convert 1 cai object ra 1 string.jon
        Gson gson = new Gson();
        String strJsonUser = gson.toJson(user);

        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_OBJECT_USER, strJsonUser);

    }

    public static User getUser() {
        String strJsonUser = DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_OBJECT_USER);
        Gson gson = new Gson();
        User user = gson.fromJson(strJsonUser, User.class);
        return user;
    }

    public static void setListUser(List<User> listUser) {
        Gson gson = new Gson();
        JsonArray jsonArray = gson.toJsonTree(listUser).getAsJsonArray();
        String strJsonArray = jsonArray.toString();
        DataLocalManager.getInstance().mySharedPreferences.putStringValue(PREF_LIST_USER, strJsonArray);

    }

    public static List<User> getListUser() {
        String strJsonArray = DataLocalManager.getInstance().mySharedPreferences.getStringValue(PREF_LIST_USER);
        List<User> userList = new ArrayList<>();
        try {
            JSONArray jsonArray = new JSONArray(strJsonArray);//
            JSONObject jsonObject;
            User user;
            Gson gson = new Gson();
            for (int i = 0; i < jsonArray.length(); i++) {
                jsonObject = jsonArray.getJSONObject(i);
                user = gson.fromJson(jsonObject.toString(), User.class);
                userList.add(user);
            }
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return userList;
    }


}
