package com.example.innovaneers;

public class CallLogModel {
    String Number , ContactName , CallType , CallDate , CallTime ,CallDuration;


    public String getNumber() {
        return Number;
    }

    public String getContactName() {
        return ContactName;
    }

    public String getCallType() {
        return CallType;
    }

    public String getCallDate() {
        return CallDate;
    }


    public String getCallDuration() {
        return CallDuration;
    }

    public void setNumber(String number) {
        Number = number;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public void setCallType(String callType) {
        CallType = callType;
    }

    public void setCallDate(String callDate) {
        CallDate = callDate;
    }


    public void setCallDuration(String callDuration) {
        CallDuration = callDuration;
    }
}
