package com.example.maxapp.customViews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

public class CategoriesRecyclerView extends RecyclerView {


    public void init(){
        this.getLayoutManager().scrollToPosition(this.getChildCount()-1);
    }

    public CategoriesRecyclerView(@NonNull Context context) {
        super(context);
        init();
    }

    public CategoriesRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CategoriesRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }
}
