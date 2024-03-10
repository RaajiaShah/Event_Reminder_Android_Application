package com.example.event_reminder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;

import static com.example.event_reminder.R.id.myProgressBar;

public class splash_screen extends AppCompatActivity {


    private ProgressBar mpb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);


        mpb = (ProgressBar) findViewById(R.id.myProgressBar);


        new Thread(new Runnable() {
            @Override
            public void run() {

                doWork();
                startScreen();
                finish();

            }


        }).start();
    }



    public void doWork() {

        for (int Progress = 0; Progress < 100; Progress += 10) {
            try {
                Thread.sleep(1000);
                mpb.setProgress(Progress);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private void startScreen() {
        Intent i = new Intent(splash_screen.this, MainActivity.class);
        startActivity(i);
    }
}