package com.example.soomtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soomtest.Main_Cat_Resault;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.Model.Price_model;
import com.example.soomtest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class PriceAdapter extends RecyclerView.Adapter<PriceAdapter.ViewHolder> {

    List<Price_model> price_models;
    Context context;

    public PriceAdapter(List<Price_model> price_models, Context context) {
        this.price_models = price_models;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.price_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(price_models.get(position).getImage());
        String price = String.valueOf(price_models.get(position).getPrice());
        holder.textView.setText(price);
    }


    @Override
    public int getItemCount() {
        return price_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        CircleImageView imageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.price_image);
            textView = itemView.findViewById(R.id.txt_price);
        }
    }
}
