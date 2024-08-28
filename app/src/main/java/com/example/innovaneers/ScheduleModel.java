package com.example.innovaneers;

public class ScheduleModel {
    String ID;
    String Description;
    String Time;
    String Day;


    public ScheduleModel(String ID, String description, String time, String day) {
        this.ID = ID;
        Description = description;
        Time = time;
        Day = day;
    }



    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDay() {
        return Day;
    }

    public void setDay(String day) {
        Day = day;
    }
}
