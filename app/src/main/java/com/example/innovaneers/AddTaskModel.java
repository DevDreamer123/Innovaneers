package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class AddTaskModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("ProjectID")
    private String ProjectID;
    @SerializedName("Task1")
    private String Task1;
    @SerializedName("Assignee")
    private String Assignee;
    @SerializedName("AssignDate")
    private String AssignDate;
    @SerializedName("Deadline")
    private String Deadline;
    @SerializedName("CompletionDate")
    private String CompletionDate;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public String getTask1() {
        return Task1;
    }

    public String getAssignee() {
        return Assignee;
    }

    public String getAssignDate() {
        return AssignDate;
    }

    public String getDeadline() {
        return Deadline;
    }

    public String getCompletionDate() {
        return CompletionDate;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setTask1(String Task1) {
        this.Task1 = Task1;
    }

    public void setAssignee(String Assignee) {
        this.Assignee = Assignee;
    }

    public void setAssignDate(String AssignDate) {
        this.AssignDate = AssignDate;
    }

    public void setDeadline(String Deadline) {
        this.Deadline = Deadline;
    }

    public void setCompletionDate(String CompletionDate) {
        this.CompletionDate = CompletionDate;
    }
}
