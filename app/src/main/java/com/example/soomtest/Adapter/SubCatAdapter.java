package com.example.soomtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soomtest.Model.Sub_Cat_Model;
import com.example.soomtest.R;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class SubCatAdapter extends RecyclerView.Adapter<SubCatAdapter.ViewHolder> {

    List<Sub_Cat_Model> sub_cat_models;
    Context context;
    private final OnClickHander1 onClickHandler1;

    public interface OnClickHander1 {
        void oonClick(int position);
    }

    public SubCatAdapter(List<Sub_Cat_Model> sub_cat_models, Context context,OnClickHander1 onClickHandler1) {
        this.sub_cat_models = sub_cat_models;
        this.context = context;
        this.onClickHandler1 = onClickHandler1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.sub_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, final int position) {
        Boolean FavStatus = sub_cat_models.get(position).getFavourite();
        if (FavStatus == true){
            holder.emptyFav.setVisibility(View.GONE);
            holder.fullFav.setVisibility(View.VISIBLE);
        }
        else if (FavStatus == false){
            holder.fullFav.setVisibility(View.GONE);
            holder.emptyFav.setVisibility(View.VISIBLE);
        }
        holder.circleImageView.setImageResource(sub_cat_models.get(position).getImage());
        holder.textView.setText(sub_cat_models.get(position).getName());

        holder.emptyFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.emptyFav.setVisibility(View.GONE);
                holder.fullFav.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                holder.fullFav.startAnimation(myAnim);

            }
        });
        holder.fullFav.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                holder.fullFav.setVisibility(View.GONE);
                holder.emptyFav.setVisibility(View.VISIBLE);

                Animation myAnim = AnimationUtils.loadAnimation(context, R.anim.pop_anim);
                // Use bounce interpolator with amplitude 0.2 and frequency 20
                MyBounceInterpolator interpolator = new MyBounceInterpolator(0.2, 20);
                myAnim.setInterpolator(interpolator);
                holder.emptyFav.startAnimation(myAnim);

            }
        });
/*
        holder.linearLayoutCompat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, sub_cat_models.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });*/

    }

    @Override
    public int getItemCount() {
        return sub_cat_models.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView fullFav,emptyFav;
        CircleImageView circleImageView;
        TextView textView;
        LinearLayoutCompat linearLayoutCompat,show_sub_item;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            linearLayoutCompat = itemView.findViewById(R.id.sub_item_layout);
            emptyFav = itemView.findViewById(R.id.favourite_empty);
            fullFav = itemView.findViewById(R.id.fullFav);
            circleImageView = itemView.findViewById(R.id.sub_image);
            textView = itemView.findViewById(R.id.sub_name);
            show_sub_item = itemView.findViewById(R.id.show_sub_item);
            show_sub_item.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            onClickHandler1.oonClick(position);
            notifyDataSetChanged();
        }
    }

    class MyBounceInterpolator implements android.view.animation.Interpolator {
        private double mAmplitude = 1;
        private double mFrequency = 10;

        MyBounceInterpolator(double amplitude, double frequency) {
            mAmplitude = amplitude;
            mFrequency = frequency;
        }

        public float getInterpolation(float time) {
            return (float) (-1 * Math.pow(Math.E, -time/ mAmplitude) *
                    Math.cos(mFrequency * time) + 1);
        }
    }
}
