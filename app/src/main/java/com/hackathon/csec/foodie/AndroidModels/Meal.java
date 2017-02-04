package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by sahil on 5/2/17.
 */

public class Meal {
    @SerializedName("id")
    private int id;
    @SerializedName("name")
    private String name;
    @SerializedName("picUrl")
    private String picUrl;
    @SerializedName("price")
    private int price;
    @SerializedName("veg")
    private int veg;
    @SerializedName("rating")
    private int rating;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getVeg() {
        return veg;
    }

    public void setVeg(int veg) {
        this.veg = veg;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }
}
