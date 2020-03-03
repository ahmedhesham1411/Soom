package com.example.soomtest;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.transition.AutoTransition;
import android.transition.TransitionManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.soomtest.Adapter.MainCatAdapter;
import com.example.soomtest.Adapter.Main_cat_resault_adapter;
import com.example.soomtest.Adapter.MyRecyclerViewAdapter2;
import com.example.soomtest.Adapter.PriceAdapter;
import com.example.soomtest.Adapter.SubCatAdapter;
import com.example.soomtest.Adapter.SubResaultAdapter;
import com.example.soomtest.Model.List_images_model;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.Model.Price_model;
import com.example.soomtest.Model.Sub_Cat_Model;
import com.example.soomtest.Model.Sub_Resault_Model;

import java.util.ArrayList;

public class Main_Cat_Resault extends AppCompatActivity implements Main_cat_resault_adapter.OnClickHander,SubCatAdapter.OnClickHander1,SubResaultAdapter.OnClickHander2 {
    RecyclerView MainCatRecycler,Sub_cat_recycler,ListImagesRecycler,recyclerViewComments,recyclerViewComments1,SubResaultAdapteRecycler;
    Main_cat_resault_adapter mainCatAdapter;
    SubCatAdapter subCatAdapter;
    MyRecyclerViewAdapter2 myRecyclerViewAdapter2;
    SubResaultAdapter subResaultAdapter;
    TextView Cat_name,title_name;
    AppCompatImageView btnBack,arrow_details,full_image;
    RelativeLayout layout_des;
    CardView card_details;
    LinearLayoutCompat drop_des,child_layout;
    PriceAdapter priceAdapter,priceAdapter1;
    ArrayList<MainCategoryModel> mainCatList;
    FrameLayout video_view_layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__cat__resault);

        title_name = findViewById(R.id.page_title);
        arrow_details = findViewById(R.id.arrow_details);
        layout_des = findViewById(R.id.layout_des);
        card_details = findViewById(R.id.card_details);
        drop_des = findViewById(R.id.drop_des);
        arrow_details.setBackgroundResource(R.drawable.button_down);
        full_image = findViewById(R.id.full_image);
        child_layout = findViewById(R.id.child_layout);
        video_view_layout = findViewById(R.id.video_view_layout);

        video_view_layout.setVisibility(View.GONE);

        drop_des.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (layout_des.getVisibility()==View.GONE){
                    TransitionManager.beginDelayedTransition(card_details, new AutoTransition());
                    layout_des.setVisibility(View.VISIBLE);
                    arrow_details.setBackgroundResource(R.drawable.button_up);
                } else {
                    TransitionManager.beginDelayedTransition(card_details, new AutoTransition());
                    layout_des.setVisibility(View.GONE);
                    arrow_details.setBackgroundResource(R.drawable.button_down);
                }
            }
        });

        String name = getIntent().getStringExtra("cat_name");
        title_name.setText(name);
      /*  String name = getIntent().getStringExtra("cat_name");
        int Cat_id = getIntent().getIntExtra("cat_id",10);
        mainCatList.remove(Cat_id - 1);
        Cat_name = findViewById(R.id.Cat_name);
        Cat_name.setText(name);*/

        btnBack = findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
                finish();
            }
        });
        //main_cat
        mainCatList = new ArrayList<>();
        mainCatList.add(new MainCategoryModel(1,R.drawable.home_rec1, getString(R.string.home_rec1)));
        mainCatList.add(new MainCategoryModel(2,R.drawable.home_rec2, getString(R.string.home_rec2)));
        mainCatList.add(new MainCategoryModel(3,R.drawable.home_rec3, getString(R.string.home_rec3)));
        mainCatList.add(new MainCategoryModel(4,R.drawable.home_rec4, getString(R.string.home_rec4)));
        mainCatList.add(new MainCategoryModel(5,R.drawable.home_rec6, getString(R.string.home_rec5)));
        mainCatList.add(new MainCategoryModel(6,R.drawable.home_rec7, getString(R.string.home_rec6)));
        mainCatList.add(new MainCategoryModel(7,R.drawable.home_rec8, getString(R.string.home_rec7)));
        mainCatList.add(new MainCategoryModel(7,R.drawable.home_rec8, getString(R.string.home_rec8)));
        MainCatRecycler = findViewById(R.id.main_cat_recycler1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext() ,LinearLayoutManager.HORIZONTAL, false);
        MainCatRecycler.setLayoutManager(linearLayoutManager);
        MainCatRecycler.setHasFixedSize(true);
        mainCatAdapter = new Main_cat_resault_adapter(mainCatList,getApplicationContext(),this);
        MainCatRecycler.setAdapter(mainCatAdapter);

        //images
        ArrayList<List_images_model> ListImages = new ArrayList<>();
        ListImages.add(new List_images_model(1,R.drawable.full_car));
        ListImages.add(new List_images_model(2,R.drawable.full_car));
        ListImages.add(new List_images_model(3,R.drawable.full_car));
        ListImages.add(new List_images_model(4,R.drawable.full_car));
        ListImages.add(new List_images_model(5,R.drawable.full_car));
        ListImages.add(new List_images_model(6,R.drawable.full_car));
        ListImages.add(new List_images_model(7,R.drawable.full_car));
        ListImages.add(new List_images_model(8,R.drawable.full_car));

        ListImagesRecycler = findViewById(R.id.images_list_recycler);
        LinearLayoutManager linearLayoutManager4 = new LinearLayoutManager(getApplicationContext() ,LinearLayoutManager.HORIZONTAL, false);
        ListImagesRecycler.setLayoutManager(linearLayoutManager4);
        myRecyclerViewAdapter2 = new MyRecyclerViewAdapter2(ListImages,getApplicationContext());
        ListImagesRecycler.setAdapter(myRecyclerViewAdapter2);

        //sub_cat
        ArrayList<Sub_Cat_Model> subCatList = new ArrayList<>();
        subCatList.add(new Sub_Cat_Model(true,R.drawable.car, getString(R.string.sub_rec1)));
        subCatList.add(new Sub_Cat_Model(false,R.drawable.scooter, getString(R.string.sub_rec2)));
        subCatList.add(new Sub_Cat_Model(true,R.drawable.bic, getString(R.string.sub_rec3)));
        subCatList.add(new Sub_Cat_Model(true,R.drawable.boy, getString(R.string.sub_rec4)));
        subCatList.add(new Sub_Cat_Model(false,R.drawable.car, getString(R.string.sub_rec1)));
        subCatList.add(new Sub_Cat_Model(false,R.drawable.scooter, getString(R.string.sub_rec2)));
        subCatList.add(new Sub_Cat_Model(false,R.drawable.bic, getString(R.string.sub_rec3)));
        subCatList.add(new Sub_Cat_Model(true,R.drawable.boy, getString(R.string.sub_rec4)));

        Sub_cat_recycler = findViewById(R.id.sub_cat_recycler);
        LinearLayoutManager linearLayoutManager1 = (new GridLayoutManager(this,2));
        Sub_cat_recycler.setLayoutManager(linearLayoutManager1);
        subCatAdapter = new SubCatAdapter(subCatList,getApplicationContext(), (SubCatAdapter.OnClickHander1) this);
        Sub_cat_recycler.setAdapter(subCatAdapter);

        //child
        ArrayList<Sub_Resault_Model> sub_resault_models = new ArrayList<>();
        sub_resault_models.add(new Sub_Resault_Model(1,R.drawable.car, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(2,R.drawable.car1, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(3,R.drawable.car2, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(4,R.drawable.car3, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(5,R.drawable.car4, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(6,R.drawable.car, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(7,R.drawable.car1, getString(R.string.cars)));
        sub_resault_models.add(new Sub_Resault_Model(7,R.drawable.car2, getString(R.string.cars)));
        SubResaultAdapteRecycler = findViewById(R.id.child_recycler);
        LinearLayoutManager linearLayoutManager2 = (new GridLayoutManager(this,2));
        SubResaultAdapteRecycler.setLayoutManager(linearLayoutManager2);
        subResaultAdapter = new SubResaultAdapter(sub_resault_models,getApplicationContext(), (SubResaultAdapter.OnClickHander2) this);
        SubResaultAdapteRecycler.setAdapter(subResaultAdapter);

        //prices
        ArrayList<Price_model> price_models = new ArrayList<>();
        price_models.add(new Price_model(R.drawable.price_image,1000));
        price_models.add(new Price_model(R.drawable.price_image,1500));
        price_models.add(new Price_model(R.drawable.price_image,900));
        price_models.add(new Price_model(R.drawable.price_image,800));
        price_models.add(new Price_model(R.drawable.price_image,1200));
        recyclerViewComments = findViewById(R.id.comments_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerViewComments.setLayoutManager(mLayoutManager);
        priceAdapter = new PriceAdapter(price_models,getApplicationContext());
        recyclerViewComments.setAdapter(priceAdapter);

        //prices2
        ArrayList<Price_model> price_models1 = new ArrayList<>();
        price_models1.add(new Price_model(R.drawable.price_image,900));
        price_models1.add(new Price_model(R.drawable.price_image,800));
        price_models1.add(new Price_model(R.drawable.price_image,1200));
        recyclerViewComments1 = findViewById(R.id.comments_recycler1);
        RecyclerView.LayoutManager mLayoutManager1 = new LinearLayoutManager(getApplicationContext());
        recyclerViewComments1.setLayoutManager(mLayoutManager1);
        priceAdapter1 = new PriceAdapter(price_models1,getApplicationContext());
        recyclerViewComments1.setAdapter(priceAdapter1);
    }


    @Override
    public void onClick(int position) {
        int id = mainCatList.get(position).getMain_Cat_Id();
        String name = mainCatList.get(id-1).getName();
        title_name.setText(name);
        SubResaultAdapteRecycler.setVisibility(View.GONE);
        Sub_cat_recycler.setVisibility(View.VISIBLE);
        child_layout.setVisibility(View.GONE);
        video_view_layout.setVisibility(View.GONE);
        //Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void oonClick(int position) {
        Sub_cat_recycler.setVisibility(View.GONE);
        SubResaultAdapteRecycler.setVisibility(View.VISIBLE);
        child_layout.setVisibility(View.GONE);
        video_view_layout.setVisibility(View.GONE);
    }

    @Override
    public void ooonClick(int position) {
        video_view_layout.setVisibility(View.VISIBLE);
        child_layout.setVisibility(View.VISIBLE);
        Sub_cat_recycler.setVisibility(View.GONE);
        SubResaultAdapteRecycler.setVisibility(View.GONE);
    }
}
