package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class Lead_detail_Model {
    @SerializedName("ID")
    private float ID;
    @SerializedName("LeadID")
    private String LeadID;
    @SerializedName("Mobile")
    private String Mobile;
    @SerializedName("Email")
    private String Email;
    @SerializedName("Address")
    private String Address;
    @SerializedName("City")
    private String City;
    @SerializedName("Description")
    private String Description;
    @SerializedName("Source")
    private String Source;
    @SerializedName("Date")
    private String Date;
    @SerializedName("ManagerID")
    private String ManagerID;


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
}
