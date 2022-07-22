package com.example.maxapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.AttributeSet;
import android.util.LayoutDirection;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.maxapp.Fragments.BaseListFragment;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.responses.ResponseBase;
import com.example.maxapp.utils.services.VolleyControllerMock;
import com.example.maxapp.viewModels.MainViewModel;

public class MainActivity extends AppCompatActivity {

    private MainViewModel MV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MV = new MainViewModel(this);
        Fragment baseList = new BaseListFragment();
        swapToFragment(BaseListFragment.class,new Bundle(),R.id.main_ly,false,false,LayoutDirection.RTL,(View[])null);

    }

    @Override
    public View onCreateView(@NonNull String name, @NonNull Context context, @NonNull AttributeSet attrs) {
        return super.onCreateView(name, context, attrs);
    }

    public Fragment swapToFragment(Class<? extends Fragment> fragmentClass, Bundle arguments, int containerResourceId, boolean isShouldAddToBackStack, boolean iShouldAnimate, int layoutDirection, View... sharedElements) {
        Fragment fragment = null;

        try {
            fragment = getSupportFragmentManager().findFragmentByTag("fragmentTag");
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragment = fragmentClass.newInstance();
            fragment.setArguments(arguments);

            if (sharedElements != null) {
                for (View sharedElement : sharedElements) {
                    fragmentTransaction.addSharedElement(sharedElement, sharedElement.getTransitionName());
                }
            }

            fragmentTransaction.replace(containerResourceId, fragment, "fragmentTag");
            fragmentTransaction.commit();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return fragment;
    }
}