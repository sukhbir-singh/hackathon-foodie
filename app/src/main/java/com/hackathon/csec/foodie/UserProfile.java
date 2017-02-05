package com.hackathon.csec.foodie;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hackathon.csec.foodie.AndroidModels.Restaurant_model;
import com.hackathon.csec.foodie.AndroidModels.UserProfile_model;
import com.hackathon.csec.foodie.Utilities.APIINTERFACE;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class UserProfile extends AppCompatActivity {

    TextView nameUser, emailUser, phoneUser;
    ProgressBar bar;
    String picUrl;
    ImageView imageUser;
    RelativeLayout r1;

    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        nameUser = (TextView)findViewById(R.id.nameUser);
        phoneUser= (TextView)findViewById(R.id.phoneUser);
        emailUser= (TextView)findViewById(R.id.emailUser);
        bar      = (ProgressBar)findViewById(R.id.progress1);
        r1       = (RelativeLayout)findViewById(R.id.layout1);
        imageUser= (ImageView)findViewById(R.id.imageUser);

        SharedPref s1 = new SharedPref(UserProfile.this);
        id = s1.getUserKey();

        retrofit();

    }

    public void retrofit(){

        APIINTERFACE apiservice= Utils.getRetrofitService();
        Call<UserProfile_model> call=apiservice.getUserInfo(id);

        call.enqueue(new Callback<UserProfile_model>() {
            @Override
            public void onResponse(Call<UserProfile_model> call, Response<UserProfile_model> response) {
                bar.setVisibility(View.GONE);

                UserProfile_model model=response.body();
                int status=response.code();

                bar.setVisibility(View.GONE);
                r1.setVisibility(View.VISIBLE);
                picUrl=model.getPicUrl();

                if(model.getNameUser()!=null)
                {
                    nameUser.setText(model.getNameUser());
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
                    Glide.with(UserProfile.this).load(picUrl).asBitmap().
                            diskCacheStrategy(DiskCacheStrategy.ALL).into(imageUser);
                }



            }

            @Override
            public void onFailure(Call<UserProfile_model> call, Throwable t) {
                bar.setVisibility(View.GONE);
                Toast.makeText(UserProfile.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
