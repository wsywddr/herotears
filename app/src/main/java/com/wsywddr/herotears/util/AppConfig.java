package com.wsywddr.herotears.util;

import android.content.SharedPreferences;
import android.net.Uri;

public class AppConfig {

    public static String City = "太仓";
    public static final String APP_ID = "22";
    public static final String APP_AUTH_KEY = "674e964809c9cc4e0c40c508b3d1b67265e2167d";
    public static final String RELEASE = "20150106";
    public static final String LOGIN_TYPE = "2";//1返回值用户id，2返回值用户所有信息，3商家登陆
    public static  String AREA_CODE = "86";
    public static final String City_ID = "434";

    public static final String HTTP_OK = "success";
    public static final String HTTP_ERROR = "error";
    public static final String HTTP_WARN = "warn";

    public static final int TAKE_PHOTO = 1;
    public static final int CROP_PHOTO = 2;
    public static final String PREFERENCE_NAME = "APP";

    public static String  Latitude = "0";
    public static String  Longitude = "0";
    public static String  Location = "0";

    public static Uri imageUri; // 图片路径
    public static String filename; // 图片名称
    public static String USER_NAME = "username";
    public static String PASS_WORD = "password";
    public static String USER_HEAD_IMG = "user_head_img";
    public static String USER_ID = "user_id";
    public static String MAIL = "mail";
    public static String TEL_PHONE = "tel_phone";
    public static String IS_LOGIN = "isLogin";
    public static String IS_REMEMBER_PASSWORD = "is_remember_password";

    public static String DATE = "date";
    public static String NICK_NAME = "nickname";
    public static String AVATAR = "avatar";

    public static String IS_SHOW_IMG = "isNoImg";

    //检查是否登陆
    public static boolean isLogin(SharedPreferences preference) {
        return preference.getBoolean(AppConfig.IS_LOGIN, false);
    }

    public static String getUid(SharedPreferences preference){
        return preference.getString(AppConfig.USER_ID, "");
    }

    //获取手机号码
    public static String getTelPhone(SharedPreferences preference){
        return preference.getString(AppConfig.TEL_PHONE,"");
    }

//    //登录成功
//    public static void saveUser(SharedPreferences preference,BaseUserInfo userInfo){
//        SharedPreferences.Editor editor  =  preference.edit();
//        editor.putBoolean(IS_LOGIN,true);
//        editor.putString(PASS_WORD, userInfo.getPassword());
//        editor.putString(USER_ID, userInfo.getId());
//        editor.putString(NICK_NAME,userInfo.getNickname());
//        editor.putString(AVATAR,userInfo.getAvatar());
//        editor.putString(TEL_PHONE,userInfo.getTel());
//        editor.commit();
//    }
//
//    //退出登录
//    public static void UserLogOut(SharedPreferences preference){
//        businessInfo = null;
//        SharedPreferences.Editor editor  =  preference.edit();
//        editor.putBoolean(IS_LOGIN,false);
//        editor.putString(PASS_WORD, "");
//        editor.putString(USER_ID, "");
//        editor.putString(NICK_NAME,"");
//        editor.putString(AVATAR,"");
//        editor.putString(TEL_PHONE,"");
//        editor.commit();
//    }


    public static String getPreferenceBy(SharedPreferences preference,String name){
        return preference.getString(name,"");
    }

    public static void setPreferenceTo(SharedPreferences preference,String name,String value){
        SharedPreferences.Editor editor  =  preference.edit();
        editor.putString(name,value);
        editor.commit();
    }
}
