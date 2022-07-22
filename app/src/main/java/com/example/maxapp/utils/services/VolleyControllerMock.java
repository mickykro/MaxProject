package com.example.maxapp.utils.services;

import android.content.Context;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.responses.ResponseBase;

public class VolleyControllerMock {

    public VolleyControllerMock() {
        super();
    }

    public void getApplicationData(Context iContext, Response.Listener<ResponseBase> responseListener, Response.ErrorListener paramErrorListener) {
        responseListener.onResponse((ResponseBase) MockUtils.getInstance().getResponse(ResponseBase.class, iContext, "appData.json"));
    }
}
