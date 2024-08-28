package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class LoginModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("StaffID")
    private String StaffID;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Mobile")
    private String Mobile;
    @SerializedName("Email")
    private String Email ;
    @SerializedName("Designation")
    private String Designation;
    @SerializedName("Address")
    private String Address;
    @SerializedName("City")
    private String City;
    @SerializedName("State")
    private String State;
    @SerializedName("JoiningDate")
    private String JoiningDate;
    @SerializedName("ResignationDate")
    private String ResignationDate ;
    @SerializedName("Pass")
    private String Password;
    @SerializedName("UserType")
    private String UserType ;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getStaffID() {
        return StaffID;
    }

    public String getName() {
        return Name;
    }

    public String getMobile() {
        return Mobile;
    }

    public String getEmail() {
        return Email;
    }

    public String getDesignation() {
        return Designation;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public String getJoiningDate() {
        return JoiningDate;
    }

    public String getResignationDate() {
        return ResignationDate;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserType() {
        return UserType;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setStaffID(String StaffID) {
        this.StaffID = StaffID;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public void setMobile(String Mobile) {
        this.Mobile = Mobile;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setDesignation(String Designation) {
        this.Designation = Designation;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }

    public void setCity(String City) {
        this.City = City;
    }

    public void setState(String State) {
        this.State = State;
    }

    public void setJoiningDate(String JoiningDate) {
        this.JoiningDate = JoiningDate;
    }

    public void setResignationDate(String ResignationDate) {
        this.ResignationDate = ResignationDate;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setUserType(String UserType) {
        this.UserType = UserType;
    }
}
