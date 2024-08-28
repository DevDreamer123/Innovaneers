package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class ProjectIdStaffIDModel {
    @SerializedName("ProjectID")
    private String ProjectID = null;
    @SerializedName("StaffID")
    private String StaffID = null;

    public ProjectIdStaffIDModel(String projectID, String staffID) {
        ProjectID = projectID;
        StaffID = staffID;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public void setStaffID(String staffID) {
        StaffID = staffID;
    }
}
