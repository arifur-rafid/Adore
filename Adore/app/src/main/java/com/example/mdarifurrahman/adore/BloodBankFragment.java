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
public class BloodBankFragment extends Fragment {
    Button badhan1,badhan2,red1,red2,sandhani1,sandhani2,chit1,chit2,rail1,chitsandhani;
    int x=0;
    public BloodBankFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view;
        view = inflater.inflate(R.layout.fragment_bloodbank, container, false);
        badhan1 = (Button)view.findViewById(R.id.badhan1btn);
        badhan2 = (Button)view.findViewById(R.id.badhon2btn);
        red1 = (Button)view.findViewById(R.id.red1btn);
        red2 = (Button)view.findViewById(R.id.red2btn);
        sandhani1 = (Button)view.findViewById(R.id.sandhani1btn);
        sandhani2 = (Button)view.findViewById(R.id.sandhani2btn);
        chit1 = (Button)view.findViewById(R.id.chit1btn);
        chit2 = (Button)view.findViewById(R.id.chit2btn);
        rail1 = (Button)view.findViewById(R.id.rail1btn);
        chitsandhani = (Button)view.findViewById(R.id.chitsandhanibtn);
        try{
            x=0;
            OnClickbadhan1Listener();
            OnClickbadhan2Listener();
            OnClickred1Listener();
            OnClickred2Listener();
            OnClicksandhani1Listener();
            OnClicksandhani2Listener();
            OnClickchit1Listener();
            OnClickchit2Listener();
            OnClickrail1Listener();
            OnClickchitsandhaniListener();
        }catch (Exception e){

        }


        return view;
    }
    public void OnClickbadhan1Listener(){
        badhan1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("01720448666");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickbadhan2Listener(){
        badhan2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("01819137479");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickred1Listener(){
        red1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("029116563");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickred2Listener(){
        red2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("028121497");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClicksandhani1Listener(){
        sandhani1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("027319123");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClicksandhani2Listener(){
        sandhani2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("01819284878");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickchit1Listener(){
        chit1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("02616891");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickchit2Listener(){
        chit2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("0294616199");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickrail1Listener(){
        chit2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("02720121");
                            x=0;
                        }

                    }
                }
        );
    }

    public void OnClickchitsandhaniListener(){
        chitsandhani.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        x++;
                        if(x==1)
                        {
                            Toast.makeText(getActivity().getApplicationContext(),"To Call Tap Again ", Toast.LENGTH_LONG).show();
                        }
                        else if(x==2)
                        {
                            Call("02720121");
                            x=0;
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
