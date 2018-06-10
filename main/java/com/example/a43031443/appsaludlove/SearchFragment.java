package com.example.a43031443.appsaludlove;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by 43031443 on 18/5/2018.
 */

public class SearchFragment extends Fragment {
    Button btnCompatibilidades;
    Button btnBMI;
    Button btnAlcoholemia;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_search, container, false);

        btnCompatibilidades=(Button)v.findViewById(R.id.btnCompatibilidadesSanguineas);
        btnCompatibilidades.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction().replace(R.id.fragment_container, new CompatibilidadesSanguineasFragment()).commit();
            }
        });

        btnBMI = (Button)v.findViewById(R.id.btnBMI);
        btnBMI.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new BMIFragment()).commit();
            }
        });

        btnAlcoholemia=(Button)v.findViewById(R.id.btnTestAlcoholemia);
        btnAlcoholemia.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragment_container, new TestAlcoholemiaFragment()).commit();
            }
        });

        return v;
    }
}