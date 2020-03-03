package com.example.soomtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soomtest.Main_Cat_Resault;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.Model.Search_model;
import com.example.soomtest.R;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder> {

    List<Search_model> search_models;
    Context context;

    public SearchAdapter(List<Search_model> search_models,Context context) {
        this.search_models = search_models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.search_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(search_models.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return search_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        AppCompatImageView imageView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.serch_item);
        }

    }
}
