package com.hackathon.csec.foodie.Utilities;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Utils {

    public static boolean checkData(String string) {
        return !string.isEmpty() && string.trim().length() != 0;
    }

    // Created A Static Retrofit Service Method For Getting reference to the retrofit service method

    public static ApiInterFace getRetrofitService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder oBuilder = new OkHttpClient.Builder();
        oBuilder.addNetworkInterceptor(loggingInterceptor);
        oBuilder.connectTimeout(15l, TimeUnit.SECONDS);
        oBuilder.readTimeout(15l, TimeUnit.SECONDS);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nitfoodie.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).
                client(oBuilder.build()).
                build();

        ApiInterFace service = retrofit.create(ApiInterFace.class);
        return service;
    }
}


