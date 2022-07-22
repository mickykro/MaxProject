package com.example.maxapp.views.adapters;

import android.content.Context;
import android.media.Image;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.maxapp.R;
import com.example.maxapp.entities.DataObject;
import com.example.maxapp.responses.DataListResponse;
import com.example.maxapp.utils.services.ScreenUtils;

import java.sql.Array;
import java.util.ArrayList;

public class DataListAdapter extends RecyclerView.Adapter<DataListAdapter.ViewHolder> {

    private ArrayList<DataObject> mData = new ArrayList<>();
    private Context context;

    public DataListAdapter(ArrayList<DataObject> data){
        mData.addAll(data);
    }

    @Override
    public DataListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.data_object_adapter,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull DataListAdapter.ViewHolder holder, int position) {
        if(!mData.isEmpty()){

            //TODO: set height width
            //toDO: set backGround
            //TODO: set font
            ViewGroup.LayoutParams params = holder.itemView.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams =(ViewGroup.MarginLayoutParams) holder.itemView.getLayoutParams();
            int height = ScreenUtils.getScreenHeight(context) / 4;
            int width = ScreenUtils.getScreenWidth(context) / 2;
            params.height = height;
            params.width = width;
            marginLayoutParams.setMargins(5,6,5,6);
            DataObject current = mData.get(position);
            holder.itemView.setLayoutParams(params);
            String sourceString = "<b>" + current.getmTitle() + "</b>  - " + current.getmSTitle();
            holder.tv_title.setText(Html.fromHtml(sourceString));
            Glide.with(this.context).load(current.getmImage()).into(holder.bg_image);

        }

    }


    @Override
    public int getItemCount() {
        return mData.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv_title;
        ImageView bg_image;

        View.OnClickListener onClickListener;

         public ViewHolder(@NonNull View itemView) {
             super(itemView);
             tv_title = itemView.findViewById(R.id.tv_title);
             bg_image = itemView.findViewById(R.id.bg_image);



         }
     }
}
