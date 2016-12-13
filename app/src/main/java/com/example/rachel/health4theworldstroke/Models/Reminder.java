package com.example.rachel.health4theworldstroke.Models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by rachel on 11/28/16.
 */

public class Reminder implements Serializable {
    private String title;
    private String frequency;
    private ArrayList<ReminderTime> times;
    private boolean isSectionHeader;
    private boolean isCompleted;

    private boolean isToday;

    /* Returns a list of fake reminders */
    public static ArrayList<Reminder> getFakeReminders() {
        ArrayList<Reminder> reminders = new ArrayList<Reminder>();

        Reminder one = new Reminder();
        one.isToday = true;
        one.title = "First, today";

        Reminder two = new Reminder();
        two.isToday = false;
        two.title = "Second, NOT today";

        Reminder three = new Reminder();
        three.isToday = true;
        three.title = "Third, today";

        Reminder four = new Reminder();
        four.isToday = false;
        four.title = "Fourth, NOT today";

        Reminder five = new Reminder();
        five.isToday = false;
        five.title = "Fifth, NOT today";

        reminders.add(one);
        reminders.add(two);
        reminders.add(three);
        reminders.add(four);
        reminders.add(five);

        return reminders;
    }

    /* Given a reminder, returns a string of the format "{frequency} || {times} that can be used as a subtitle.
     * For example:
     * "Daily || 9:00 AM"
     * "Weekly || Mondays 9AM"
     * "Daily || 1:00 PM, 7:00 PM" */
    public static String generateSubtitle(Reminder r) {
        return "";
    }

    public Reminder() {
        this.title = "";
        this.frequency = "";
        this.isToday = false;
        this.isSectionHeader = true;
        this.isCompleted = false;
        this.times = new ArrayList<ReminderTime>();
    }

    public Reminder(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isToday() {
        return this.isToday;
    }

    public void setFrequency(String freq) {
        this.frequency = freq;
    }

    public void addTime(ReminderTime time) {
        this.times.add(time);
    }

    public void setCompleted(boolean completed) {
        this.isCompleted = completed;
    }

    public boolean isCompleted() {
        return this.isCompleted;
    }

    public void setIsSectionHeader(boolean isSectionHeader) {
        this.isSectionHeader = isSectionHeader;
    }

    public boolean isSectionHeader() {
        return this.isSectionHeader;
    }
}
