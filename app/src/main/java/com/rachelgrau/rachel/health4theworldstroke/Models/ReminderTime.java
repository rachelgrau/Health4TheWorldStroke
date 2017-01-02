package com.rachelgrau.rachel.health4theworldstroke.Models;

import java.io.Serializable;

/**
 * Created by rachel on 12/3/16.
 */

public class ReminderTime implements Serializable {
    private String timeStr;
    private boolean isSet; // false until the user actually sets a time

    public ReminderTime(String timeStr) {
        this.timeStr = timeStr;
        isSet = false;
    }

    public ReminderTime() {
        this.timeStr = "00:00";
        isSet = false;
    }

    public String getTimeString() {
        return timeStr;
    }

    public void setTimeStr(String str) {
        this.timeStr = str;
    }

    public void userSetTime() {
        isSet = true;
    }

    public boolean isSet() {
        return isSet;
    }

}
