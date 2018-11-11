package com.example.mdarifurrahman.adore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            Intent myIntent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivity(myIntent);
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED&& ActivityCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED ) {

                requestPermissions(new  String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.SYSTEM_ALERT_WINDOW,
                }, 10);
                return;
            }

        }else
        {
            AllButtonFunction();
        }
        AllButtonFunction();
    }

    public void AllButtonFunction(){
        OnClicMomButtonkListener();
        OnClicChildButtonkListener();
        OnClickEmergencyHomeButtonkListener();
        OnClickInformationMenuListener();
        OnClickExitHomeButtonkListener();
        OnClickCreditListener();
        OnClickExtrasListener();
    }

     public void OnClicMomButtonkListener(){
         ImageButton mombtn=(ImageButton)findViewById(R.id.mombutton);
         mombtn.setOnClickListener(
                 new View.OnClickListener() {
                     @Override
                     public void onClick(View v) {
                         startActivity(new Intent(getApplicationContext(),Mother_button_Activity.class));
                     }
                 }
         );
     }



    public void OnClickEmergencyHomeButtonkListener(){
        ImageButton EmergencyHome=(ImageButton)findViewById(R.id.emergency_home_btn);
        EmergencyHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),EmergencyHomeActivity.class));

                    }
                }
        );
    }

    public void OnClickExitHomeButtonkListener(){
        ImageButton ExitHome=(ImageButton)findViewById(R.id.exit_home_btn);
        ExitHome.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //startActivity(new Intent(getApplicationContext(),EmergencyHomeActivity.class));
                        System.exit(0);
                    }
                }
        );
    }

    public void OnClickInformationMenuListener(){
        ImageButton settings=(ImageButton)findViewById(R.id.settingsbutton);
        settings.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),InformationMenuActivity.class));

                    }
                }
        );
    }

    public void OnClicChildButtonkListener(){
        ImageButton childbtn=(ImageButton)findViewById(R.id.childbutton);
        childbtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Child_button_Activity.class));
                    }
                }
        );
    }

    public void OnClickCreditListener(){
        ImageButton credit=(ImageButton)findViewById(R.id.creditbtn);
        credit.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),CreditActivity.class));
                    }
                }
        );
    }

    public void OnClickExtrasListener(){
        ImageButton extras=(ImageButton)findViewById(R.id.extrasbtn);
        extras.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),ExtrasActivity.class));
                    }
                }
        );
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case 10:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED) {

                    AllButtonFunction();
                }
                return;
        }

    }

}
