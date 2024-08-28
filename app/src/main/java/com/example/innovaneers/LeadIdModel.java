package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class LeadIdModel {
    @SerializedName("LeadID")
    private String LeadID;

    public LeadIdModel(String leadID) {
        LeadID = leadID;
    }

    public String getLeadID() {
        return LeadID;
    }

    public void setLeadID(String leadID) {
        LeadID = leadID;
    }
}
