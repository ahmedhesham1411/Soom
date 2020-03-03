package com.example.soomtest.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soomtest.Adapter.MainCatAdapter;
import com.example.soomtest.Adapter.SearchAdapter;
import com.example.soomtest.Model.MainCategoryModel;
import com.example.soomtest.Model.Search_model;
import com.example.soomtest.R;

import java.util.ArrayList;


public class Search_fragment extends Fragment {

    RecyclerView recyclerView;
    SearchAdapter searchAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_fragment, container, false);


        ArrayList<Search_model> search_models = new ArrayList<>();
        search_models.add(new Search_model(R.drawable.search_image));
        search_models.add(new Search_model(R.drawable.search_image));
        search_models.add(new Search_model(R.drawable.search_image));
        search_models.add(new Search_model(R.drawable.search_image));
        search_models.add(new Search_model(R.drawable.search_image));

        recyclerView = view.findViewById(R.id.search_recycler);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        searchAdapter = new SearchAdapter(search_models,getContext());
        recyclerView.setAdapter(searchAdapter);

        return view;
    }
}
