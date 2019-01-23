package com.example.sunfit.sunfit;

import android.icu.text.SimpleDateFormat;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class MainPageActivity extends AppCompatActivity {
    private String v_person= "Ranjan";//getString();
    private long v_activity_steps= 20000;//Integer.valueOf(getString());
    private long v_redeemed_steps= 0;//Integer.valueOf(getString());
    private Date v_today_dt= new Date();
    //private final TextView TodayStepsTextView = (TextView) findViewById(R.id.textView_today_steps);
    //private final TextView TotalRedeemedStepsTextView = (TextView) findViewById(R.id.textView_total_redeemed_steps);
    //private final TextView StepsAvailRedeemTextView = (TextView) findViewById(R.id.textView_steps_available_for_redeem);
    globals stepGlobalInstance = globals.getInstance();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        final TextView TodayStepsTextView = (TextView) findViewById(R.id.textView_today_steps);
        final TextView TotalRedeemedStepsTextView = (TextView) findViewById(R.id.textView_total_redeemed_steps);
        final TextView StepsAvailRedeemTextView = (TextView) findViewById(R.id.textView_steps_available_for_redeem);
        Button RedeemButton = (Button) findViewById(R.id.button_redeem);
        //Intent intent = getIntent();
        //String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView_login_click_2);
        textView.setText("Welcome "+v_person.toString());
        TodayStepsTextView.setText("Today's Steps... "+String.valueOf(v_activity_steps));
        TotalRedeemedStepsTextView.setText("Total Redeemed Steps... "+String.valueOf(v_redeemed_steps));
        StepsAvailRedeemTextView.setText("Steps Available For Redeem... "+String.valueOf(v_activity_steps-v_redeemed_steps));

        RedeemButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*v_redeemed_steps=v_redeemed_steps+2000;
                v_activity_steps=v_activity_steps-v_redeemed_steps;
                TodayStepsTextView.setText("Today's Steps... "+String.valueOf(v_activity_steps));
                TotalRedeemedStepsTextView.setText("Total Redeemed Steps... "+String.valueOf(v_redeemed_steps));
                StepsAvailRedeemTextView.setText("Steps Available For Redeem... "+String.valueOf(v_activity_steps-v_redeemed_steps));
                */
                Intent intent = new Intent(MainPageActivity.this, RedeemPageActivity.class);
                intent.putExtra("REDEEM STEPS",v_activity_steps);
                startActivityForResult(intent,1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        final TextView TodayStepsTextView = (TextView) findViewById(R.id.textView_today_steps);
        final TextView TotalRedeemedStepsTextView = (TextView) findViewById(R.id.textView_total_redeemed_steps);
        final TextView StepsAvailRedeemTextView = (TextView) findViewById(R.id.textView_steps_available_for_redeem);
        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                long v_redeemed_activity_steps=data.getLongExtra("REDEEMED STEPS",0);
                //long v_redeemed_activity_steps=stepGlobalInstance.getRedeemedSteps();
                Toast.makeText(MainPageActivity.this,v_redeemed_activity_steps+"steps",Toast.LENGTH_LONG).show();
                v_redeemed_steps = v_redeemed_steps+v_redeemed_activity_steps;
                v_activity_steps=v_activity_steps-v_redeemed_activity_steps;
                TodayStepsTextView.setText("Today's Steps... "+String.valueOf(v_activity_steps));
                TotalRedeemedStepsTextView.setText("Total Redeemed Steps... "+String.valueOf(v_redeemed_steps));
                StepsAvailRedeemTextView.setText("Steps Available For Redeem... "+String.valueOf(v_activity_steps));
            }
    }
}
}
