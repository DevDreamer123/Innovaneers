package com.example.innovaneers;

import com.google.gson.annotations.SerializedName;

public class RemoveMemberModel {
    @SerializedName("ID")
    private float ID;
    @SerializedName("Status")
    private String Status;
    @SerializedName("Message")
    private String Message;


    // Getter Methods

    public float getID() {
        return ID;
    }

    public String getStatus() {
        return Status;
    }

    public String getMessage() {
        return Message;
    }

    // Setter Methods

    public void setID(float ID) {
        this.ID = ID;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }
}
