package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by sahil on 5/2/17.
 */

public class RestaurantDetailResponse {
    @SerializedName("name")
    private String name;
    @SerializedName("id")
    private int id;
    @SerializedName("description")
    private String description;
    @SerializedName("phoneNumber")
    private int phoneNumber;
    @SerializedName("openingHour")
    private  String openingHour;
    @SerializedName("address")
    private String address;
    @SerializedName("budget")
    private int budget;
    @SerializedName("rating")
    private int rating;
    @SerializedName("cuisine")
    private ArrayList<String> cuisineList;
    @SerializedName("picUrl")
    private ArrayList<String> picList;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpeningHour() {
        return openingHour;
    }

    public void setOpeningHour(String openingHour) {
        this.openingHour = openingHour;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBudget() {
        return budget;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public ArrayList<String> getCuisineList() {
        return cuisineList;
    }

    public void setCuisineList(ArrayList<String> cuisineList) {
        this.cuisineList = cuisineList;
    }

    public ArrayList<String> getPicList() {
        return picList;
    }

    public void setPicList(ArrayList<String> picList) {
        this.picList = picList;
    }
}
