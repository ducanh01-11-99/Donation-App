package com.example.donation_app;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

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

//       FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.)
//        donateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(android.view.View view) {
//                Log.d("click button", "OK");
//            }
//        });
        if (donateButton != null) {
            Log.v("donateButton", "is not null");
        }

        amountPicker.setMinValue(0);
        amountPicker.setMaxValue(1000);
    }

    public void onClickButtonDonate(View view) {
        int amount = amountPicker.getValue();
        int radioID = paymentMethod.getCheckedRadioButtonId();
        String method = "";
        if(radioID == R.id.Paypal) {
            method = "Paypal";
        } else {
            method = "Direct";
        }
        Log.d("Donate", "Donate Pressed! with amount " + amount + ", method: " + method);
        totalDonated = totalDonated + amount;
        progressBar.setProgress(totalDonated);
        Log.v("Donate", "Current total " + totalDonated);

    }
}