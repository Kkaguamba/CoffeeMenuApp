package com.example.coffeemenuapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.widget.TextView;

public class SplashScreen extends AppCompatActivity {
    TextView appName;
    private Handler handler = new Handler();
    private  Runnable runnable;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        appName = findViewById(R.id.app_name);

        appName.animate().translationY(-700).setDuration(2700).setStartDelay(0);
        runnable = new Runnable() {
            @Override
            public void run() {
                Intent i = new Intent(SplashScreen.this, WelcomePage.class);
                startActivity(i);
                finish();//to finish the current activity to prevent it from being displayed again when the user
                //presses the back button.
            }
        };
        handler.postDelayed(runnable,7000);
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        handler.removeCallbacks(runnable);
    }
}