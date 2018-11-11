package com.example.mdarifurrahman.adore;


import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class MomBreakfastFragment extends Fragment {
    CheckBox milk,mixedveg,ruti,egg,soup,yogurt,mixedsalad;
    int milk_cal = 103,mixedveg_cal= 120,ruti_cal =330,egg_cal=78,soup_cal=70,yogurt_cal = 75,mixedsalad_cal = 100;
    int sum=0;
    boolean milk_flag=false,egg_flag=false,ruti_flag=false,mixedveg_flag=false,soup_flag=false,yogurt_flag=false,mixedsalad_flag=false;
    public MomBreakfastFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       // return inflater.inflate(R.layout.fragment_mom_breakfast, container, false);
        View rootView = inflater.inflate(R.layout.fragment_mom_breakfast, container,false);
        milk=(CheckBox)rootView.findViewById(R.id.milkchk);
        mixedveg=(CheckBox)rootView.findViewById(R.id.mixedvegchk);
        egg=(CheckBox)rootView.findViewById(R.id.eggchk);
        ruti=(CheckBox)rootView.findViewById(R.id.rutichk);
        soup=(CheckBox)rootView.findViewById(R.id.soupchk);
        yogurt=(CheckBox)rootView.findViewById(R.id.yogurtchk);
        mixedsalad=(CheckBox)rootView.findViewById(R.id.mixedfruitsaladchk);
        milk.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!milk_flag)
                        {
                            sum=sum+milk_cal;
                            milk_flag=true;
                        }
                        else if(milk_flag) {
                            sum = sum - milk_cal;
                            milk_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );
        mixedveg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mixedveg_flag)
                        {
                            sum=sum+mixedveg_cal;
                            mixedveg_flag=true;
                        }
                        else if(mixedveg_flag) {
                            sum = sum - mixedveg_cal;
                            mixedveg_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        egg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!egg_flag)
                        {
                            sum=sum+egg_cal;
                            egg_flag=true;
                        }
                        else if(egg_flag) {
                            sum = sum - egg_cal;
                            egg_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        ruti.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!ruti_flag)
                        {
                            sum=sum+ruti_cal;
                            ruti_flag=true;
                        }
                        else if(ruti_flag) {
                            sum = sum - ruti_cal;
                            ruti_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        egg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!egg_flag)
                        {
                            sum=sum+egg_cal;
                            egg_flag=true;
                        }
                        else if(egg_flag) {
                            sum = sum - egg_cal;
                            egg_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
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
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        yogurt.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!yogurt_flag)
                        {
                            sum=sum+yogurt_cal;
                            yogurt_flag=true;
                        }
                        else if(soup_flag) {
                            sum = sum - yogurt_cal;
                            yogurt_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        mixedsalad.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!mixedsalad_flag)
                        {
                            sum=sum+mixedsalad_cal;
                            mixedsalad_flag=true;
                        }
                        else if(soup_flag) {
                            sum = sum - mixedsalad_cal;
                            mixedsalad_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        return rootView;
    }


}
