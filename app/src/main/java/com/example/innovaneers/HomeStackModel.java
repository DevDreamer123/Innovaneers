package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class HomeStackModel {
    @SerializedName("NewLeads")
    private String NewLeads;
    @SerializedName("OngoingLeads")
    private String OngoingLeads;
    @SerializedName("Team")
    private String Team;
    @SerializedName("NewProjects")
    private String NewProjects;
    @SerializedName("ActiveProjects")
    private String ActiveProjects;
    @SerializedName("PendingProjects")
    private String PendingProjects;
    @SerializedName("CompletedProjects")
    private String CompletedProjects;


    public HomeStackModel(String NewLeads , String OngoingLeads , String Team , String NewProjects
                         , String ActiveProjects , String PendingProjects , String CompletedProjects){
        this.NewLeads = NewLeads;
        this.OngoingLeads = OngoingLeads;
        this.Team = Team;
        this.NewProjects = NewProjects;
        this.ActiveProjects = ActiveProjects;
        this.PendingProjects = PendingProjects;
        this.CompletedProjects = CompletedProjects;

    }


    // Getter Methods

    public String getNewLeads() {
        return NewLeads;
    }

    public String getOngoingLeads() {
        return OngoingLeads;
    }

    public String getTeam() {
        return Team;
    }

    public String getNewProjects() {
        return NewProjects;
    }

    public String getActiveProjects() {
        return ActiveProjects;
    }

    public String getPendingProjects() {
        return PendingProjects;
    }

    public String getCompletedProjects() {
        return CompletedProjects;
    }

    // Setter Methods

    public void setNewLeads(String NewLeads) {
        this.NewLeads = NewLeads;
    }

    public void setOngoingLeads(String OngoingLeads) {
        this.OngoingLeads = OngoingLeads;
    }

    public void setTeam(String Team) {
        this.Team = Team;
    }

    public void setNewProjects(String NewProjects) {
        this.NewProjects = NewProjects;
    }

    public void setActiveProjects(String ActiveProjects) {
        this.ActiveProjects = ActiveProjects;
    }

    public void setPendingProjects(String PendingProjects) {
        this.PendingProjects = PendingProjects;
    }

    public void setCompletedProjects(String CompletedProjects) {
        this.CompletedProjects = CompletedProjects;
    }
}
