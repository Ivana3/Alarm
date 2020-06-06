package com.example.alarm;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.awt.font.TextAttribute;

public class MainActivity extends AppCompatActivity {

    TextView plainText;
    TextView textView;

    public void select (View view) {
        plainText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
        try {
            int time = Integer.parseInt(plainText.getText().toString());

            final int miliSecond = time * 1000;
            new CountDownTimer(miliSecond, 1000) {
                @Override
                public void onTick(long millisUntilFinished) {
                    textView.setText("00.0" +String.valueOf(millisUntilFinished/1000));

                }

                @Override
                public void onFinish() {

                }
            }.start();
        }
        catch (NumberFormatException e) {
            Toast.makeText(this, "Enter value in integer only", Toast.LENGTH_LONG).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }
}
