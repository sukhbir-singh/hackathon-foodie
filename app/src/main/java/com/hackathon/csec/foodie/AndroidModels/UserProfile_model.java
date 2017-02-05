package com.hackathon.csec.foodie.AndroidModels;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by TARUN on 04-Feb-17.
 */

public class UserProfile_model {

    @SerializedName("name")
    String nameUser;
    @SerializedName("email")
    String emailuser;
    @SerializedName("picUrl")
    String picUrl;
    @SerializedName("success")
    String success;
    @SerializedName("msg")
    String msg;

    public String getNameUser() {
        return nameUser;
    }

    public void setNameUser(String nameUser) {
        this.nameUser = nameUser;
    }

    public String getEmailuser() {
        return emailuser;
    }

    public void setEmailuser(String emailuser) {
        this.emailuser = emailuser;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
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
