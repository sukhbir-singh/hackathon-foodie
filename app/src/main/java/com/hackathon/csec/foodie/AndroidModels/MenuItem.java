package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

/**
 * Created by root on 5/2/17.
 */

public class MenuItem {
    // id, restaurantkey, name, description, logoUrl, rating, price, cuisine, veg

    @SerializedName("id")
    private String id;
    @SerializedName("restaurantkey")
    private int restaurantkey;
    @SerializedName("name")
    private String name;
    @SerializedName("description")
    private String description;
    @SerializedName("logoUrl")
    private String logoUrl;
    @SerializedName("rating")
    private double rating;
    @SerializedName("price")
    private int price;
    @SerializedName("cuisine")
    private String cuisine;
    @SerializedName("veg")
    private boolean veg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getRestaurantkey() {
        return restaurantkey;
    }

    public void setRestaurantkey(int restaurantkey) {
        this.restaurantkey = restaurantkey;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isVeg() {
        return veg;
    }

    public void setVeg(boolean veg) {
        this.veg = veg;
    }
}
