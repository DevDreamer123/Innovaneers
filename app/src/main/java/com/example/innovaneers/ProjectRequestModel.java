package com.example.innovaneers;

public class ProjectRequestModel {
    private float ID;
    private String ProjectID;
    private String CustomerID ;
    private String CustomerName ;
    private String ProjectTitle ;
    private String Description ;
    private String Mobile;
    private String Email;
    private String Address;
    private String City;
    private String ProjectCost;
    private String StartingDate;
    private String DeployementDate;



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

    public String getProjectTitle() {
        return ProjectTitle;
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

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getProjectCost() {
        return ProjectCost;
    }

    public String getStartingDate() {
        return StartingDate;
    }

    public String getDeployementDate() {
        return DeployementDate;
    }



    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setProjectID(String projectID) {
        ProjectID = projectID;
    }

    public void setCustomerID(String CustomerID) {
        this.CustomerID = CustomerID;
    }

    public void setCustomerName(String CustomerName) {
        this.CustomerName = CustomerName;
    }

    public void setProjectTitle(String ProjectTitle) {
        this.ProjectTitle = ProjectTitle;
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

    public void setAddress(String address) {
        Address = address;
    }

    public void setCity(String city) {
        City = city;
    }

    public void setProjectCost(String ProjectCost) {
        this.ProjectCost = ProjectCost;
    }

    public void setStartingDate(String StartingDate) {
        this.StartingDate = StartingDate;
    }

    public void setDeployementDate(String DeployementDate) {
        this.DeployementDate = DeployementDate;
    }


}
