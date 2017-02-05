package com.hackathon.csec.foodie;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by sahil on 4/2/17.
 */

public class SharedPref {
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;
    private static  final  String PREF_NAME="userData";
    private static  final String  LOGIN_STATUS="loginStatus";
    private static  final  String USER_KEY="apiKey";
    private static  final  String HAS_SKIP="hasSkip";

    public SharedPref(Context context) {
        sharedPref=context.getSharedPreferences(PREF_NAME,0);
        editor=sharedPref.edit();
    }

    public void setLoginStatus(boolean isLogIn){
        editor.putBoolean(LOGIN_STATUS,isLogIn);
        editor.commit();
    }
    public  boolean getLoginStatus(){
        return  sharedPref.getBoolean(LOGIN_STATUS,false);
    }

    public  void setUserKey(String key){
        editor.putString(USER_KEY,key);
        editor.commit();
    }

    public  String getUserKey(){
        return  sharedPref.getString(USER_KEY,"");
    }

    public  void setLoginSkipStatus(boolean hasSkip){
        editor.putBoolean(HAS_SKIP,hasSkip);
        editor.commit();
    }

    public boolean getLoginSkipStatus(){
        return sharedPref.getBoolean(HAS_SKIP,false);
    }
}
