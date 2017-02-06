package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by TARUN on 04-Feb-17.
 */

public class Restaurant_item {

    @SerializedName("name")
    public String name;
    @SerializedName("picUrl")
    public String photo;
    @SerializedName("rating")
    public double rating;
    @SerializedName("distance")
    public int distance;
    @SerializedName("id")
    public int id;
    @SerializedName("budget")
    public int budget;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }
}

