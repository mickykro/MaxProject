package com.example.maxapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.responses.ResponseBase;
import com.example.maxapp.utils.services.VolleyControllerMock;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        VolleyControllerMock mVolleyMock = new VolleyControllerMock();
        mVolleyMock.getApplicationData(getApplicationContext(), new Response.Listener<ResponseBase>() {
            @Override
            public void onResponse(ResponseBase response) {
                System.out.println(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                System.out.println(error);
            }
        });
    }



}