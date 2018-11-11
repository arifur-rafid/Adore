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
public class MomDinnerFragment extends Fragment {
    CheckBox vegsoupdin,greenvegdin,daldin,rutidin,fruitsaladdin,raitadin;
    int vegsoupdin_cal = 70,greenvegdin_cal= 100,daldin_cal =44,rutidin_cal=330,fruitsaladdin_cal=44,raitadin_cal = 243;
    int sum=0;
    boolean vegsoupdin_flag=false,greenvegdin_flag=false,daldin_flag=false,rutidin_flag=false,fruitsaladdin_flag=false,raitadin_flag=false;

    public MomDinnerFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_mom_dinner, container,false);
        vegsoupdin=(CheckBox)rootView.findViewById(R.id.vegsoupdinchk);
        greenvegdin=(CheckBox)rootView.findViewById(R.id.greenvegdinchk);
        daldin=(CheckBox)rootView.findViewById(R.id.daldinchk);
        rutidin=(CheckBox)rootView.findViewById(R.id.rutidinchk);
        fruitsaladdin=(CheckBox)rootView.findViewById(R.id.fruitsaladdinchk);
        raitadin=(CheckBox)rootView.findViewById(R.id.raitadinchk);
        vegsoupdin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!vegsoupdin_flag)
                        {
                            sum=sum+vegsoupdin_cal;
                            vegsoupdin_flag=true;
                        }
                        else if(vegsoupdin_flag) {
                            sum = sum - vegsoupdin_cal;
                            vegsoupdin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        greenvegdin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!greenvegdin_flag)
                        {
                            sum=sum+greenvegdin_cal;
                            greenvegdin_flag=true;
                        }
                        else if(vegsoupdin_flag) {
                            sum = sum - greenvegdin_cal;
                            greenvegdin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        daldin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!daldin_flag)
                        {
                            sum=sum+daldin_cal;
                            daldin_flag=true;
                        }
                        else if(daldin_flag) {
                            sum = sum - daldin_cal;
                            daldin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        rutidin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!rutidin_flag)
                        {
                            sum=sum+rutidin_cal;
                            rutidin_flag=true;
                        }
                        else if(rutidin_flag) {
                            sum = sum - rutidin_cal;
                            rutidin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        fruitsaladdin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!fruitsaladdin_flag)
                        {
                            sum=sum+fruitsaladdin_cal;
                            fruitsaladdin_flag=true;
                        }
                        else if(fruitsaladdin_flag) {
                            sum = sum - fruitsaladdin_cal;
                            fruitsaladdin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        raitadin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(!raitadin_flag)
                        {
                            sum=sum+raitadin_cal;
                            raitadin_flag=true;
                        }
                        else if(fruitsaladdin_flag) {
                            sum = sum - raitadin_cal;
                            raitadin_flag=false;
                        }
                        Toast.makeText(getActivity(),"Calorie Needed: 600 approx.\n"+"Selected: "+sum+" Calorie approx.",Toast.LENGTH_SHORT).show();
                    }
                }
        );

        return rootView;
    }

}
