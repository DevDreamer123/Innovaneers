package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class ProjectIdModel {
    @SerializedName("ProjectID")
    private String ProjectID;

    public ProjectIdModel(String projectID) {
        ProjectID = projectID;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }
}
