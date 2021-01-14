package com.example.esnafim.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.esnafim.R;
import com.example.esnafim.activities.home_screen;

import pl.droidsonroids.gif.GifImageView;

public class IntroductoryActivity extends AppCompatActivity {
    ImageView bckgrnd,appname;
    GifImageView animationView;
    Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introductory);

        appname = findViewById(R.id.splashesnafim);
        bckgrnd = findViewById(R.id.bground);
        animationView = findViewById(R.id.lottie);

        bckgrnd.animate().translationY(-2400).setDuration(1000).setStartDelay(3000);
        appname.animate().translationY(2400).setDuration(1000).setStartDelay(2700);
        animationView.animate().translationY(2400).setDuration(1000).setStartDelay(2700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(getApplicationContext(), home_screen.class);
                startActivity(intent);
                overridePendingTransition(R.anim.fade,R.anim.fadeout);
                finish();
            }
        },2900);
    }
}