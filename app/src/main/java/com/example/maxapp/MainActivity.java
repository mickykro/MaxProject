package com.example.maxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.maxapp.Fragments.ViewPagerFragment;
import com.example.maxapp.utils.services.ApplicationManager;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        ApplicationManager.getInstance().initApplicationData(getBaseContext(),this);
        ApplicationManager.swapToFragment(this,ViewPagerFragment.class,new Bundle(),R.id.main_ly, "VIEW_PAGER_FRAGMENT");
    }

    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }


}