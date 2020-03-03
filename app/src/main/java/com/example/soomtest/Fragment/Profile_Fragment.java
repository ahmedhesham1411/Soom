package com.example.soomtest.Fragment;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.soomtest.Edit_profile;
import com.example.soomtest.R;

public class Profile_Fragment extends Fragment {

    LinearLayoutCompat go_to_edit_profile;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        go_to_edit_profile = view.findViewById(R.id.go_to_edit_profile);
        go_to_edit_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Edit_profile.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
