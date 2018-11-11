package com.example.mdarifurrahman.adore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class ChildInformationActivity extends AppCompatActivity {

    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    private String name,birthdate,weight;
    TextView child_name,child_birthdate,child_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child_information);

        child_name=(TextView)findViewById(R.id.childnametv);
        child_birthdate=(TextView)findViewById(R.id.childbirthdatetv);
        child_weight=(TextView)findViewById(R.id.childweighttv);
        File dir=new File(path);
        dir.mkdir();
        try{
            loadfunc();
        }catch(Exception e)
        {
            savefunc();
        }
        OnClickChildInfoSaveListener();
    }
    public void OnClickChildInfoSaveListener(){

        Button child_information_save=(Button)findViewById(R.id.childinformationsavebtn);
        child_information_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       try{
                           savefunc();
                           loadfunc();
                       }catch(Exception e)
                       {

                       }
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void savefunc()
    {

        name= child_name.getText().toString();
        birthdate=child_birthdate.getText().toString();
        weight=child_weight.getText().toString();
        File file=new File(path+"/childinformation.txt");
        String temp=name+";"+birthdate+";"+weight;
        String [] savetxt=temp.split(";");
        Save(file,savetxt);
    }

    public void loadfunc()
    {
        File file=new File(path+"/childinformation.txt");
        String [] loadtxt=Load(file);
        child_name.setText(loadtxt[0]);
        child_birthdate.setText(loadtxt[1]);
        child_weight.setText(loadtxt[2]);
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
