package com.example.mdarifurrahman.adore;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;
import android.widget.Toast;

import java.util.Calendar;

public class FoodGuideActivity extends AppCompatActivity{


    TabHost tabHost;
    int hourofday;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food_guide);

        Calendar calendar = Calendar.getInstance();




        try{
            tabHost=(TabHost)findViewById(R.id.tabHost);
            tabHost.setup();

            TabHost.TabSpec spec1=tabHost.newTabSpec("TAB 1");
            spec1.setContent(R.id.tab1);
            spec1.setIndicator("Food Chart");



            TabHost.TabSpec spec2=tabHost.newTabSpec("TAB 2");
            spec2.setIndicator("      Food Limitation");
            spec2.setContent(R.id.tab2);


            TabHost.TabSpec spec3=tabHost.newTabSpec("TAB 3");
            spec3.setContent(R.id.tab3);
            spec3.setIndicator("Nutrition");
            tabHost.addTab(spec1);
            tabHost.addTab(spec2);
            tabHost.addTab(spec3);
        }catch(Exception e){

        }


        hourofday = calendar.get(Calendar.HOUR_OF_DAY);
        //Toast.makeText(getApplicationContext(),hourofday+"",Toast.LENGTH_LONG).show();
        if(hourofday>=7 && hourofday<12){
            MomBreakfastFragment momBreakfastFragment = new MomBreakfastFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_mom, momBreakfastFragment);
            fragmentTransaction.commit();

        }

        else if(hourofday>=12 && hourofday<15)
        {
            MomLunchFragment momLunchFragment = new MomLunchFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_mom, momLunchFragment);
            fragmentTransaction.commit();
        }
        else if(hourofday>=15 && hourofday<20)
        {
            MomEveningFoodFragment momEveningFoodFragment = new MomEveningFoodFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_mom, momEveningFoodFragment);
            fragmentTransaction.commit();
        }
        else if(hourofday>=20 && hourofday<=24)
        {
            MomDinnerFragment momDinnerFragment = new MomDinnerFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_mom, momDinnerFragment);
            fragmentTransaction.commit();
        }

        else if(hourofday>=0 && hourofday<7)
        {
            MomDinnerFragment momDinnerFragment = new MomDinnerFragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_mom, momDinnerFragment);
            fragmentTransaction.commit();
        }


    }




}
