package com.example.event_reminder;

public class eventModal {
    private String eventName;
    private String eventDate;
    private String eventTime;
    private String eventNumber1;
    private String eventNumber2;
    private int id;

    public  String getEventName() {return eventName;}

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventTime() {
        return eventTime;
    }

    public void setEventTime(String eventTime) {
        this.eventTime = eventTime;
    }

    public String getEventNumber1() {
        return eventNumber1;
    }

    public void setEventNumber1(String eventNumber1) {
        this.eventNumber1 = eventNumber1;
    }

    public String getEventNumber2() {
        return eventNumber2;
    }

    public void setEventNumber2(String eventNumber2) {
        this.eventNumber2 = eventNumber2;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // constructor
    public eventModal(String eventName, String eventDate, String eventTime, String eventNumber1 , String eventNumber2) {
        this.eventName = eventName;
        this.eventDate = eventDate;
        this.eventTime = eventTime;
        this.eventNumber1 = eventNumber1;
        this.eventNumber2 = eventNumber2;
    }
}

