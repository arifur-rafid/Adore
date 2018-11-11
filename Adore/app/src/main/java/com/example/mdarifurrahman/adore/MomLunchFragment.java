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
public class MomLunchFragment extends Fragment {
    CheckBox salad,greenveg,dal,rice,curry,raita;
    int salad_cal = 11,greenveg_cal= 118,dal_cal =44,rice_cal=110,curry_cal=200,raita_cal = 243;
    int sum=0;
    boolean salad_flag=false,greenveg_flag=false,dal_flag=false,rice_flag=false,curry_flag=false,raita_flag=false;
    public MomLunchFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_mom_luanch, container,false);
        salad=(CheckBox)rootView.findViewById(R.id.lncchk);
        greenveg=(CheckBox)rootView.findViewById(R.id.greenvegchk);
        dal=(CheckBox)rootView.findViewById(R.id.dalchk);
        rice=(CheckBox)rootView.findViewById(R.id.ricechk);
        curry=(CheckBox)rootView.findViewById(R.id.currychk);
        raita=(CheckBox)rootView.findViewById(R.id.raitachk);
        salad.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!salad_flag)
                        {
                            sum=sum+salad_cal;
                            salad_flag=true;
                        }
                        else if(salad_flag) {
                            sum = sum - salad_cal;
                            salad_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        greenveg.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!greenveg_flag)
                        {
                            sum=sum+greenveg_cal;
                            greenveg_flag=true;
                        }
                        else if(greenveg_flag) {
                            sum = sum - greenveg_cal;
                            greenveg_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        dal.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!dal_flag)
                        {
                            sum=sum+dal_cal;
                            dal_flag=true;
                        }
                        else if(dal_flag) {
                            sum = sum - dal_cal;
                            dal_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        rice.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!rice_flag)
                        {
                            sum=sum+rice_cal;
                            rice_flag=true;
                        }
                        else if(rice_flag) {
                            sum = sum - rice_cal;
                            rice_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        curry.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!curry_flag)
                        {
                            sum=sum+curry_cal;
                            curry_flag=true;
                        }
                        else if(curry_flag) {
                            sum = sum - curry_cal;
                            curry_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        raita.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!raita_flag)
                        {
                            sum=sum+raita_cal;
                            raita_flag=true;
                        }
                        else if(raita_flag) {
                            sum = sum - raita_cal;
                            raita_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        return rootView;
    }

}
