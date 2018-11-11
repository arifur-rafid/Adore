package com.example.mdarifurrahman.adore;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class AmbulanceFragment extends Fragment {


    int x1 = 0,x2=0,x3=0,x4=0,x5=0,x6=0,x7=0;
    Button ambulancetest,alamin1,alamin2,apanjan,cmh,green1,green2;
    public AmbulanceFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_ambulance, container, false);

        alamin1 = (Button)view.findViewById(R.id.alonebtn);
        alamin2 = (Button)view.findViewById(R.id.altwobtn);
        apanjan = (Button)view.findViewById(R.id.apanbtn);
        cmh = (Button)view.findViewById(R.id.cmhbtn);
        green1 = (Button)view.findViewById(R.id.button);
        green2 = (Button)view.findViewById(R.id.button2);
        try{
            x1=0;
            OnClickAmbulanceListener1();

        }catch (Exception e){

        }
        try{
            x2=0;

            OnClickAmbulanceListener2();

        }catch (Exception e){

        }
        try{
            x3=0;

            OnClickAmbulanceListener3();

        }catch (Exception e){

        }
        try{
            x4=0;

            OnClickAmbulanceListener4();

        }catch (Exception e){

        }
        try{
            x5=0;

            OnClickAmbulanceListener5();

        }catch (Exception e){

        }
        try{
            x6=0;

            OnClickAmbulanceListener6();
        }catch (Exception e){

        }



        return view;
    }



    public void OnClickAmbulanceListener1(){
        alamin1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x1++;
                        if(x1==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x1==2)
                        {
                            Call("01720448666");
                            x1=0;
                        }

                    }
                }
        );
    }
    public void OnClickAmbulanceListener2(){
        alamin2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x2++;
                        if(x2==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x2==2)
                        {
                            Call("01819137479");
                            x2=0;
                        }

                    }
                }
        );
    }


    public void OnClickAmbulanceListener3(){
        apanjan.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x3++;
                        if(x3==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x3==2)
                        {
                            Call("029125420");
                            x3=0;
                        }

                    }
                }
        );
    }

    public void OnClickAmbulanceListener4(){
        cmh.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x4++;
                        if(x4==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x4==2)
                        {
                            Call("029871469");
                            x4=0;
                        }

                    }
                }
        );
    }
    public void OnClickAmbulanceListener5(){
        green1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x5++;
                        if(x5==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x5==2)
                        {
                            Call("029334121");
                            x5=0;
                        }

                    }
                }
        );
    }

    public void OnClickAmbulanceListener6(){
        green2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x6++;
                        if(x6==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x6==2)
                        {
                            Call("028612412");
                            x6=0;
                        }

                    }
                }
        );
    }
    public void Call(String temp){
        try{
            Intent callIntent=new Intent(Intent.ACTION_CALL);
            callIntent.setData(Uri.parse("tel:"+temp));
            try{
                startActivity(callIntent);
            }catch(SecurityException e){

            }

        }catch(Exception e){

        }
    }
}
