package com.example.mdarifurrahman.adore;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MomEveningFoodFragment extends Fragment {
    CheckBox lassi,nuts,soup,roastedchana;
    int lassi_cal = 40,nuts_cal= 250,soup_cal =50,roastedchana_cal = 35;
    int sum=0;
    boolean lassi_flag=false,nuts_flag=false,soup_flag=false,roastedchana_flag=false;

    public MomEveningFoodFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mom_evening_food, container,false);
        lassi=(CheckBox)rootView.findViewById(R.id.lassichk);
        nuts=(CheckBox)rootView.findViewById(R.id.nutschk);
        soup=(CheckBox)rootView.findViewById(R.id.soupchk);
        roastedchana=(CheckBox)rootView.findViewById(R.id.roastedchanachk);
        lassi.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!lassi_flag)
                        {
                            sum=sum+lassi_cal;
                            lassi_flag=true;
                        }
                        else if(lassi_flag) {
                            sum = sum - lassi_cal;
                            lassi_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 300 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        nuts.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!nuts_flag)
                        {
                            sum=sum+nuts_cal;
                            nuts_flag=true;
                        }
                        else if(nuts_flag) {
                            sum = sum - nuts_cal;
                            nuts_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 300 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        soup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!soup_flag)
                        {
                            sum=sum+soup_cal;
                            soup_flag=true;
                        }
                        else if(soup_flag) {
                            sum = sum - soup_cal;
                            soup_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 300 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        roastedchana.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!roastedchana_flag)
                        {
                            sum=sum+roastedchana_cal;
                            roastedchana_flag=true;
                        }
                        else if(roastedchana_flag) {
                            sum = sum - roastedchana_cal;
                            roastedchana_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 300 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );


        return rootView;
    }

}
