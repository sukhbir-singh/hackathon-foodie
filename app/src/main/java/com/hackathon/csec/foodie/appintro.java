package com.hackathon.csec.foodie;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.github.paolorotolo.appintro.AppIntro;

public class appintro extends AppIntro {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    addSlide(new Inro1());
        addSlide(new Intro2());
        addSlide(new Inro1());
        addSlide(new intro3());
        setVibrate(true);
        setVibrateIntensity(30);


    }

}
