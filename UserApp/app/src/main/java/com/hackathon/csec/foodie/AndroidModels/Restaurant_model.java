package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TARUN on 04-Feb-17.
 */

public class Restaurant_model {

    @SerializedName("restaurant")
    ArrayList<Restaurant_item> restaurants;
    @SerializedName("success")
    String success;
    @SerializedName("msg")
    String msg;

    public ArrayList<Restaurant_item> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(ArrayList<Restaurant_item> restaurants) {
        this.restaurants = restaurants;
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

