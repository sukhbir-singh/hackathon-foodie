package com.hackathon.csec.foodie.Utilities;

import com.hackathon.csec.foodie.AndroidModels.Restaurant_model;
import com.hackathon.csec.foodie.AndroidModels.UserProfile_model;


import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface APIINTERFACE {


//    @FormUrlEncoded

    //    Call<Dislike>dislike(@Field("id") String id, @Field("uId") String userId);
//    @POST("newsfeed/like")
//    @GET("quiz/leaderboard")
//    Call<LeaderBoardModel> getLeaderBoard(@Query("from") String from);
    @GET("restaurants")
    Call<Restaurant_model> getRestaurants();

    @GET("/profile/{id}")
    Call<UserProfile_model> getUserInfo(@Path("id") String id);


//    @GET("events/special")
//    Call<BattleDayModel> getSpecialEvents();

}


