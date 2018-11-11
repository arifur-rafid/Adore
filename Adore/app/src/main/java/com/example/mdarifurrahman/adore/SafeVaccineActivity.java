package com.example.mdarifurrahman.adore;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SafeVaccineActivity extends AppCompatActivity {
    int selected1;
    int selected2;
    int selected3;

    RadioGroup hepatitis_b,influenza,tetanus;
    RadioButton hepa,influ,teta;
    Button savevaccine;

    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_safe_vaccine);
        File dir=new File(path);
        dir.mkdir();
        hepatitis_b=(RadioGroup)findViewById(R.id.hepatitis_b_rg);
        influenza=(RadioGroup)findViewById(R.id.influenza_rg);
        tetanus=(RadioGroup)findViewById(R.id.tetanus_rg);
       try{
           loadfunc();
       }catch(Exception e)
       {
           savefunc();
       }

        OnClickSaveVaccineListener();
    }


    public void OnClickSaveVaccineListener(){

       /* hepatitis_b=(RadioGroup)findViewById(R.id.hepatitis_b_rg);
        influenza=(RadioGroup)findViewById(R.id.influenza_rg);
        tetanus=(RadioGroup)findViewById(R.id.tetanus_rg);*/

        savevaccine=(Button) findViewById(R.id.savedvaccinebtn);
        savevaccine.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       try{
                           savefunc();
                           loadfunc();
                       }catch(Exception e){

                       }
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void savefunc()
    {
        selected1=hepatitis_b.getCheckedRadioButtonId();
        selected2=influenza.getCheckedRadioButtonId();
        selected3=tetanus.getCheckedRadioButtonId();
        String temp=selected1+"/"+selected2+"/"+selected3;
        File file=new File(path+"/savedvaccine.txt");
        String [] savetxt=temp.split("/");
        Save(file,savetxt);
    }
    public void loadfunc()
    {
        File file=new File(path+"/savedvaccine.txt");
        String [] loadtxt=Load(file);
        selected1=Integer.parseInt(loadtxt[0]);
        selected2=Integer.parseInt(loadtxt[1]);
        selected3=Integer.parseInt(loadtxt[2]);
        hepa=(RadioButton)findViewById(selected1);
        influ=(RadioButton)findViewById(selected2);
        teta=(RadioButton)findViewById(selected3);
        hepa.setChecked(true);
        influ.setChecked(true);
        teta.setChecked(true);
    }


    public static void Save(File file, String[] data)
    {
        FileOutputStream fos = null;
        try
        {
            fos = new FileOutputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        try
        {
            try
            {
                for (int i = 0; i<data.length; i++)
                {
                    fos.write(data[i].getBytes());
                    if (i < data.length-1)
                    {
                        fos.write("\n".getBytes());
                    }
                }
            }
            catch (IOException e) {e.printStackTrace();}
        }
        finally
        {
            try
            {
                fos.close();
            }
            catch (IOException e) {e.printStackTrace();}
        }
    }


    public static String[] Load(File file)
    {
        FileInputStream fis = null;
        try
        {
            fis = new FileInputStream(file);
        }
        catch (FileNotFoundException e) {e.printStackTrace();}
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String test;
        int anzahl=0;
        try
        {
            while ((test=br.readLine()) != null)
            {
                anzahl++;
            }
        }
        catch (IOException e) {e.printStackTrace();}

        try
        {
            fis.getChannel().position(0);
        }
        catch (IOException e) {e.printStackTrace();}

        String[] array = new String[anzahl];

        String line;
        int i = 0;
        try
        {
            while((line=br.readLine())!=null)
            {
                array[i] = line;
                i++;
            }
        }
        catch (IOException e) {e.printStackTrace();}
        return array;
    }
}
