package com.hackathon.csec.foodie.Adapter;

import com.google.gson.annotations.SerializedName;
import com.hackathon.csec.foodie.AndroidModels.Meal;

import java.util.ArrayList;

/**
 * Created by sahil on 5/2/17.
 */

public class RestaurantMealResponse {
    @SerializedName("meal")
    private ArrayList<Meal> getAllMeal;

    public ArrayList<Meal> getGetAllMeal() {
        return getAllMeal;
    }

    public void setGetAllMeal(ArrayList<Meal> getAllMeal) {
        this.getAllMeal = getAllMeal;
    }
}
