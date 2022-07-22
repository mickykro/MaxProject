package com.example.maxapp.viewModels;

import android.app.Activity;
import android.content.Context;

import androidx.lifecycle.ViewModel;

import com.example.maxapp.utils.services.ApplicationManager;

public class MainViewModel extends ViewModel {
     private Context context;

    public MainViewModel(Activity activity){
        context = activity.getBaseContext();
        loadData();
    }

    public void loadData(){
        ApplicationManager.getInstance().initApplicationData(context);
    }




}
