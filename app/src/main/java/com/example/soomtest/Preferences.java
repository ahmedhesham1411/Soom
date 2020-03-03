package com.example.soomtest;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferences {

    public static void saveImagePosition(Context context, int position){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("image", position);
        editor.commit();
    }

    public static int getImagePosition(Context context){
        SharedPreferences pref = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        return pref.getInt("image",0);
    }

}
