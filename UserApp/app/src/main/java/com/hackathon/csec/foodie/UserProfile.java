package com.hackathon.csec.foodie;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.facebook.login.LoginManager;
import com.hackathon.csec.foodie.AndroidModels.Restaurant_model;
import com.hackathon.csec.foodie.AndroidModels.UserProfile_model;
import com.hackathon.csec.foodie.Utilities.ApiInterFace;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class UserProfile extends AppCompatActivity {

    private TextView nameUser, emailUser;
    private ProgressBar bar;
    private String picUrl;
    private ImageView imageUser;
    private LinearLayout r1;
    private Button logout;
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        final SharedPref sharedPref=new SharedPref(this);

        Log.v("skip status2",""+sharedPref.getLoginSkipStatus());
        Log.v("login status2",""+sharedPref.getLoginStatus());

        if(!sharedPref.getLoginStatus() || sharedPref.getLoginSkipStatus()){
            Intent i=new Intent(UserProfile.this, LoginActivity.class);
            i.putExtra("skip_visible",false);
            startActivity(i);
            finish();
        }

        setContentView(R.layout.activity_user_profile);

        nameUser = (TextView)findViewById(R.id.nameUser);

        emailUser= (TextView)findViewById(R.id.emailUser);
        bar      = (ProgressBar)findViewById(R.id.progress1);
        r1       = (LinearLayout)findViewById(R.id.layout1);
        imageUser= (ImageView)findViewById(R.id.imageUser);

        SharedPref s1 = new SharedPref(UserProfile.this);
        id = s1.getUserKey();

//        Toast.makeText(this,id+"",Toast.LENGTH_LONG).show();

        logout = (Button)findViewById(R.id.logoutbutton);

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LoginManager.getInstance().logOut();
                SharedPref s= new SharedPref(UserProfile.this);
                s.setLoginStatus(false);
                s.setLoginSkipStatus(false);
                s.setUserKey(null);
                Intent i = new Intent(UserProfile.this, LoginActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(i);
            }
        });

        retrofit();

    }

    public void retrofit(){

        ApiInterFace apiservice= Utils.getRetrofitService();
        Call<UserProfile_model> call=apiservice.getUserInfo(id);


        call.enqueue(new Callback<UserProfile_model>() {
            @Override
            public void onResponse(Call<UserProfile_model> call, Response<UserProfile_model> response) {
                bar.setVisibility(View.GONE);

                UserProfile_model model=response.body();
                int status=response.code();

                bar.setVisibility(View.GONE);
                r1.setVisibility(View.VISIBLE);

                if(model==null){
                    finish();

                    LoginManager.getInstance().logOut();
                    SharedPref s= new SharedPref(UserProfile.this);
                    s.setLoginStatus(false);
                    s.setLoginSkipStatus(false);
                    s.setUserKey(null);

                    return;
                }

                picUrl=model.getPicUrl();

                if(model.getNameUser()!=null)
                {
                    nameUser.setText(model.getNameUser());
                    logout.setVisibility(View.VISIBLE);
                }else
                {
                    nameUser.setText("No name Found!!");
                }

                if(model.getEmailuser()!=null) {
                    emailUser.setText(model.getEmailuser());
                }else{
                    emailUser.setText("No email found!!");
                }

                if(picUrl!=null) {
                    //temp
                    Glide.with(UserProfile.this).load(picUrl).asBitmap().diskCacheStrategy(DiskCacheStrategy.ALL).into(imageUser);
                }

               // bar.setVisibility(View.GONE);

            }

            @Override
            public void onFailure(Call<UserProfile_model> call, Throwable t) {

                //bar.setVisibility(View.GONE);
                Toast.makeText(UserProfile.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
