package com.example.mdarifurrahman.adore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;


public class CheckUpActivity extends AppCompatActivity {

    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    int first_day=0 ;
    int first_month=0 ;
    int first_year=0 ;

    public static int second_day_first = 0, second_month_first = 0, second_year_first = 0;
    public static int second_day_last = 0, second_month_last = 0, second_year_last = 0;

    public static int third_day_first = 0, third_month_first = 0, third_year_first = 0;
    public static int third_day_last = 0, third_month_last = 0, third_year_last = 0;

    public static int fourth_day_first = 0, fourth_month_first = 0, fourth_year_first = 0;
    public static int fourth_day_last = 0, fourth_month_last = 0, fourth_year_last = 0;

    public static int fifth_day_first = 0, fifth_month_first = 0, fifth_year_first = 0;
    public static int fifth_day_last = 0, fifth_month_last = 0, fifth_year_last = 0;

    public static int sixth_day_first = 0, sixth_month_first = 0, sixth_year_first = 0;
    public static int sixth_day_last = 0, sixth_month_last = 0, sixth_year_last = 0;

    public static int seventh_day_first = 0, seventh_month_first = 0, seventh_year_first = 0;
    public static int seventh_day_last = 0, seventh_month_last = 0, seventh_year_last = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_up);
        TextView second = (TextView) findViewById(R.id.secondtxtview);
        TextView third = (TextView) findViewById(R.id.thirdtxtview);
        TextView fourth = (TextView) findViewById(R.id.fourthtxtview);
        TextView fifth = (TextView) findViewById(R.id.fifthtxtview);
        TextView sixth = (TextView) findViewById(R.id.sixthtxtview);
        TextView seventh = (TextView) findViewById(R.id.seventhtxtview);

        func_call();
        second.setText(second_day_first+"/"+second_month_first+"/"+second_year_first+"  to  "+second_day_last+"/"+second_month_last+"/"+second_year_last);
        third.setText(third_day_first+"/"+third_month_first+"/"+third_year_first);
        fourth.setText(fourth_day_first+"/"+fourth_month_first+"/"+fourth_year_first+"  to  "+fourth_day_last+"/"+fourth_month_last+"/"+fourth_year_last);
        fifth.setText(fifth_day_first+"/"+fifth_month_first+"/"+fifth_year_first);
        sixth.setText(+sixth_day_first+"/"+sixth_month_first+"/"+sixth_year_first);
        seventh.setText(seventh_day_first+"/"+seventh_month_first+"/"+seventh_year_first);
    }

    public void func_call(){
        try{
            loadfunc();
        }catch(Exception e)
        {

        }
        if(first_day!=0&&first_month!=0&&first_year!=0)
        {
            secondchkupdatefirst();
            secondchkupdatelast();
            thirdchkupdatefirst();
            fourthchkupdatefirst();
            fourthchkupdatelast();
            fifthchkupdatefirst();
            sixthchkupdatefirst();
            seventhchkupdatefirst();
        }

    }

    public void loadfunc()
    {
        File file=new File(path+"/mominformation.txt");
        String [] loadtxt=Load(file);
        String temp=loadtxt[5];
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


    public void secondchkupdatefirst()
    {
        second_day_first=first_day;
        second_month_first=first_month;
        second_year_first=first_year;
        second_day_first+=56;
        int temp=daysofmonth(second_month_first,second_year_first);
        if(second_day_first>28)
        {
            while(second_day_first>=temp)
            {
                int month_temp=daysofmonth(second_month_first,second_year_first);
                second_day_first=second_day_first-month_temp;
                second_month_first++;
                if(second_month_first>12)
                {
                    second_year_first++;
                    second_month_first=1;
                }
                temp=daysofmonth(second_month_first,second_year_first);;
            }
            if(second_day_first==0)second_day_first=1;

        }
    }

    public void secondchkupdatelast()
    {
        second_day_last=first_day;
        second_month_last=first_month;
        second_year_last=first_year;
        second_day_last+=98;
        int temp=0;
        temp=daysofmonth(second_month_last,second_year_last);
        if(second_day_last>28)
        {
            while(second_day_last>=temp)
            {
                int month_temp=0;
                month_temp=daysofmonth(second_month_last,second_year_last);
                second_day_last=second_day_last-month_temp;
                second_month_last++;
                if(second_month_last>12)
                {
                    second_year_last++;
                    second_month_last=1;
                }
                temp=daysofmonth(second_month_last,second_year_last);;
            }
            if(second_day_last==0)second_day_last=1;

        }
    }

    public void thirdchkupdatefirst()
    {
        third_day_first=first_day;
        third_month_first=first_month;
        third_year_first=first_year;
        third_day_first+=112;
        int temp=daysofmonth(third_month_first,third_year_first);
        if(third_day_first>28)
        {
            while(third_day_first>=temp)
            {
                int month_temp=daysofmonth(third_month_first,second_year_first);
                third_day_first=third_day_first-month_temp;
                third_month_first++;
                if(third_month_first>12)
                {
                    third_year_first++;
                    third_month_first=1;
                }
                temp=daysofmonth(third_month_first,third_year_first);;
            }
            if(third_day_first==0)third_day_first=1;

        }
    }


    public void fourthchkupdatefirst()
    {
        fourth_day_first=first_day;
        fourth_month_first=first_month;
        fourth_year_first=first_year;
        fourth_day_first+=126;
        int temp=daysofmonth(fourth_month_first,fourth_year_first);
        if(fourth_day_first>28)
        {
            while(fourth_day_first>=temp)
            {
                int month_temp=daysofmonth(fourth_month_first,fourth_year_first);
                fourth_day_first=fourth_day_first-month_temp;
                fourth_month_first++;
                if(fourth_month_first>12)
                {
                    fourth_year_first++;
                    fourth_month_first=1;
                }
                temp=daysofmonth(fourth_month_first,fourth_year_first);;
            }
            if(fourth_day_first==0)fourth_day_first=1;

        }
    }

    public void fourthchkupdatelast()
    {
        fourth_day_last=first_day;
        fourth_month_last=first_month;
        fourth_year_last=first_year;
        fourth_day_last+=140;
        int temp=daysofmonth(fourth_month_last,fourth_year_last);
        if(fourth_day_last>28)
        {
            while(fourth_day_last>=temp)
            {
                int month_temp=daysofmonth(fourth_month_last,fourth_year_last);
                fourth_day_last=fourth_day_last-month_temp;
                fourth_month_last++;
                if(fourth_month_last>12)
                {
                    fourth_year_last++;
                    fourth_month_last=1;
                }
                temp=daysofmonth(fourth_month_last,fourth_year_last);;
            }
            if(fourth_day_last==0)fourth_day_last=1;

        }
    }

    public void fifthchkupdatefirst()
    {
        fifth_day_first=first_day;
        fifth_month_first=first_month;
        fifth_year_first=first_year;
        fifth_day_first+=196;
        int temp=daysofmonth(fifth_month_first,fifth_year_first);
        if(fifth_day_first>28)
        {
            while(fifth_day_first>=temp)
            {
                int month_temp=daysofmonth(fifth_month_first,fifth_year_first);
                fifth_day_first=fifth_day_first-month_temp;
                fifth_month_first++;
                if(fifth_month_first>12)
                {
                    fifth_year_first++;
                    fifth_month_first=1;
                }
                temp=daysofmonth(fifth_month_first,fifth_year_first);;
            }
            if(fifth_day_first==0)fifth_day_first=1;

        }
    }

    public void sixthchkupdatefirst()
    {
        sixth_day_first=first_day;
        sixth_month_first=first_month;
        sixth_year_first=first_year;
        sixth_day_first+=238;
        int temp=daysofmonth(sixth_month_first,sixth_year_first);
        if(sixth_day_first>28)
        {
            while(sixth_day_first>=temp)
            {
                int month_temp=daysofmonth(sixth_month_first,sixth_year_first);
                sixth_day_first=sixth_day_first-month_temp;
                sixth_month_first++;
                if(sixth_month_first>12)
                {
                    sixth_year_first++;
                    sixth_month_first=1;
                }
                temp=daysofmonth(sixth_month_first,sixth_year_first);;
            }
            if(sixth_day_first==0)sixth_day_first=1;

        }
    }

    public void seventhchkupdatefirst()
    {
        seventh_day_first=first_day;
        seventh_month_first=first_month;
        seventh_year_first=first_year;
        seventh_day_first+=252;
        int temp=daysofmonth(seventh_month_first,seventh_year_first);
        if(seventh_day_first>28)
        {
            while(seventh_day_first>=temp)
            {
                int month_temp=daysofmonth(seventh_month_first,seventh_year_first);
                seventh_day_first=seventh_day_first-month_temp;
                seventh_month_first++;
                if(seventh_month_first>12)
                {
                    seventh_year_first++;
                    seventh_month_first=1;
                }
                temp=daysofmonth(seventh_month_first,seventh_year_first);;
            }
            if(seventh_day_first==0)seventh_day_first=1;

        }
    }
}