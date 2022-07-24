package com.example.maxapp.views.adapters;

import android.content.Context;
import android.os.Build;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.maxapp.R;
import com.example.maxapp.entities.DataCategory;
import com.example.maxapp.entities.DataObject;
import com.example.maxapp.enums.CategoryEnum;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.utils.services.ApplicationManager;
import com.example.maxapp.utils.services.ScreenUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.function.Predicate;

public class CategoriesAdapter extends RecyclerView.Adapter<CategoriesAdapter.ViewHolder> {
    Context context;
    private DataListResponse mData ;
    private Boolean isRecommended;

    public CategoriesAdapter(Boolean isRecommended){
        DataListResponse data =  ApplicationManager.getInstance().getApplicationData();
        this.isRecommended = isRecommended;
        if(data != null ){
            mData = data;
        }else {
            mData = new DataListResponse();
        }

    }

    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new CategoriesAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.category_adapter,parent, false));
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        int height = ScreenUtils.getScreenHeight(context) / 3;
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        ArrayList<DataCategory> categoryList = (ArrayList<DataCategory>) mData.getmDataListCategory().clone();
        if(!isRecommended) Collections.shuffle(categoryList);
        holder.tv_category.setText(CategoryEnum.getNameByValue(categoryList.get(position).getmCatId()));
        params.height = height;
        holder.itemView.setLayoutParams(params);

        DataListAdapter adapter = new DataListAdapter(getArrayByCategory(categoryList.get(position).getmCatId()));
        holder.rv_category.setAdapter(adapter);
        holder.rv_category.getLayoutManager().scrollToPosition(getArrayByCategory(categoryList.get(position).getmCatId()).size()-1);
        holder.tv_category.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Boolean c = b;
            }
        });
        holder.rv_category.setOnFlingListener(new RecyclerView.OnFlingListener() {
            @Override
            public boolean onFling(int velocityX, int velocityY) {

                return false;
            }
        });
        holder.rv_category.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                System.out.println(b);
            }
        });
        holder.rv_category.setOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if(newState == RecyclerView.SCROLL_STATE_IDLE ){
                    LinearLayoutManager lm = (LinearLayoutManager)holder.rv_category.getLayoutManager();
                    int a = lm.findFirstCompletelyVisibleItemPosition();

                    if(a >= 0) {
                        View v = lm.findViewByPosition(a);
                        int offset = v.getTop();
                        lm.scrollToPositionWithOffset(a,offset);
                    }else {
                        View v = lm.findViewByPosition(holder.pos-1);
                        int offset = v.getTop();
                        lm.scrollToPositionWithOffset(holder.pos-1,offset);
                    }
                    holder.setPos(a);
                }

            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
            }
        });
        holder.tv_category.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {
                System.out.println(view.toString() + "|" + i + "|" + i1);
            }
        });

    }

    private ArrayList<DataObject> getArrayByCategory(int category){
        ArrayList<DataObject> res = new ArrayList<>();
        for (DataObject obj: mData.getmDataListObject()
             ) {
            if(obj.getmCatId() == category) res.add(obj);
        }
        return res;
    }
//    private ArrayList<DataObject> getArrayByCategory(int category){
//        return mData.getmDataListObject().stream().filter(object -> object.getmCatId() == category);
//    }




    @Override
    public int getItemCount() {
        return mData.getmDataListCategory().size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        RecyclerView rv_category;
        TextView tv_category;
        int pos;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_category = itemView.findViewById(R.id.rv_category);
            tv_category = itemView.findViewById(R.id.tv_category);

            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rv_category.setLayoutManager(layoutManager);
            rv_category.setPadding(10,10,10,10);
            setPos(rv_category.getChildCount());


        }

        public void setPos(int pos) {
            this.pos = pos;
        }
    }
}
