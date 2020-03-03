package com.example.soomtest.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.soomtest.R;
import com.smarteist.autoimageslider.SliderViewAdapter;

public class SliderAdapterExample  extends SliderViewAdapter<SliderAdapterExample.SliderAdapterVH> {

    private Context context;

    public SliderAdapterExample(Context context) {
        this.context = context;
    }

    @Override
    public SliderAdapterVH onCreateViewHolder(ViewGroup parent) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_slider_home, null);
        return new SliderAdapterVH(inflate);
    }

    @Override
    public void onBindViewHolder(SliderAdapterVH viewHolder, int position) {

        switch (position) {
            case 0:
               viewHolder.imageViewBackground.setImageResource(R.drawable.slider_imagee);
                break;
            case 1:
                viewHolder.imageViewBackground.setImageResource(R.drawable.slider_imagee);

                break;
            case 2:
                viewHolder.imageViewBackground.setImageResource(R.drawable.slider_imagee);

                break;
            default:
                viewHolder.imageViewBackground.setImageResource(R.drawable.slider_imagee);
                break;

        }

    }

    @Override
    public int getCount() {
        //slider view count could be dynamic size
        return 4;
    }

    class SliderAdapterVH extends SliderViewAdapter.ViewHolder {

        View itemView;
        ImageView imageViewBackground;

        public SliderAdapterVH(View itemView) {
            super(itemView);
            imageViewBackground = itemView.findViewById(R.id.imageHome);
            this.itemView = itemView;
        }
    }
}