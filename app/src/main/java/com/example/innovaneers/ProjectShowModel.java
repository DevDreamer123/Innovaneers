package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class ProjectShowModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("ProjectID")
    private String ProjectID;
    @SerializedName("CustomerID")
    private String CustomerID;
    @SerializedName("CustomerName")
    private String CustomerName;
    @SerializedName("Title")
    private String Title;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Mobile")
    private String Mobile;
    @SerializedName("Email")
    private String Email = null;
    @SerializedName("Cost")
    private String Cost;
    @SerializedName("StartDate")
    private String StartDate;

    @SerializedName("DeploymentDate")
    private String DeploymentDate = null;
    @SerializedName("ProjectType")
    private String ProjectType;
    public ProjectShowModel(float ID,String ProjectID,String CustomerID,String CustomerName,String Title,String Description
                             ,String Mobile,String Email ,String Cost , String StartDate ,String DeploymentDate,String ProjectType ){
        this.ID = ID;
        this.ProjectID = ProjectID;
        this.CustomerID = CustomerID;
        this.CustomerName = CustomerName;
        this.Title = Title;
        this.Description = Description;
        this.Mobile = Mobile;
        this.Email = Email;
        this.Cost = Cost;
        this.StartDate = StartDate;
        this.DeploymentDate = DeploymentDate;
        this.ProjectType = ProjectType;
    }


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getProjectID() {
        return ProjectID;
    }

    public String getCustomerID() {
        return CustomerID;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public String getTitle() {
        return Title;
    }

    public String getDescription() {
        return Description;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public String getCost() {
        return Cost;
    }

    public String getStartDate() {
        return StartDate;
    }

    public String getDeploymentDate() {
        return DeploymentDate;
    }

    public String getProjectType() {
        return ProjectType;
    }

// Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setProjectID(String ProjectID) {
        this.ProjectID = ProjectID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setTitle(String Title) {
        this.Title = Title;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setCost(String Cost) {
        this.Cost = Cost;
    }

    public void setStartDate(String StartDate) {
        this.StartDate = StartDate;
    }

    public void setDeploymentDate(String DeploymentDate) {
        this.DeploymentDate = DeploymentDate;
    }

    public void setProjectType(String projectType) {
        ProjectType = projectType;
    }
}
