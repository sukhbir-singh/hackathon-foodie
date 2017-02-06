package com.hackathon.csec.foodie;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import java.util.ArrayList;
import java.util.List;

public class LoginActivity extends AppCompatActivity {

    private TextView skip_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final SharedPref sharedPref=new SharedPref(this);

        Log.v("skip status",""+sharedPref.getLoginSkipStatus());
        Log.v("login status",""+sharedPref.getLoginStatus());

        if(sharedPref.getLoginStatus()){
            startActivity(new Intent(LoginActivity.this,MainActivity.class));
            finish();
        }

        Log.v("login-activity","executing");

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.content_login);

        skip_text = (TextView) findViewById(R.id.skip);

        Intent in=getIntent();

        if(in!=null){
            if(!in.getBooleanExtra("skip_visible",true)){
                skip_text.setVisibility(View.GONE);
            }
        }

        skip_text.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                sharedPref.setLoginSkipStatus(true);

                Log.v("skip status1",""+sharedPref.getLoginSkipStatus());
                Log.v("login status1",""+sharedPref.getLoginStatus());

                startActivity(new Intent(LoginActivity.this,MainActivity.class));
                finish();
            }
        });
    }

}
