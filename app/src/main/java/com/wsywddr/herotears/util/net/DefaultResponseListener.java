package com.wsywddr.herotears.util.net;

import com.android.volley.Response;
import com.android.volley.VolleyError;

/**
 * Created by fengxiang on 2016/1/21.
 */
public abstract class DefaultResponseListener<T> implements Response.Listener<T>, Response.ErrorListener {

    @Override
    public void onResponse(T response) {
        onSuccess(response);
    }

    @Override
    public void onErrorResponse(VolleyError error) {
        onError(error);
    }

    public abstract void onSuccess(T response);

    public abstract void onError(VolleyError error);

}
