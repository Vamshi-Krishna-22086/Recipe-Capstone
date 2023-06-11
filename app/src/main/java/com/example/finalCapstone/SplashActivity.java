package com.example.finalCapstone;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class SplashActivity extends AppCompatActivity {

    ImageView logo, splashImg;
    TextView appName;
    LottieAnimationView lottieAnimationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        logo = (ImageView) findViewById(R.id.logo);
        splashImg = (ImageView) findViewById(R.id.bg_image);
        appName = (TextView) findViewById(R.id.app_name);
        lottieAnimationView = findViewById(R.id.lottie);

        splashImg.animate().translationY(-5000).setDuration(1000).setStartDelay(2000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(2000);
        appName.animate().translationY(2000).setDuration(1000).setStartDelay(2000);
        lottieAnimationView.animate().translationY(2000).setDuration(1000).setStartDelay(2000);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //added by soumya for shared preference


                SharedPreferences pref =getSharedPreferences("login",MODE_PRIVATE);
                boolean check=pref.getBoolean("flag",false);
                if(check)
                {
                    //go to main activity
                }
                else
                {
                    //go to login question activity
                }



                //added by soumya for shared preference
                Intent i = new Intent(SplashActivity.this, MainActivity.class);
//                i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
                Bundle b = ActivityOptions.makeSceneTransitionAnimation(SplashActivity.this).toBundle();
                startActivity(i,b);
                finish();
            }
        },3000);
//        Intent i = new Intent(SplashActivity.this, MainActivity.class);
//        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK| Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(i);

    }
}