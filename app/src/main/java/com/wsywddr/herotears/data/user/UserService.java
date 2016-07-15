package com.wsywddr.herotears.data.user;

import com.wsywddr.herotears.model.Response;
import com.wsywddr.herotears.util.net.DefaultResponseListener;

/**
 * Created by admin on 2016/3/15.
 */
public interface UserService {

    /**
     * 获取商家信息
     * @param uid
     * @param listener
     */
    public void getBusinessInfo(String uid, DefaultResponseListener<Response<String>> listener);
}
