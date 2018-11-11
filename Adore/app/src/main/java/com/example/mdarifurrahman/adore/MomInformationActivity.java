package com.example.mdarifurrahman.adore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class MomInformationActivity extends AppCompatActivity {

    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    String name="",birthdate="",weightbefore="",weightafter="",period="",firstchkupdate="";
    TextView info_name_txt,info_birthdate_txt,info_weight_before_txt,info_weight_after_txt,info_perioddate_txt,info_firstchkupdate_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mom_information);

        //TextView info_name_txt,info_birthdate_txt,info_weight_before_txt,info_weight_after_txt,info_perioddate_txt,info_firstchkupdate_txt;

        info_name_txt=(TextView)findViewById(R.id.info_mom_nametv);
        info_birthdate_txt=(TextView)findViewById(R.id.info_mom_birthdatetv);
        info_weight_before_txt=(TextView)findViewById(R.id.info_mom_weight_beforetv);
        info_weight_after_txt=(TextView)findViewById(R.id.info_mom_weight_aftertv);
        info_perioddate_txt=(TextView)findViewById(R.id.info_mom_periodtv);
        info_firstchkupdate_txt=(TextView)findViewById(R.id.info_mom_firstcheckupdatetv);

       /* String name= info_name_txt.getText().toString();
        String birthdate=info_birthdate_txt.getText().toString();
        String weightbefore=info_weight_before_txt.getText().toString();
        String weightafter=info_weight_after_txt.getText().toString();
        String period=info_perioddate_txt.getText().toString();
        String firstchkupdate=info_firstchkupdate_txt.getText().toString();
*/
       /* name= info_name_txt.getText().toString();
        birthdate=info_birthdate_txt.getText().toString();
        weightbefore=info_weight_before_txt.getText().toString();
        weightafter=info_weight_after_txt.getText().toString();
        period=info_perioddate_txt.getText().toString();
        firstchkupdate=info_firstchkupdate_txt.getText().toString();
        */
        File dir=new File(path);
        dir.mkdir();
        try{
            loadfunc();
        }catch(Exception e)
        {
            savefunc();
        }
        OnClickMomInfoSaveListener();
    }

    public void OnClickMomInfoSaveListener(){

        Button mominfosave=(Button)findViewById(R.id.mominfosavebtn);
        mominfosave.setOnClickListener(
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
        //////////////////
        try{
            name= info_name_txt.getText().toString();
            birthdate=info_birthdate_txt.getText().toString();
            weightbefore=info_weight_before_txt.getText().toString();
            weightafter=info_weight_after_txt.getText().toString();
            period=info_perioddate_txt.getText().toString();
            firstchkupdate=info_firstchkupdate_txt.getText().toString();
        }catch(Exception e)
        {

        }
        /////////
        File file=new File(path+"/mominformation.txt");
        String temp=name+";"+birthdate+";"+weightbefore+";"+weightafter+";"+period+";"+firstchkupdate;
        String [] savetxt=temp.split(";");
        Save(file,savetxt);
    }

    public void loadfunc()
    {
        File file=new File(path+"/mominformation.txt");
        String [] loadtxt=Load(file);
       info_name_txt.setText(loadtxt[0]);
        info_birthdate_txt.setText(loadtxt[1]);
        info_weight_before_txt.setText(loadtxt[2]);
        info_weight_after_txt.setText(loadtxt[3]);
        info_perioddate_txt.setText(loadtxt[4]);
        info_firstchkupdate_txt.setText(loadtxt[5]);
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
