package com.example.maxapp.utils.services;

import android.content.Context;
import android.util.DisplayMetrics;

public class ScreenUtils {

    public static int getScreenWidth(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.widthPixels;
    }
    public static int getScreenHeight(Context context){
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        return metrics.heightPixels;
    }


}
