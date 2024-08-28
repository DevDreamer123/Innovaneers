package com.example.innovaneers;

public class StatusModel {
    private String Status;
    private String Description;
    private String Date;

    public StatusModel(String status, String description, String date) {
        Status = status;
        Description = description;
        Date = date;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }
}
