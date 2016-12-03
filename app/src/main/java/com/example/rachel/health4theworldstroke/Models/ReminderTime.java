package com.example.rachel.health4theworldstroke.Models;

/**
 * Created by rachel on 12/3/16.
 */

public class ReminderTime {
    private int hour;
    private int minute;
    private boolean isSet; // false until the user actually sets a time

    public ReminderTime(int hour, int minute) {
        this.hour = hour;
        this.minute = minute;
        isSet = false;
    }

    public ReminderTime() {
        this.hour = hour;
        this.minute = minute;
        isSet = false;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setHour(int hr) {
        hour = hr;
    }

    public void setMinute(int min) {
        minute = min;
    }

    public String getTimeString() {
        String timeStr = Integer.toString(hour) + ":" + Integer.toString(minute);
        return timeStr;
    }

    public void userSetTime() {
        isSet = true;
    }

    public boolean isSet() {
        return isSet;
    }

}
