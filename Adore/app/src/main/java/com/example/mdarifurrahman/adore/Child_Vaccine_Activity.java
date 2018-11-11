package com.example.mdarifurrahman.adore;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Child_Vaccine_Activity extends AppCompatActivity {

    CheckBox BCG,Oral_Polio_First_Dose,Hepatities_B_First_Dose,DPT_First_Dose,Oral_Polio_Second_Dose,Hepatities_B_Second_Dose,DPT_Second_Dose,Oral_Polio_Third_Dose;
    CheckBox DPT_Third_Dose,Oral_Polio_Fourth_Dose,Hib_First_Dose,Hib_Second_Dose,Hepatities_B_Third_Dose,Hib_Third_Dose,Measles,Varilix;
    Button child_vaccine_save;
    boolean BCG_var,Oral_Polio_First_Dose_var,Hepatities_B_First_Dose_var,DPT_First_Dose_var,Oral_Polio_Second_Dose_var,Hepatities_B_Second_Dose_var,DPT_Second_Dose_var,Oral_Polio_Third_Dose_var;
    boolean DPT_Third_Dose_var,Oral_Polio_Fourth_Dose_var,Hib_First_Dose_var,Hib_Second_Dose_var,Hepatities_B_Third_Dose_var,Hib_Third_Dose_var,Measles_var,Varilix_var;
    TextView birthdatepart,After_Six_Weeks,After_Ten_Weeks,After_Fourteen_Weeks,After_Twenty_Weeks,After_Sixth_Months,After_Nine_Months,After_One_Year;
    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    private int date,month,year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_child__vaccine_);
        File dir=new File(path);
        dir.mkdir();
        BCG=(CheckBox)findViewById(R.id.BCGchkbox);
        Oral_Polio_First_Dose=(CheckBox)findViewById(R.id.Oral_Polio_First_Dosechkbox);
        Hepatities_B_First_Dose=(CheckBox)findViewById(R.id.Hepatities_B_First_Dosechkbox);
        DPT_First_Dose=(CheckBox)findViewById(R.id.DPT_First_Dosechkbox);
        Oral_Polio_Second_Dose=(CheckBox)findViewById(R.id.Oral_Polio_Second_Dosechkbox);
        Hepatities_B_Second_Dose=(CheckBox)findViewById(R.id.Hepatities_B_Second_Dosechkbox);
        DPT_Second_Dose=(CheckBox)findViewById(R.id.DPT_Second_Dosechkbox);
        Oral_Polio_Third_Dose=(CheckBox)findViewById(R.id.Oral_Polio_Third_Dose);
        DPT_Third_Dose=(CheckBox)findViewById(R.id.DPT_Third_Dosechkbox);
        Oral_Polio_Fourth_Dose=(CheckBox)findViewById(R.id.Oral_Polio_Fourth_Dosechkbox);
        Hib_First_Dose=(CheckBox)findViewById(R.id.Hib_First_Dosechkbox);
        Hib_Second_Dose=(CheckBox)findViewById(R.id.Hib_Second_Dosechkbox);
        Hepatities_B_Third_Dose=(CheckBox)findViewById(R.id.Hepatities_B_Third_Dosechkbox);
        Hib_Third_Dose= (CheckBox) findViewById(R.id.Hib_Third_Dosechkbox);
        Measles= (CheckBox) findViewById(R.id.Measleschkbox);
        Varilix=(CheckBox)findViewById(R.id.Varilixchkbox);

        birthdatepart=(TextView)findViewById(R.id.birthtimetv);
        After_Six_Weeks=(TextView)findViewById(R.id.After_Six_Weekstv);
        After_Ten_Weeks=(TextView)findViewById(R.id.After_Ten_Weekstv);
        After_Fourteen_Weeks=(TextView)findViewById(R.id.After_Fourteen_Weekstv);
        After_Twenty_Weeks=(TextView)findViewById(R.id.After_Twenty_Weekstv);
        After_Sixth_Months=(TextView)findViewById(R.id.After_Sixth_Monthstv);
        After_Nine_Months=(TextView)findViewById(R.id.After_Nine_Monthstv);
        After_One_Year=(TextView)findViewById(R.id.After_One_Yeartv);


        try{
            loadfunc();
            loadfunc_birthdate();
        }catch(Exception e)
        {
            savefunc();
        }
        OnClickChildVaccinesaveListener();
    }

    public void OnClickChildVaccinesaveListener(){
        child_vaccine_save=(Button) findViewById(R.id.child_vaccine_savebtn);
        child_vaccine_save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       try{
                           savefunc();
                           loadfunc();
                           loadfunc_birthdate();
                       }catch(Exception e){

                       }
                        Toast.makeText(getApplicationContext(),"Saved",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void loadfunc_birthdate()
    {
        File file=new File(path+"/childinformation.txt");
        String [] loadtxt=Load(file);
        String temp=loadtxt[1];
        birthdatepart.setText(temp);
        //After_Six_Weeks.setText(datecalculator(180));
        String [] v=temp.split("/");
        date=Integer.parseInt(v[0]);
        month=Integer.parseInt(v[1]);
        year=Integer.parseInt(v[2]);
        int tempforyear=year+1;
        After_Six_Weeks.setText(datecalculator(42));
        After_Ten_Weeks.setText(datecalculator(70));
        After_Fourteen_Weeks.setText(datecalculator(98));
        After_Twenty_Weeks.setText(datecalculator(140));
        After_Sixth_Months.setText(monthcalculator(6));
        After_Nine_Months.setText(monthcalculator(9));
        After_One_Year.setText(date+"/"+month+"/"+tempforyear);
    }

    public void savefunc()
    {
        BCG_var= BCG.isChecked();
        Oral_Polio_First_Dose_var=Oral_Polio_First_Dose.isChecked();
        Hepatities_B_First_Dose_var=Hepatities_B_First_Dose.isChecked();
        DPT_First_Dose_var=DPT_First_Dose.isChecked();
        Oral_Polio_Second_Dose_var=Oral_Polio_Second_Dose.isChecked();
        Hepatities_B_Second_Dose_var=Hepatities_B_Second_Dose.isChecked();
        DPT_Second_Dose_var=DPT_Second_Dose.isChecked();
        Oral_Polio_Third_Dose_var=Oral_Polio_Third_Dose.isChecked();

        DPT_Third_Dose_var=DPT_Third_Dose.isChecked();
        Oral_Polio_Fourth_Dose_var=Oral_Polio_Fourth_Dose.isChecked();
        Hib_First_Dose_var=Hib_First_Dose.isChecked();
        Hib_Second_Dose_var=Hib_Second_Dose.isChecked();
        Hepatities_B_Third_Dose_var=Hepatities_B_Third_Dose.isChecked();
        Hib_Third_Dose_var=Hib_Third_Dose.isChecked();
        Measles_var=Measles.isChecked();
        Varilix_var=Varilix.isChecked();
        String temp=BCG_var+"/"+Oral_Polio_First_Dose_var+"/"+Hepatities_B_First_Dose_var+"/"+DPT_First_Dose_var+"/"+Oral_Polio_Second_Dose_var+"/"+Hepatities_B_Second_Dose_var+"/"+DPT_Second_Dose_var+"/"+Oral_Polio_Third_Dose_var+"/"+DPT_Third_Dose_var+"/"+Oral_Polio_Fourth_Dose_var+"/"+Hib_First_Dose_var+"/"+Hib_Second_Dose_var+"/"+Hepatities_B_Third_Dose_var+"/"+Hib_Third_Dose_var+"/"+Measles_var+"/"+Varilix_var;
        File file=new File(path+"/childsavedvaccine.txt");
        String [] savetxt=temp.split("/");
        Save(file,savetxt);
    }
    public void loadfunc()
    {
        File file=new File(path+"/childsavedvaccine.txt");
        String [] loadtxt=Load(file);
        BCG_var=Boolean.parseBoolean(loadtxt[0]);
        Oral_Polio_First_Dose_var=Boolean.parseBoolean(loadtxt[1]);
        Hepatities_B_First_Dose_var=Boolean.parseBoolean(loadtxt[2]);
        DPT_First_Dose_var=Boolean.parseBoolean(loadtxt[3]);
        Oral_Polio_Second_Dose_var=Boolean.parseBoolean(loadtxt[4]);
        Hepatities_B_Second_Dose_var=Boolean.parseBoolean(loadtxt[5]);
        DPT_Second_Dose_var=Boolean.parseBoolean(loadtxt[6]);
        Oral_Polio_Third_Dose_var=Boolean.parseBoolean(loadtxt[7]);

        DPT_Third_Dose_var=Boolean.parseBoolean(loadtxt[8]);
        Oral_Polio_Fourth_Dose_var=Boolean.parseBoolean(loadtxt[9]);
        Hib_First_Dose_var=Boolean.parseBoolean(loadtxt[10]);
        Hib_Second_Dose_var=Boolean.parseBoolean(loadtxt[11]);
        Hepatities_B_Third_Dose_var=Boolean.parseBoolean(loadtxt[12]);
        Hib_Third_Dose_var=Boolean.parseBoolean(loadtxt[13]);
        Measles_var=Boolean.parseBoolean(loadtxt[14]);
        Varilix_var=Boolean.parseBoolean(loadtxt[15]);

        if(BCG_var==true) BCG.setChecked(true);
        if(Oral_Polio_First_Dose_var==true) Oral_Polio_First_Dose.setChecked(true);
        if(Hepatities_B_First_Dose_var==true) Hepatities_B_First_Dose.setChecked(true);
        if(DPT_First_Dose_var==true) DPT_First_Dose.setChecked(true);
        if(Oral_Polio_Second_Dose_var==true) Oral_Polio_Second_Dose.setChecked(true);
        if(Hepatities_B_Second_Dose_var==true) Hepatities_B_Second_Dose.setChecked(true);
        if(DPT_Second_Dose_var==true) DPT_Second_Dose.setChecked(true);
        if(Oral_Polio_Third_Dose_var==true) Oral_Polio_Third_Dose.setChecked(true);

        if(DPT_Third_Dose_var==true) DPT_Third_Dose.setChecked(true);
        if(Oral_Polio_Fourth_Dose_var==true) Oral_Polio_Fourth_Dose.setChecked(true);
        if(Hib_First_Dose_var==true) Hib_First_Dose.setChecked(true);
        if(Hib_Second_Dose_var==true) Hib_Second_Dose.setChecked(true);
        if(Hepatities_B_Third_Dose_var==true) Hepatities_B_Third_Dose.setChecked(true);
        if(Hib_Third_Dose_var==true) Hib_Third_Dose.setChecked(true);
        if(Measles_var==true) Measles.setChecked(true);
        if(Varilix_var==true) Varilix.setChecked(true);

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

    public String datecalculator(int days)
    {
        int second_day_first=date;
        int second_month_first=month;
        int second_year_first=year;
        second_day_first+=days;
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

        }
        String finaltemp=second_day_first+"/"+second_month_first+"/"+year;
        return finaltemp;
    }

    public String monthcalculator(int months)
    {
        int second_day_first=date;
        int second_month_first=month;
        int second_year_first=year;
        second_month_first=second_month_first+months;
        if(second_month_first>12)
        {
            second_month_first=second_month_first-12;
            second_year_first++;
        }

        String finaltemp=second_day_first+"/"+second_month_first+"/"+second_year_first;
        return finaltemp;
    }

}
