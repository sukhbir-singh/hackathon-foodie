package com.hackathon.csec.foodie.Utilities;

import com.hackathon.csec.foodie.Adapter.RestaurantMealResponse;
import com.hackathon.csec.foodie.AndroidModels.RestaurantDetailResponse;
import com.hackathon.csec.foodie.AndroidModels.Restaurant_model;
import com.hackathon.csec.foodie.AndroidModels.SearchModel;
import com.hackathon.csec.foodie.AndroidModels.UserProfile_model;
import com.hackathon.csec.foodie.LoginFragment;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface ApiInterFace {


    @GET("restaurants")
    Call<Restaurant_model> getRestaurants();

    @POST("/profile")
    @FormUrlEncoded
    Call<LoginFragment.UserSentResponse> sendUserData(@Field("name") String name, @Field("picUrl") String picUrl, @Field("email") String email);


    @GET("/search/{keyword}")
    Call<SearchModel> search(@Path("keyword") String keyword);

    @GET("/profile/{id}")
    Call<UserProfile_model> getUserInfo(@Path("id") String id);

    @GET("/meal/{id}")
    Call<RestaurantMealResponse> getRestaurantMeal(@Path("id") int id);

    @GET("/restaurant/{id}")
    Call<RestaurantDetailResponse> getRestaurantDetailResponse(@Path("id") int id);
}


