package com.example.donation_app;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    Button donateButton;
    RadioGroup paymentMethod;
    ProgressBar progressBar;
    NumberPicker amountPicker;
    private int totalDonated = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donateButton = (Button) findViewById(R.id.donateButton);
        paymentMethod = (RadioGroup) findViewById(R.id.paymentMethod);
        progressBar = (ProgressBar) findViewById(R.id.progessBar);
        amountPicker = (NumberPicker) findViewById(R.id.amountPicker);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.floatingButtonEmail);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View view) {
                Log.d("click Floating_button_Email", "OK");
            }
        });
        if (donateButton != null) {
            Log.v("donateButton", "is not null");
        }
        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }


    public void onClickButtonDonate(View view) {
        int amount = amountPicker.getValue();
        int radioID = paymentMethod.getCheckedRadioButtonId();
        progressBar.setMax(10000);
        String method = "";
        if(radioID == R.id.Paypal) {
            method = "Paypal";
        } else if(radioID == R.id.Direct){
            method = "Direct";
        } else {
            method = "None";
        }
        Log.d("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
        totalDonated = totalDonated + amount;
        progressBar.setProgress(totalDonated);
        Log.v("Donate", "Current total " + totalDonated);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.report:
                Log.d("tag", "click report");
                startActivity(new Intent(this, Report.class));
                break;
            case R.id.settings:
                Log.d("tag", "click settings");
                break;
            default:
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}