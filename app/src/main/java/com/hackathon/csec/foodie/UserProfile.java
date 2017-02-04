package com.hackathon.csec.foodie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.hackathon.csec.foodie.AndroidModels.Restaurant_model;
import com.hackathon.csec.foodie.AndroidModels.UserProfile_model;
import com.hackathon.csec.foodie.Utilities.ApiInterFace;
import com.hackathon.csec.foodie.Utilities.Utils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.R.id.list;

public class UserProfile extends AppCompatActivity {

    TextView nameUser, emailUser, phoneUser;

    String picUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        nameUser = (TextView)findViewById(R.id.nameUser);
        phoneUser= (TextView)findViewById(R.id.phoneUser);
        emailUser= (TextView)findViewById(R.id.emailUser);

        retrofit();

    }

    public void retrofit(){

        ApiInterFace apiservice= Utils.getRetrofitService();
        Call<UserProfile_model> call=apiservice.getUserInfo("   fgfjhfvhjfvhjgfvh");

        call.enqueue(new Callback<UserProfile_model>() {
            @Override
            public void onResponse(Call<UserProfile_model> call, Response<UserProfile_model> response) {
               // bar.setVisibility(View.GONE);


                int status=response.code();



            }

            @Override
            public void onFailure(Call<UserProfile_model> call, Throwable t) {
               // bar.setVisibility(View.GONE);
                Toast.makeText(UserProfile.this,"Some error occurred!!",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
