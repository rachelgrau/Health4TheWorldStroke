package com.example.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/28/16.
 */

public class Reminder {
    private boolean isToday;
    private String title;

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
        this.isToday = false;
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
}
