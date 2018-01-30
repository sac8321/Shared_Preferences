package com.example.proyecto_pc.my_login.utils;

import android.content.SharedPreferences;

/**
 * Created by JORGE-PC on 29/01/2018.
 */

public class Util {


    public static String getUserMailPrefs(SharedPreferences preferences){
        return preferences.getString("email","");
    }


    public static String getUserPassPrefs(SharedPreferences preferences)
    {
        return preferences.getString("password","");
    }


}
