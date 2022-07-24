package com.example.maxapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;

import com.example.maxapp.Fragments.ViewPagerFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);


        swapToFragment(ViewPagerFragment.class,new Bundle(),R.id.main_ly, "VIEW_PAGER_FRAGMENT");

    }

    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public Fragment swapToFragment(Class fragmentClass, Bundle arguments, int containerResourceId,  String fragmentTag) {
        Fragment fragment = null;

        try {
            fragment = getSupportFragmentManager().findFragmentByTag(fragmentTag);
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment = (Fragment) fragmentClass.newInstance();
            fragment.setArguments(arguments);


            fragmentTransaction.replace(containerResourceId, fragment, "fragmentTag");
            fragmentTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }

}