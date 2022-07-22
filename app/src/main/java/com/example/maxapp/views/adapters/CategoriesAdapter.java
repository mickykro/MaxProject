package com.example.maxapp.views.adapters;

import android.content.Context;
import android.view.DragEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.maxapp.R;
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

    public CategoriesAdapter(){
        DataListResponse data =  ApplicationManager.getInstance().getApplicationData();
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

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        int height = ScreenUtils.getScreenHeight(context) / 3;
        ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
        holder.tv_category.setText(CategoryEnum.getNameByValue(mData.getmDataListCategory().get(position).getmCatId()));
        params.height = height;
        holder.itemView.setLayoutParams(params);

        DataListAdapter adapter = new DataListAdapter(getArrayByCategory(mData.getmDataListCategory().get(position).getmCatId()));
        holder.rv_category.setAdapter(adapter);
        holder.rv_category.setOnDragListener(new View.OnDragListener() {
            @Override
            public boolean onDrag(View view, DragEvent dragEvent) {
                return false;
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

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            rv_category = itemView.findViewById(R.id.rv_category);
            tv_category = itemView.findViewById(R.id.tv_category);

            LinearLayoutManager layoutManager
                    = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
            rv_category.setLayoutManager(layoutManager);
            rv_category.setPadding(10,10,10,10);



        }

    }
}
