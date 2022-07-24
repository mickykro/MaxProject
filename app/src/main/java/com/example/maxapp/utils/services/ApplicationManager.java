package com.example.maxapp.utils.services;

import android.content.Context;

import com.android.volley.Response;
import com.android.volley.VolleyError;
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

    public void initApplicationData(Context context) {
        setApplicationContext(context);
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






}
