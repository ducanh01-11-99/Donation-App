package com.example.donation_app;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import android.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Button donateButton;
        RadioGroup paymentMethod;
        ProgressBar progressBar;
        NumberPicker amountPicker;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        donateButton = (Button) findViewById(R.id.donateButton);
    }
}