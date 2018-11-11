package com.example.mdarifurrahman.adore;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.Settings;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.txusballesteros.bubbles.BubbleLayout;
import com.txusballesteros.bubbles.BubblesManager;
import com.txusballesteros.bubbles.OnInitializedCallback;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;


public class EmergencyHomeActivity extends AppCompatActivity {
    LocationManager locationManager;
    LocationListener locationListener;
    boolean flag=false;
    public String path= Environment.getExternalStorageDirectory().getAbsolutePath()+ "/aAdore";
    String num1="",num2="",num3="",rechargecode="",emergengy_msg="",emergency_loc1="",emergency_loc2="",temp;
    String  longitude,latitude;
    double lon,lat;
    private int count=0;
    long  start=0,end=0;
    private BubblesManager bubblesManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergency);
        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                longitude=Double.toString(location.getLatitude());
                latitude=Double.toString(location.getLongitude());
                // lon=Double.parseDouble(longitude);
                //lat=Double.parseDouble(latitude);
                emergency_loc1=longitude;
                emergency_loc2=latitude;
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

                Intent intent = new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if ((ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this, Manifest.permission.INTERNET) != PackageManager.PERMISSION_GRANTED) && (ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) && ActivityCompat.checkSelfPermission(this, Manifest.permission.SYSTEM_ALERT_WINDOW) != PackageManager.PERMISSION_GRANTED){

                requestPermissions(new  String[]{
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION,
                        Manifest.permission.INTERNET,
                        Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.SYSTEM_ALERT_WINDOW,

                }, 10);
                return;
            }

        } else {
            OnClickbubbleListener();
            OnClickHelpListener();

        }


        File dir=new File(path);
        dir.mkdir();
        try{
            loadfunc();
        }catch(Exception e)
        {
            Toast.makeText(getApplicationContext()," Emergency Information Is Not Complete",Toast.LENGTH_LONG).show();
        }
        OnClickrechargeListener();
        OnClickHelpListener();
        OnClickbubbleListener();
        //initializeBubblesManager();

    }
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        switch (requestCode)
        {
            case 10:
                if(grantResults.length>0 && grantResults[0]== PackageManager.PERMISSION_GRANTED) {

                    OnClickHelpListener();
                    OnClickbubbleListener();
                }
                break;
        }

    }


    public void OnClickrechargeListener(){

        ImageButton recharge=(ImageButton)findViewById(R.id.rechargeIB);
        recharge.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        try{
                            loadfunc();
                        }catch(Exception e)
                        {
                            savefunc();
                        }
                        Intent callIntent=new Intent(Intent.ACTION_CALL);
                        temp=temp+Uri.encode("#");
                        callIntent.setData(Uri.parse("tel:"+temp));
                        try{
                            if(temp.length()>4)
                            {
                                startActivity(callIntent);
                                // savefunc();
                            }
                            else Toast.makeText(getApplicationContext(),"Please Check Recharge Number",Toast.LENGTH_LONG).show();
                        }catch(Exception e){
                            Toast.makeText(getApplicationContext(),"Recharge Failed",Toast.LENGTH_LONG).show();
                        }

                    }
                }
        );
    }

    public void OnClickHelpListener() {
        ImageButton help=(ImageButton)findViewById(R.id.helpIB);


        help.setOnClickListener(
                new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        try{
                            try{
                                locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                            }catch (SecurityException e){
                            }
                            //start GPS
                            loadfunc();
                            if(num1.length()>10&&emergengy_msg.length()>=0)
                            {
                                if(num1.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0))
                                {
                                    String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                    emergengy_msg=emergengy_msg+" "+link1;
                                    sendMsg(num1,emergengy_msg);
                                    //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                                }
                                else Toast.makeText(getApplicationContext(),"Please Tap The Button Again",Toast.LENGTH_LONG).show();
                            }
                            else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 1 & GPS & internet Connection",Toast.LENGTH_LONG).show();
                            if(num2.length()>10&&emergengy_msg.length()>=0)
                            {
                                if(num2.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0))
                                {
                                    String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                    emergengy_msg=emergengy_msg+" "+link1;
                                    sendMsg(num2,emergengy_msg);
                                    //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                                }
                            }
                            else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 2 & Valid GPS Connection",Toast.LENGTH_LONG).show();
                            if(num3.length()>10&&emergengy_msg.length()>=0){
                                if(num3.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0)){
                                    String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                    emergengy_msg=emergengy_msg+" "+link1;
                                    sendMsg(num3,emergengy_msg);
                                    //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                                }
                            }
                            else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 3 & Valid GPS Connection",Toast.LENGTH_LONG).show();

                        }catch(Exception e){
                        }


                    }
                }
        );
    }

    private void sendMsg(String number,String msg){
        try{
            SmsManager smsManager= SmsManager.getDefault();
            smsManager.sendTextMessage(number,null,msg,null,null);
            Toast.makeText(getApplicationContext(),"Message Send",Toast.LENGTH_LONG).show();
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Message Send Failed",Toast.LENGTH_LONG).show();
        }
    }

    public void savefunc()
    {
        File file=new File(path+"/emergencyinformation.txt");
        String temp=num1+";"+num2+";"+num3+";"+emergengy_msg+";"+" ";
        String [] savetxt=temp.split(";");
        Save(file,savetxt);
    }

    public void loadfunc()
    {
        File file=new File(path+"/emergencyinformation.txt");
        String [] loadtxt=Load(file);
        num1=loadtxt[0];
        num2=loadtxt[1];
        num3=loadtxt[2];
        emergengy_msg=loadtxt[3];
        rechargecode=loadtxt[4];
        temp=loadtxt[4];
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




    /*bubble button work*/
    public void OnClickbubbleListener(){
        ImageButton bubble=(ImageButton)findViewById(R.id.bubblebtn);
        bubble.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(flag==false)
                        {
                            try{
                                initializeBubblesManager();
                                addNewBubble();
                                flag=true;
                            }catch(Exception e){

                            }
                        }
                    }
                }
        );
    }

    private void addNewBubble() {
        BubbleLayout bubbleView = (BubbleLayout) LayoutInflater.from(EmergencyHomeActivity.this).inflate(R.layout.bubble_layout, null);
        bubbleView.setOnBubbleRemoveListener(new BubbleLayout.OnBubbleRemoveListener() {
            @Override
            public void onBubbleRemoved(BubbleLayout bubble) {
                flag=false;
            }
        });
        bubbleView.setOnBubbleClickListener(new BubbleLayout.OnBubbleClickListener() {

            @Override
            public void onBubbleClick(BubbleLayout bubble) {
                //Toast.makeText(getApplicationContext(), "Clicked !", Toast.LENGTH_SHORT).show();
                count++;
                if(count==1)
                {
                    start=System.currentTimeMillis();
                }
                if(count==2)
                {
                    end=System.currentTimeMillis();
                }
                if(count==2&&((end-start)<200))
                {
                    try{
                        try{
                            locationManager.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListener);
                        }catch (SecurityException e){
                        }
                        //start GPS
                        loadfunc();
                        if(num1.length()>10&&emergengy_msg.length()>=0)
                        {

                            if(num1.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0))
                            {
                                String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                emergengy_msg=emergengy_msg+" "+link1;
                                sendMsg(num1,emergengy_msg);
                                //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                            }
                            else Toast.makeText(getApplicationContext(),"Please Tap The Button Again",Toast.LENGTH_LONG).show();
                        }
                        else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 1 & GPS & internet Connection",Toast.LENGTH_LONG).show();
                        if(num2.length()>10&&emergengy_msg.length()>=0)
                        {
                            if(num2.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0))
                            {
                                String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                emergengy_msg=emergengy_msg+" "+link1;
                                sendMsg(num2,emergengy_msg);
                                //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                            }
                        }
                        else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 2 & Valid GPS Connection",Toast.LENGTH_LONG).show();
                        if(num3.length()>10&&emergengy_msg.length()>=0){
                            if(num3.length()>10&&(emergency_loc1.length()>0&&emergency_loc2.length()>0)){
                                String link1="http://maps.google.com/maps?q="+longitude+","+latitude;
                                emergengy_msg=emergengy_msg+" "+link1;
                                sendMsg(num3,emergengy_msg);
                                //Toast.makeText(getApplicationContext(), emergengy_msg,Toast.LENGTH_LONG).show();
                            }
                        }
                        else Toast.makeText(getApplicationContext(),"Check Your Emergency Information 3 & Valid GPS Connection",Toast.LENGTH_LONG).show();

                    }catch(Exception e){
                    }
                    count=0;
                }
                else if((end-start)>200)
                {
                    end=0;
                    start=0;
                    count=0;
                }

            }
        });
        bubbleView.setShouldStickToWall(true);
        bubblesManager.addBubble(bubbleView, 60, 20);
    }
    private void initializeBubblesManager() {
        bubblesManager = new BubblesManager.Builder(this)
                .setTrashLayout(R.layout.bubble_trash_layout)
                .setInitializationCallback(new OnInitializedCallback() {
                    @Override
                    public void onInitialized() {
                        try{
                            addNewBubble();
                        }catch(Exception e){

                        }

                    }
                })
                .build();
        bubblesManager.initialize();
    }
   /* @Override
    protected void onDestroy() {
        super.onDestroy();
        bubblesManager.recycle();
    }*/

}
