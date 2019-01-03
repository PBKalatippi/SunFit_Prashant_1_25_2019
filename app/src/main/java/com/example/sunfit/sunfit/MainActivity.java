package com.example.sunfit.sunfit;

import android.icu.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;


import java.lang.*;
import java.util.*;

//import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.sunfit.sunfit.MESSAGE";
    //TextView LoginTextView = (TextView) findViewById(R.id.textView_login);
    //TextView LoginClickTextView = (TextView) findViewById(R.id.textView_login_click);
    //private Button LoginButton = (Button) findViewById(R.id.button_login);
    //String v_person= "Ranjan";//getString();
    //long v_activity_steps= 1000;//Integer.valueOf(getString());
    //Date v_today_dt= new Date();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView LoginTextView = (TextView) findViewById(R.id.textView_login);
        final TextView LoginClickTextView = (TextView) findViewById(R.id.textView_login_click);
        Button LoginButton = (Button) findViewById(R.id.button_login);
        //final String v_person= "Ranjan";//getString();
        //final long v_activity_steps= 1000;//Integer.valueOf(getString());
        //final Date v_today_dt= new Date();

        LoginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LoginClickTextView.setText("Hello");
                Intent intent = new Intent(MainActivity.this, MainPageActivity.class);
                //EditText editText = (EditText) findViewById(R.id.textView_login_click);
                //String message = editText.getText().toString();
                //String message = LoginClickTextView.getText().toString();
                //intent.putExtra(EXTRA_MESSAGE, message);

                startActivity(intent);
            }
        });
    }

   /* //Method to read the information from FitBit//
    public void Mtd_ReadActivity(){
        String v_person= "Ranjan";//getString();
        long v_activity_steps= 1000;//Integer.valueOf(getString());
        Date v_today_dt= new Date();
        //SimpleDateFormat dt= new SimpleDateFormat("yyyy-mm-dd hh:mm:ss"); //not supported on sdk 23
        System.out.println("Current Date: "+ v_today_dt);
        System.out.println("Person Name: "+ v_person);
        System.out.println("Activity Count: "+ v_activity_steps);


    }

    //Method to push data from Tracker to App//
    public void ClickLogin(View view){
        Login myLogin=Login.makeText(this,"SunTrust",Login.LENGTH_SHORT);
        myLogin.show();
    }
*/

}

