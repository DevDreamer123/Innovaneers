package com.example.innovaneers.account;

import com.google.gson.annotations.SerializedName;

public class NewLeadModel {

    private float ID;

    private String LeadID;

    private String Mobile;

    private String Email;

    private String Address;

    private String City;
    private String LeadType;

    private String Description;

    private String Source;

    private String Date;

    private String ManagerID;

    private String Name;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getLeadID() {
        return LeadID;
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

    public String getLeadType() {
        return LeadType;
    }

    public String getDescription() {
        return Description;
    }

    public String getSource() {
        return Source;
    }

    public String getDate() {
        return Date;
    }

    public String getManagerID() {
        return ManagerID;
    }

    public String getName() {
        return Name;
    }

// Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setLeadID(String LeadID) {
        this.LeadID = LeadID;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setLeadType(String leadType) {
        LeadType = leadType;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public void setSource(String Source) {
        this.Source = Source;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }

    public void setManagerID(String ManagerID) {
        this.ManagerID = ManagerID;
    }

    public void setName(String name) {
        Name = name;
    }
}
