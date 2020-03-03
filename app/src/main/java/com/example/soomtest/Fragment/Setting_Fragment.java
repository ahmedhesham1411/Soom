package com.example.soomtest.Fragment;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.example.soomtest.About_us;
import com.example.soomtest.Contact_us;
import com.example.soomtest.Forget_password;
import com.example.soomtest.R;
import com.example.soomtest.Terms_and_conditions;

public class Setting_Fragment extends Fragment {

    RelativeLayout go_to_forget_password,go_to_about_us,go_to_terms_and_conditions,go_to_contact_us;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting_, container, false);

        go_to_forget_password = view.findViewById(R.id.go_to_forget_password);
        go_to_forget_password.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Forget_password.class);
                startActivity(intent);
            }
        });

        go_to_about_us = view.findViewById(R.id.go_to_about_us);
        go_to_about_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), About_us.class);
                startActivity(intent);
            }
        });

        go_to_terms_and_conditions = view.findViewById(R.id.go_to_terms_and_conditions);
        go_to_terms_and_conditions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Terms_and_conditions.class);
                startActivity(intent);
            }
        });

        go_to_contact_us = view.findViewById(R.id.go_to_contact_us);
        go_to_contact_us.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), Contact_us.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
