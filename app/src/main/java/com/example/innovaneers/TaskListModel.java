package com.example.innovaneers;

public class TaskListModel {
    String ID;
    String Description;
    String Time;
    String Day;
    String Developer;

    public TaskListModel(String ID, String description, String time, String day,String developer) {
        this.ID = ID;
        Description = description;
        Time = time;
        Day = day;
        Developer = developer;
    }

    public String getDeveloper() {
        return Developer;
    }

    public void setDeveloper(String developer) {
        Developer = developer;
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
