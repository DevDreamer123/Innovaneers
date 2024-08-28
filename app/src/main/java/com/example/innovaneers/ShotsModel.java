package com.example.innovaneers;

public class ShotsModel {
    String ID;
    String Text;

    public ShotsModel(String ID,String text) {
        this.ID = ID;

        Text = text;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }
}
