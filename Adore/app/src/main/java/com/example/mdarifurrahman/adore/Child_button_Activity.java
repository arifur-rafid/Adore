package com.example.mdarifurrahman.adore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Child_button_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_button_);
        AllButtonFunction();
    }
    public void AllButtonFunction(){
        OnClickChildFoodListener();
        OnClickChildvaccineListener();
        OnClickChildVaccineListener();
        OnClickChildCarekListener();
    }

    public void OnClickChildFoodListener(){
        ImageButton childfood=(ImageButton) findViewById(R.id.childfoodbtn);
        childfood.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Child_food_Activity.class));
                    }
                }
        );
    }

    public void OnClickChildvaccineListener(){
        ImageButton childvaccine=(ImageButton) findViewById(R.id.childvaccinebtn);
        childvaccine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Child_Vaccine_Activity.class));
                    }
                }
        );
    }

    public void OnClickChildVaccineListener(){
        ImageButton childsymptom=(ImageButton) findViewById(R.id.childsymptombtn);
        childsymptom.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Child_Symptom_Activity.class));
                    }
                }
        );
    }

    public void OnClickChildCarekListener(){
        ImageButton childcare=(ImageButton) findViewById(R.id.childcarebtn);
        childcare.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Child_Care_Activity.class));
                    }
                }
        );
    }
}
