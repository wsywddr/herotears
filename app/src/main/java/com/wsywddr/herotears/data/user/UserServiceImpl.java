package com.wsywddr.herotears.data.user;

import com.android.volley.Request;
import com.google.gson.reflect.TypeToken;
import com.wsywddr.herotears.model.Response;
import com.wsywddr.herotears.util.AppManager;
import com.wsywddr.herotears.util.RequestURL;
import com.wsywddr.herotears.util.net.DefaultResponseListener;
import com.wsywddr.herotears.util.net.GsonRequest;

import java.util.HashMap;


/**
 * Created by fengxiang on 2016/3/15.
 */
public class UserServiceImpl implements UserService {
    @Override
    public void getBusinessInfo(String uid, DefaultResponseListener<Response<String>> listener) {
        StringBuilder signBuilder = new StringBuilder();
        HashMap<String, String> params = new HashMap<String, String>();
        GsonRequest request = new GsonRequest(Request.Method.POST, RequestURL.API_BUSINESS_INFO, params, null, new TypeToken<Response<String>>() {
        }, listener, listener);
        AppManager.getRequestQueue().add(request);
    }
}
