package com.example.mdarifurrahman.adore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class InformationMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);
        OnClickMomInformationListener();
        OnClickChildInformationListener();
        OnClickEmergencyInformationListener();
    }

    public void OnClickMomInformationListener(){
        ImageButton mominformation=(ImageButton)findViewById(R.id.mominformationbtn);
        mominformation.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),MomInformationActivity.class));

                    }
                }
        );
    }

    public void OnClickChildInformationListener(){
        ImageButton childinformation=(ImageButton)findViewById(R.id.childinformationbtn);
        childinformation.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),ChildInformationActivity.class));

                    }
                }
        );
    }

    public void OnClickEmergencyInformationListener(){
        ImageButton emergencyinformation=(ImageButton)findViewById(R.id.emergencyinformationbtn);
        emergencyinformation.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),EmergencyInformationActivity.class));

                    }
                }
        );
    }
}
