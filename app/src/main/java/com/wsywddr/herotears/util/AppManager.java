package com.wsywddr.herotears.util;

import android.content.SharedPreferences;

import com.android.volley.RequestQueue;
import com.google.gson.Gson;
import com.wsywddr.herotears.base.BaseActivity;
import com.wsywddr.herotears.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

public class AppManager {

    public static List<BaseActivity> activities = new ArrayList<BaseActivity>();
    public static List<BaseFragment> fragments = new ArrayList<BaseFragment>();
    //选择分类activity
    public static List<BaseActivity> classActivities = new ArrayList<BaseActivity>();

    private static SharedPreferences preferences;

    private static RequestQueue requestQueue;

    private static Gson gson;

    public static SharedPreferences getPreferences() {
        return preferences;
    }

    public static void setPreferences(SharedPreferences preferences) {
        AppManager.preferences = preferences;
    }

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    public static void setRequestQueue(RequestQueue requestQueue) {
        AppManager.requestQueue = requestQueue;
    }

    public static Gson getGson() {
        return gson;
    }

    public static void setGson(Gson gson) {
        AppManager.gson = gson;
    }

}
