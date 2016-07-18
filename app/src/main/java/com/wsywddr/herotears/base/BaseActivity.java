package com.wsywddr.herotears.base;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wsywddr.herotears.util.AppConfig;
import com.wsywddr.herotears.util.AppManager;

public class BaseActivity extends Activity {

    protected SharedPreferences preference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AppManager.activities.add(this);
        super.onCreate(savedInstanceState);
        preference = getSharedPreferences(AppConfig.PREFERENCE_NAME, Context.MODE_PRIVATE);
        AppManager.setPreferences(preference);
    }

}
