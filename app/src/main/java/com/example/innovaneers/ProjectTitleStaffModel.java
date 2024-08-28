package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class ProjectTitleStaffModel {
    @SerializedName("ProjectID")
    private String ProjectID ;
    @SerializedName("StaffID")
    private String StaffID ;

    @SerializedName("TaskTitle")
    private String TaskTitle ;

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

    public String getTaskTitle() {
        return TaskTitle;
    }

    public void setTaskTitle(String taskTitle) {
        TaskTitle = taskTitle;
    }
}
