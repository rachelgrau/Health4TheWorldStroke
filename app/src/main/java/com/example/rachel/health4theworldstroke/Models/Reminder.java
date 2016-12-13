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

    public Reminder() {
        this.title = "";
        this.frequency = "";
        this.isToday = false;
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
}
