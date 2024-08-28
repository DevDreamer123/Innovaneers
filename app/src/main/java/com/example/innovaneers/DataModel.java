package com.example.innovaneers;

public class DataModel {
    private int id;
    private String spinnerValue;
    private String dateValue;
    private String description;

    public DataModel(int id, String spinnerValue, String dateValue, String description) {
        this.id = id;
        this.spinnerValue = spinnerValue;
        this.dateValue = dateValue;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getSpinnerValue() {
        return spinnerValue;
    }

    public String getDateValue() {
        return dateValue;
    }

    public String getDescription() {
        return description;
    }
}
