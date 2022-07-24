package com.example.maxapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxapp.R;
import com.example.maxapp.customViews.CategoriesRecyclerView;
import com.example.maxapp.utils.services.ApplicationManager;
import com.example.maxapp.views.adapters.CategoriesAdapter;

public class BaseListFragment extends Fragment {
    public LinearLayout base_list;
    private RecyclerView rv_categories;
    private CategoriesAdapter ct_adapter;

    int tabId;

    public BaseListFragment(int tabId) {
        this.tabId = tabId;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view =  inflater.inflate(R.layout.base_list_fragment,container,false);
         base_list = view.findViewById(R.id.base_list_fragment);
         rv_categories = view.findViewById(R.id.main_rv);
         CategoriesAdapter adapter = new CategoriesAdapter(isRecommended());
         int count = adapter.getItemCount();
         rv_categories.setAdapter(adapter);
        LinearLayoutManager layoutManager
                = new LinearLayoutManager(ApplicationManager.getInstance().getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        rv_categories.setLayoutManager(layoutManager);

        return view;
    }

    private Boolean isRecommended(){
        return ApplicationManager.getTabTextByPosition(tabId).equals("המומלצים");
    }

}
