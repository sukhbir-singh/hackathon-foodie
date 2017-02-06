package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sahil on 5/2/17.
 */

public class SearchModel {

    @SerializedName("restaurant")
    private ArrayList<Restaurant_item> restaurantItems;
    @SerializedName("meal")
    private ArrayList<Meal> mealItems;

    public ArrayList<Restaurant_item> getRestaurantItems() {
        return restaurantItems;
    }

    public void setRestaurantItems(ArrayList<Restaurant_item> restaurantItems) {
        this.restaurantItems = restaurantItems;
    }

    public ArrayList<Meal> getMealItems() {
        return mealItems;
    }

    public void setMealItems(ArrayList<Meal> mealItems) {
        this.mealItems = mealItems;
    }
}
