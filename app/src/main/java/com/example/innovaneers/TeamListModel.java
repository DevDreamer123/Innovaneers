package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class TeamListModel {
    @SerializedName("ProjectID")
    private String ProjectID = null;
    @SerializedName("StaffID")
    private String StaffID;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Role")
    private String Role;
    @SerializedName("AssigningDate")
    private String AssigningDate;
    @SerializedName("isAssigned")
    private String isAssigned;

    public TeamListModel(String projectID, String staffID, String name, String role, String assigningDate, String isAssigned) {
        ProjectID = projectID;
        StaffID = staffID;
        Name = name;
        Role = role;
        AssigningDate = assigningDate;
        this.isAssigned = isAssigned;
    }
    // Getter Methods

    public String getProjectID() {
        return ProjectID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public String getName() {
        return Name;
    }

    public String getRole() {
        return Role;
    }

    public String getAssigningDate() {
        return AssigningDate;
    }

    public String getIsAssigned() {
        return isAssigned;
    }

    // Setter Methods

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public void setAssigningDate(String AssigningDate) {
        this.AssigningDate = AssigningDate;
    }

    public void setIsAssigned(String isAssigned) {
        this.isAssigned = isAssigned;
    }
}
