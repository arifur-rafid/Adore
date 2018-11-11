package com.example.mdarifurrahman.adore;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.support.v4.app.ActivityCompat;
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

public class EmergencyInformationActivity extends AppCompatActivity {
    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    String num1="",num2="",num3="",rechargecode="",emergengy_msg="";
    TextView info_num1,info_num2,info_num3,info_ememsg,info_rechargecode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency_information);

        info_num1=(TextView)findViewById(R.id.emergencynumber1tv);
        info_num2=(TextView)findViewById(R.id.emergencynumber2tv);
        info_num3=(TextView)findViewById(R.id.emergencynumber3tv);
        info_ememsg=(TextView)findViewById(R.id.emergencymessagetv);
        info_rechargecode=(TextView)findViewById(R.id.rechargecodetv);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED ) {

                requestPermissions(new  String[]{
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                }, 10);
                return;
            }

        }
        File dir=new File(path);
        dir.mkdir();

        try{
            loadfunc();
        }catch(Exception e)
        {
            savefunc();
        }
        OnClickEmergencyInfoSaveListener();
    }

    public void OnClickEmergencyInfoSaveListener(){

        Button emergencysave=(Button)findViewById(R.id.emergencyinformationsavebtn);
        emergencysave.setOnClickListener(
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

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case 10:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED) {

                    //OnClickHelpListener();
                }
                return;
        }

    }

    public void savefunc()
    {
        //////////////////
        num1= info_num1.getText().toString();
        num2=info_num2.getText().toString();
        num3=info_num3.getText().toString();
        emergengy_msg=info_ememsg.getText().toString();
        rechargecode=info_rechargecode.getText().toString();

        /////////
        File file=new File(path+"/emergencyinformation.txt");
        String temp=num1+";"+num2+";"+num3+";"+emergengy_msg+";"+rechargecode;
        String [] savetxt=temp.split(";");
        Save(file,savetxt);
    }

    public void loadfunc()
    {
        File file=new File(path+"/emergencyinformation.txt");
        String [] loadtxt=Load(file);
        info_num1.setText(loadtxt[0]);
        info_num2.setText(loadtxt[1]);
        info_num3.setText(loadtxt[2]);
        info_ememsg.setText(loadtxt[3]);
        info_rechargecode.setText(loadtxt[4]);
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
