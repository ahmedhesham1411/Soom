package com.example.soomtest.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soomtest.Main_Cat_Resault;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.R;

import java.util.List;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class MainCatAdapter extends RecyclerView.Adapter<MainCatAdapter.ViewHolder> {

    List<MainCategoryModel> mainCategoryModels;
    Context context;
    //private final OnClickHander onClickHander;

    public MainCatAdapter(List<MainCategoryModel> mainCategoryModels, Context context) {
        this.mainCategoryModels = mainCategoryModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.home_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.imageView.setImageResource(mainCategoryModels.get(position).getImage());
        holder.textView.setText(mainCategoryModels.get(position).getName());


        holder.linearLayoutCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mainCategoryModels.get(position).getMain_Cat_Id() == 2){
                    //Toast.makeText(context, mainCategoryModels.get(position).getName(), Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(context, Main_Cat_Resault.class);
                    intent.putExtra("cat_name",mainCategoryModels.get(position).getName());
                    intent.putExtra("cat_id",mainCategoryModels.get(position).getMain_Cat_Id());
                    intent.addFlags(FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }

            }
        });
    }

    @Override
    public int getItemCount() {
        return mainCategoryModels.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView imageView;
        TextView textView;
        LinearLayoutCompat linearLayoutCompat;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutCompat = itemView.findViewById(R.id.home_item);
            imageView = itemView.findViewById(R.id.home_rec_image);
            textView = itemView.findViewById(R.id.home_rec_text);
        }

        @Override
        public void onClick(View v) {

        }
    }
}
