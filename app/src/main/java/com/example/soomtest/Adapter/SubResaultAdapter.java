package com.example.soomtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soomtest.Model.Sub_Cat_Model;
import com.example.soomtest.Model.Sub_Resault_Model;
import com.example.soomtest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubResaultAdapter extends RecyclerView.Adapter<SubResaultAdapter.ViewHolder> {

    List<Sub_Resault_Model> sub_resault_models;
    Context context;
    private final OnClickHander2 onClickHandler2;

    public interface OnClickHander2 {
        void ooonClick(int position);
    }

    public SubResaultAdapter(List<Sub_Resault_Model> sub_resault_models, Context context, OnClickHander2 onClickHandler2) {
        this.sub_resault_models = sub_resault_models;
        this.context = context;
        this.onClickHandler2 = onClickHandler2;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sub_resault,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.textView.setText(sub_resault_models.get(position).getName());
        holder.circleImageView.setImageResource(sub_resault_models.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return sub_resault_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        LinearLayoutCompat show_sub_child_item;
        CircleImageView circleImageView;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            show_sub_child_item = itemView.findViewById(R.id.show_sub_child_item);
            circleImageView = itemView.findViewById(R.id.sub_resault_image);
            textView = itemView.findViewById(R.id.sub_resault_name);
            show_sub_child_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            onClickHandler2.ooonClick(position);
            notifyDataSetChanged();
        }
    }
}
