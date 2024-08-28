package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class AssignModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("ProjectID")
    private String ProjectID = null;
    @SerializedName("StaffID")
    private String StaffID = null;
    @SerializedName("Role")
    private String Role;
    @SerializedName("AssigningDate")
    private String AssigningDate;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public String getRole() {
        return Role;
    }

    public String getAssigningDate() {
        return AssigningDate;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setAssigningDate(String AssigningDate) {
        this.AssigningDate = AssigningDate;
    }
}
