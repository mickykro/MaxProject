package com.example.maxapp.utils.services;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.maxapp.Fragments.ElementFragment;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.responses.ResponseBase;

import java.util.ArrayList;
import java.util.Arrays;

public class ApplicationManager {
    private static ApplicationManager appData;
    private Context applicationContext;
    private DataListResponse mData;
    private VolleyControllerMock mVolleyMock = new VolleyControllerMock() ;
    static ArrayList  TAB_TITLES = new ArrayList(Arrays.asList("כל ההטבות","הפינוקים שלי","המומלצים","המועדפים"));
    private FragmentActivity fragmentActivity;

    public FragmentActivity getFragmentActivity() {
        return fragmentActivity;
    }

    public void setFragmentActivity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public static ApplicationManager getInstance() {

        appData =  appData == null ? new ApplicationManager() : appData;
        return appData;
    }

    public Context getApplicationContext() {
        return applicationContext;
    }

    public void setApplicationContext(Context applicationContext) {
        this.applicationContext = applicationContext;
    }

    public void initApplicationData(Context context, FragmentActivity activity) {
        setApplicationContext(context);
        setFragmentActivity(activity);
            mVolleyMock.getApplicationData(context, new Response.Listener<ResponseBase>() {
                @Override
                public void onResponse(ResponseBase response) {
                    mData = response.getResponseData();
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    System.out.println(error);
                }
            });

    }
    public static DataListResponse getApplicationData(){
        return appData == null ? null : appData.mData;

    }


    public static String getTabTextByPosition(int position){
        return TAB_TITLES.get(position).toString();
    }

    public static Drawable errorImage(){
        return new Drawable() {

            Paint p = new Paint();

            @Override
            public void draw(@NonNull Canvas canvas) {
                p.setARGB(255,255,0,0);
                p.setTextSize(50f);
                int width = getBounds().width();
                int height = getBounds().height();


                canvas.drawARGB(255,211, 211,211);
                canvas.drawText("אין תמונה להצגה",width/4,height/2,p);
            }

            @Override
            public void setAlpha(int i) {

            }

            @Override
            public void setColorFilter(@Nullable ColorFilter colorFilter) {

            }

            @Override
            public int getOpacity() {
                return PixelFormat.OPAQUE;
            }
        };

    }

    public static Fragment swapToFragment(FragmentActivity activity, Class fragmentClass, Bundle arguments, int containerResourceId, String fragmentTag) {
        Fragment fragment = null;

        try {
            fragment = activity.getSupportFragmentManager().findFragmentByTag(fragmentTag);
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(arguments);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(containerResourceId, fragment, fragmentTag);
            fragmentTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    } public static Fragment swapToFragment(FragmentActivity activity, ElementFragment fragment, Bundle arguments, int containerResourceId, String fragmentTag) {
        try {
            FragmentTransaction fragmentTransaction = activity.getSupportFragmentManager().beginTransaction();
            fragment.setArguments(arguments);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.replace(containerResourceId, fragment, fragmentTag);
            fragmentTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }








}
