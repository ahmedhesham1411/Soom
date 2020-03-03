package com.example.soomtest.Fragment;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soomtest.Adapter.MainCatAdapter;
import com.example.soomtest.Adapter.MyRecyclerViewAdapter1;
import com.example.soomtest.Adapter.SliderAdapterExample;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.Adapter.MyRecyclerViewAdapter;
import com.example.soomtest.R;
import com.smarteist.autoimageslider.IndicatorAnimations;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;
import com.yarolegovich.discretescrollview.DiscreteScrollView;
import com.yarolegovich.discretescrollview.transform.Pivot;
import com.yarolegovich.discretescrollview.transform.ScaleTransformer;

import java.util.ArrayList;


public class Home_Fragment extends Fragment {
    DiscreteScrollView scrollView,scrollView1;
    RecyclerView recyclerView;
    MainCatAdapter mainCatAdapter;
    SliderView sliderView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        sliderView = view.findViewById(R.id.imageSliderHome);
        SliderAdapterExample adapter = new SliderAdapterExample(getContext());
        sliderView.setSliderAdapter(adapter);
        sliderView.setIndicatorAnimation(IndicatorAnimations.WORM); //set indicator animation by using SliderLayout.IndicatorAnimations. :WORM or THIN_WORM or COLOR or DROP or FILL or NONE or SCALE or SCALE_DOWN or SLIDE and SWAP!!
        sliderView.setSliderTransformAnimation(SliderAnimations.SIMPLETRANSFORMATION);
        sliderView.setAutoCycleDirection(SliderView.AUTO_CYCLE_DIRECTION_BACK_AND_FORTH);
        sliderView.setIndicatorSelectedColor(Color.WHITE);
        sliderView.setIndicatorUnselectedColor(Color.GRAY);
        sliderView.setScrollTimeInSec(4); //set scroll delay in seconds :
        sliderView.startAutoCycle();

        Integer[] Icons = {
                R.drawable.ad1,
                R.drawable.ad2,
                R.drawable.ad3,
};
       // scrollView = (DiscreteScrollView) view.findViewById(R.id.item_picker);
        scrollView1 = (DiscreteScrollView) view.findViewById(R.id.item_picker2);

       /* scrollView.setAdapter(new MyRecyclerViewAdapter(Icons,getContext()));
        scrollView.scrollToPosition(1);

        scrollView.setOverScrollEnabled(true);
        scrollView.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());*/

        scrollView1.setAdapter(new MyRecyclerViewAdapter1(Icons,getContext()));
        scrollView1.scrollToPosition(1);

        scrollView1.setOverScrollEnabled(true);
        scrollView1.setItemTransformer(new ScaleTransformer.Builder()
                .setMaxScale(1.05f)
                .setMinScale(0.8f)
                .setPivotX(Pivot.X.CENTER) // CENTER is a default one
                .setPivotY(Pivot.Y.BOTTOM) // CENTER is a default one
                .build());


        ArrayList<MainCategoryModel> mainCatList = new ArrayList<>();
        mainCatList.add(new MainCategoryModel(1,R.drawable.home_rec1, getString(R.string.home_rec1)));
        mainCatList.add(new MainCategoryModel(2,R.drawable.home_rec2, getString(R.string.home_rec2)));
        mainCatList.add(new MainCategoryModel(3,R.drawable.home_rec3, getString(R.string.home_rec3)));
        mainCatList.add(new MainCategoryModel(4,R.drawable.home_rec4, getString(R.string.home_rec4)));
        mainCatList.add(new MainCategoryModel(5,R.drawable.home_rec6, getString(R.string.home_rec5)));
        mainCatList.add(new MainCategoryModel(6,R.drawable.home_rec7, getString(R.string.home_rec6)));
        mainCatList.add(new MainCategoryModel(7,R.drawable.home_rec8, getString(R.string.home_rec7)));
        mainCatList.add(new MainCategoryModel(7,R.drawable.home_rec8, getString(R.string.home_rec8)));

        recyclerView = view.findViewById(R.id.main_cat_recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext() ,LinearLayoutManager.HORIZONTAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setHasFixedSize(true);

        mainCatAdapter = new MainCatAdapter(mainCatList,getContext());
        recyclerView.setAdapter(mainCatAdapter);
        return view;
    }


}
