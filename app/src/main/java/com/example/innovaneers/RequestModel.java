package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class RequestModel {

    @SerializedName("Mobile")
    private String Mobile;
    @SerializedName("Pass")
    private String Password;


    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
