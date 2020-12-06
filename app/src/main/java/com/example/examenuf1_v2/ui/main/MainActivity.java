package com.example.examenuf1_v2.ui.main;

import android.os.Bundle;

import com.example.examenuf1_v2.Classes.Ingres;
import com.example.examenuf1_v2.Classes.ViewModel_Ingresos;
import com.example.examenuf1_v2.R;
import com.google.android.material.tabs.TabLayout;

import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;
import androidx.appcompat.app.AppCompatActivity;

import com.example.examenuf1_v2.ui.main.SectionsPagerAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ViewModel_Ingresos vmIngresos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //inici
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //view model
        vmIngresos = ViewModelProviders.of(this).get(ViewModel_Ingresos.class);
        vmIngresos.setIngresos(new ArrayList<Ingres>());
        //tabs
        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
        //


    }
}