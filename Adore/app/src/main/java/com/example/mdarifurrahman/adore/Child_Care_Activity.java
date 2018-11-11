package com.example.mdarifurrahman.adore;

import android.os.Environment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Child_Care_Activity extends AppCompatActivity {
    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    TextView growthtest;
    int first_day=31 ;
    int first_month=2 ;
    int first_year=1996 ;
    int result=0;
    int ecpectedday=0,ecpectedmonth=0,ecpectedyear=0;
    String [] arr=new String[12];
    int currentday=0,currentmonth=0,currentyear=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child__care_);
        func_call();
        //growthtest=(TextView)findViewById(R.id.growthtest);
        Calendar c = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
        String strDate = sdf.format(c.getTime());
       // growthtest=(TextView)findViewById(R.id.growthtest);
        String [] temporary=strDate.split("-");
        currentday=Integer.parseInt(temporary[0]);
        currentmonth=Integer.parseInt(temporary[1]);
        currentyear=Integer.parseInt(temporary[2]);
        agecalculator();
        result=ecpectedday+30*ecpectedmonth+ecpectedyear*365;
        //growthtest.setText(result+"");
        chkfunc();
    }
    public void func_call(){
        try{
            loadfunc();

        }catch(Exception e)
        {
        }
    }
   public void agecalculator()
   {
       int temp_currentday=currentday,temp_currentmonth=currentmonth,temp_currentyear=currentyear;
       if((currentday-first_day)<0)
       {
           temp_currentday+=30;
           temp_currentmonth-=1;
           ecpectedday=temp_currentday-first_day;
       }
       else ecpectedday=temp_currentday-first_day;
       if(temp_currentmonth-first_month<0)
       {
           temp_currentmonth+=12;
           temp_currentyear-=1;
           ecpectedmonth=temp_currentmonth-first_month;
       }
       else ecpectedmonth=temp_currentmonth-first_month;
       ecpectedyear=temp_currentyear-first_year;
   }
    public void chkfunc()
    {
        if(result>=0&&result<=42)
        {
            babygrowth1Fragment babygrowth1Fragment = new babygrowth1Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth1Fragment);
            fragmentTransaction.commit();
        }
        else if(result>42&&result<=84)
        {
            babygrowth2Fragment babygrowth2Fragment = new babygrowth2Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth2Fragment);
            fragmentTransaction.commit();
        }
        else if(result>84&&result<=126)
        {
            babygrowth3Fragment babygrowth3Fragment = new babygrowth3Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth3Fragment);
            fragmentTransaction.commit();
        }
        else if(result>126&&result<=168)
        {
            babygrowth4Fragment babygrowth4Fragment = new babygrowth4Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth4Fragment);
            fragmentTransaction.commit();
        }
        else if(result>168&&result<=210)
        {
            babygrowth5Fragment babygrowth5Fragment = new babygrowth5Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth5Fragment);
            fragmentTransaction.commit();
        }
        else if(result>210&&result<=252)
        {
            babygrowth6Fragment babygrowth6Fragment = new babygrowth6Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth6Fragment);
            fragmentTransaction.commit();
        }
        else if(result>252&&result<=294)
        {
            babygrowth7Fragment babygrowth7Fragment = new babygrowth7Fragment();
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container_babygrowth, babygrowth7Fragment);
            fragmentTransaction.commit();
        }
        else  Toast.makeText(getApplicationContext(),"Your last menstrual date is not given.Please go to information in home menu to complete ",Toast.LENGTH_LONG).show();
    }

    public void loadfunc()
    {
        File file=new File(path+"/mominformation.txt");
        String [] loadtxt=Load(file);
        String temp=loadtxt[4];
        String [] v=temp.split("/");
        first_day=Integer.parseInt(v[0]);
        first_month=Integer.parseInt(v[1]);
        first_year=Integer.parseInt(v[2]);
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
    public boolean leapyear(int year){
        if(year%400==0||(year%100!=0&&year%4==0))
        {
            return true;
        }
        else return false;
    }


    public int daysofmonth(int x,int y)
    {
        if(x==4||x==6||x==9||x==10)return 30;
        else if(x==2)
        {
            if(leapyear(y))
            {
                return 29;
            }
            else return 28;
        }
        else return 31;
    }
    public String babygrowth_calculator(int date)
    {
        int growth_day=first_day;
        int growth_month=first_month;
        int growth_year=first_year;
        growth_day+=date;
        int temp=daysofmonth(growth_month,growth_year);
        if(growth_day>28)
        {
            while(growth_day>=temp)
            {
                int month_temp=daysofmonth(growth_month,growth_year);
                growth_day=growth_day-month_temp;
                growth_month++;
                if(growth_month>12)
                {
                    growth_year++;
                    growth_month=1;
                }
                temp=daysofmonth(growth_month,growth_year);;
            }
            if(growth_day==0){
                growth_day=1;
            }

        }
        return growth_day+"/"+growth_month+"/"+growth_year;
    }

}
