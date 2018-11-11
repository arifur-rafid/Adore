package com.example.mdarifurrahman.adore;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Mother_button_Activity extends AppCompatActivity {
   ///this activity is for by clicking mom button of home page to activity_mother_button
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mother_button);
        AllButtonFunction();

    }

    public void AllButtonFunction(){

        OnClickFoodGuideListener();
        OnClickMedicineListener();
        OnClickVaccineListener();
        OnClickCheckUpListener();
        OnClickSymptomListener();
        OnClickGeneral_queryListener();
    }

    public void OnClickFoodGuideListener(){
        ImageButton foodguidebtn=(ImageButton)findViewById(R.id.foodguidebtn);
        foodguidebtn.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),FoodGuideActivity.class));
                    }
                }
        );
    }

    public void OnClickMedicineListener(){
        ImageButton medicine=(ImageButton)findViewById(R.id.medicinebtn);
        medicine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),MedicineActivity.class));
                    }
                }
        );
    }

    public void OnClickVaccineListener(){
        ImageButton vaccine=(ImageButton)findViewById(R.id.vaccinebtn);
        vaccine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),VaccineActivity.class));
                    }
                }
        );
    }

    public void OnClickCheckUpListener(){
        ImageButton checkup=(ImageButton)findViewById(R.id.checkupbtn);
        checkup.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),CheckUpActivity.class));
                    }
                }
        );
    }

    public void OnClickSymptomListener(){
        ImageButton mother_symptom=(ImageButton)findViewById(R.id.mothersymptombtn);
        mother_symptom.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),Mother_symptom_Activity.class));
                    }
                }
        );
    }

    public void OnClickGeneral_queryListener(){
        ImageButton generalquery=(ImageButton)findViewById(R.id.askbtn);
        generalquery.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        startActivity(new Intent(getApplicationContext(),General_query_Activity.class));
                    }
                }
        );
    }
}
