package com.example.maxapp.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.maxapp.R;
import com.example.maxapp.utils.services.ApplicationManager;

import org.w3c.dom.Text;

public class ElementFragment extends Fragment {
    ImageView bg_image;
    TextView tv_title;
    TextView tv_id;


    String url;
    String title;
    String id;

     public ElementFragment(String url, String title, String id){
            this.url = url;
            this.title = title;
            this.id = id;

    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);
        View view =  inflater.inflate(R.layout.element_fragment,container,false);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ApplicationManager.swapToFragment(ApplicationManager.getInstance().getFragmentActivity(),ViewPagerFragment.class,new Bundle(),R.id.main_ly, "VIEW_PAGER_FRAGMENT" );
            }
        });
        bg_image = view.findViewById(R.id.bg_image);
        tv_title = view.findViewById(R.id.tv_category_name);
        tv_id = view.findViewById(R.id.tv_id);
        Glide.with(ApplicationManager.getInstance().getApplicationContext()).load(url).error(ApplicationManager.errorImage())
                .into(bg_image);
        tv_title.setText(title);
        tv_id.setText(id);

     return view;
    }
}
