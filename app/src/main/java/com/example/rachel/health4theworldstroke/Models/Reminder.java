package com.example.rachel.health4theworldstroke.Models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import static com.example.rachel.health4theworldstroke.Activities.CreateReminderActivity.CUSTOM_TAB;
import static com.example.rachel.health4theworldstroke.Activities.CreateReminderActivity.DAILY_TAB;
import static com.example.rachel.health4theworldstroke.Activities.CreateReminderActivity.WEEKLY_TAB;

/**
 * Created by rachel on 11/28/16.
 */

public class Reminder implements Serializable {
    private String title;
    private String frequencyType;

    //if it's weekly or custom, this holds the days
    private ArrayList<Integer> frequencyDays;

    private ArrayList<ReminderTime> times;
    private boolean isSectionHeader;
    private boolean isCompleted;

    private boolean isToday;

    public static String MON = "Mondays";
    public static String TUES = "Tuesdays";
    public static String WED = "Wednesdays";
    public static String THURS = "Thursdays";
    public static String FRI = "Fridays";
    public static String SAT = "Saturdays";
    public static String SUN = "Sundays";

    public static String getPluralDayStringFromDay(int day) {
        switch (day) {
            case Calendar.SUNDAY:
                return SUN;
            case Calendar.MONDAY:
                return MON;
            case Calendar.TUESDAY:
                return TUES;
            case Calendar.WEDNESDAY:
                return WED;
            case Calendar.THURSDAY:
                return THURS;
            case Calendar.FRIDAY:
                return FRI;
            case Calendar.SATURDAY:
                return SAT;
            default:
                return "";
        }
    }

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
        String str = r.frequencyType;
        str += " || ";

        /* Add frequency type and days if necessary */
        if (r.frequencyType.equals(DAILY_TAB)) {
            /* Add a list of times */
        } else if (r.frequencyType.equals(WEEKLY_TAB)) {
            String freqDay = Reminder.getPluralDayStringFromDay(r.frequencyDays.get(0));
            str += (freqDay + " ");
        } else if (r.frequencyType.equals(CUSTOM_TAB)) {
            for (int i=0; i < r.frequencyDays.size(); i++) {
                String freqDay = Reminder.getPluralDayStringFromDay(r.frequencyDays.get(i));
                if (i < r.frequencyDays.size() - 1) {
                    str += (freqDay + ", ");
                } else {
                    str += (freqDay + " ");
                }
            }
        }

        /* Add times */
        for (int i=0; i < r.times.size(); i++) {
            ReminderTime cur = r.times.get(i);
            if (i < r.times.size() - 1) {
                str += (cur.getTimeString() + ", ");
            } else {
                str += cur.getTimeString();
            }

        }

        return str;
    }

    public Reminder() {
        this.title = "";
        this.frequencyType = "";
        this.isToday = false;
        this.isSectionHeader = false;
        this.isCompleted = false;
        this.times = new ArrayList<ReminderTime>();
        this.frequencyDays = new ArrayList<Integer>();
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

    public void setFrequencyType(String freq) {
        this.frequencyType = freq;
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

    public ArrayList<ReminderTime> getTimes() {
        return times;
    }

    public boolean isSectionHeader() {
        return this.isSectionHeader;
    }

    /* Adds a day to include this reminder on. */
    public void addDayToFrequency(int day) {
        this.frequencyDays.add(day);
        /* Update isToday field */
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK);
        if (today == day) this.isToday = true;
    }

    public String getFrequencyType() {
        return frequencyType;
    }

    public ArrayList<Integer> getFrequencyDays() {
        return frequencyDays;
    }
}
