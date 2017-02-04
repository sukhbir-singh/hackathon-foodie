package com.hackathon.csec.foodie.Utilities;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jatin on 9/13/2016.
 */
public class Utils {

    public static boolean checkData(String string) {
        return !string.isEmpty() && string.trim().length() != 0;
    }

    // Created A Static Retrofit Service Method For Getting reference to the retrofit service method

    public static APIINTERFACE getRetrofitService() {
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
        OkHttpClient.Builder oBuilder = new OkHttpClient.Builder();
        oBuilder.addNetworkInterceptor(loggingInterceptor);
        oBuilder.connectTimeout(15l, TimeUnit.SECONDS);
        oBuilder.readTimeout(15l, TimeUnit.SECONDS);


        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://nitfoodie.herokuapp.com").addConverterFactory(GsonConverterFactory.create()).
                client(oBuilder.build()).
                build();

        APIINTERFACE service = retrofit.create(APIINTERFACE.class);
        return service;
    }
}


