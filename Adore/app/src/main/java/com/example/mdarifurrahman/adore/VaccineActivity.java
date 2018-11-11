package com.example.mdarifurrahman.adore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class VaccineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine);
        OnClicksafevaccineListener();
        OnClickunsafevaccineListener();
    }

    public void OnClicksafevaccineListener(){
        ImageButton safevaccine=(ImageButton)findViewById(R.id.safevaccinebtn);
        safevaccine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),SafeVaccineActivity.class));
                    }
                }
        );
    }


    public void OnClickunsafevaccineListener(){
        ImageButton unsafevaccine=(ImageButton)findViewById(R.id.unsafevaccinebtn);
        unsafevaccine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),UnsafeVaccineActivity.class));
                    }
                }
        );
    }
}
