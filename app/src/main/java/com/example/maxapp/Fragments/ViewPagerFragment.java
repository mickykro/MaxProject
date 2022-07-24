package com.example.maxapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import com.example.maxapp.R;
import com.example.maxapp.customViews.TabTextView;
import com.example.maxapp.utils.services.ApplicationManager;
import com.example.maxapp.views.adapters.ViewPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class ViewPagerFragment extends Fragment {
    ViewPager2 view_pager;
    ViewPagerAdapter vpAdapter;
    TabLayout tab_layout;

    @Nullable
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.view_pager_fragment,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        vpAdapter = new ViewPagerAdapter(this);
        view_pager = view.findViewById(R.id.pager);
        view_pager.setAdapter(vpAdapter);
        tab_layout = view.findViewById(R.id.tab_layout);
        new TabLayoutMediator(tab_layout,view_pager, (tab,position) -> {
            tab.setCustomView( new TabTextView(getContext(), ApplicationManager.getTabTextByPosition(position)));
        }).attach();

    }



}
