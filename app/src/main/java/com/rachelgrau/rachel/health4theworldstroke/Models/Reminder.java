package com.rachelgrau.rachel.health4theworldstroke.Models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import com.rachelgrau.rachel.health4theworldstroke.Database.ReminderContract;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.CreateReminderActivity.CUSTOM_TAB;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.CreateReminderActivity.DAILY_TAB;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.CreateReminderActivity.WEEKLY_TAB;

/**
 * Created by rachel on 11/28/16.
 */

public class Reminder implements Serializable {
    private String title;
    private String frequencyType;
    private long dbId; // if reminder already exists in the DB, otherwise -1

    // If it's weekly or custom, this holds the days in format of bit string, starting with Sunday, where 0 = day not included. Ex: MWF = "0101010"
    private String frequencyDays;

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
            case 0:
                return SUN;
            case 1:
                return MON;
            case 2:
                return TUES;
            case 3:
                return WED;
            case 4:
                return THURS;
            case 5:
                return FRI;
            case 6:
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
            int freqDay = r.frequencyDays.indexOf('1');
            String freqDayStr = Reminder.getPluralDayStringFromDay(freqDay);
            str += (freqDayStr + " ");
        } else if (r.frequencyType.equals(CUSTOM_TAB)) {
            for (int i=0; i < r.frequencyDays.length(); i++) {
                /* Generate string of format "Mondays, Wednesdays, Fridays" from the bit string.  */
                if (r.frequencyDays.charAt(i) == '1') {
                    /* Means we need to add this day. Now figure out if it's the LAST day we'll add so we know not to put a trailing comma. */
                    String freqDay = Reminder.getPluralDayStringFromDay(i);
                    if (i == (r.frequencyDays.length() - 1)) {
                        /* If it's Saturday, then it's definitely the last day. */
                        str += (freqDay + " ");
                    } else {
                        /* If it's not Saturday, let's see if there are any more 1's in the bit string. */
                        String rest = r.frequencyDays.substring(i + 1);
                        if (rest.contains("1")) {
                            /* Not the last day! */
                            str += (freqDay + ", ");
                        } else {
                            str += (freqDay + " ");
                        }
                    }
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
        this.dbId = -1;
        this.frequencyType = "";
        this.isToday = false;
        this.isSectionHeader = false;
        this.isCompleted = false;
        this.times = new ArrayList<ReminderTime>();
        this.frequencyDays = "1111111";
    }

    public void setTimes(ArrayList<ReminderTime> reminderTimes) {
        this.times = reminderTimes;
    }

    public void setDbId(long theID) {
        this.dbId = theID;
    }

    public long getDbId() {
        return dbId;
    }

    public void setFrequencyDays(String daysBitString) {
        frequencyDays = daysBitString;

        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Calendar has Sunday = 1, we have it as 0

        if (frequencyDays.substring(today, today + 1).equals("1")) {
            isToday = true;
        } else {
            isToday = false;
        }
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

    /* Adds a day to include this reminder on. 0 = Sunday, 1 = Monday, etc. */
    public void addDayToFrequency(int day) {
        /* Update the bit string */
        String building = "";
        String firstPart = frequencyDays.substring(0, day);
        building = firstPart + "1";
        if (day < 6) {
            building += frequencyDays.substring(day + 1);
        }
        frequencyDays = building;

        /* Update isToday field */
        Calendar calendar = Calendar.getInstance();
        int today = calendar.get(Calendar.DAY_OF_WEEK) - 1; // Calendar has Sunday = 1, we have it as 0
        if (today == day) this.isToday = true;
    }

    public String getFrequencyType() {
        return frequencyType;
    }

    public String getFrequencyDays() {
        return frequencyDays;
    }

    public void clearFrequencyDays() {
        frequencyDays = "0000000";
    }


    /* Returns a bit String form of the days that this reminder should occur. A "0" means the day is not included, a "1" means the day is included.
     * Starting with Sunday.
     * Ex: if the reminder occurs on Mondyas, Wednesdays, and Fridays, this method returns "0101010". */
    private String getFrequencyDaysAsString() {
//        String bitString = "0000000";
//        for (Integer i: frequencyDays) {
//
//        }
        return "";
    }

    /* Returns an array of the frequency days (same format of this.frequencyDays) when given a bit string like the one returned from
     * getFrequencyDaysAsString.
     */
    private ArrayList<Integer> getFrequencyDayArrayFromString(String s) {
        ArrayList<Integer> frequencyDaysArray = new ArrayList<Integer>();
        for (int i=0; i < s.length(); i++) {
            if (s.substring(i, i+1).equals("1")) {
                frequencyDaysArray.add(i);
            }
        }
        return frequencyDaysArray;
    }

    /* Given a string of times separated by commas, creates an array of ReminderTimes and stores it in the private
     * ivar |times| */
    public void convertTimeStringToTimes(String str) {
        int indexOfComma = str.indexOf(',');
        while (indexOfComma > 0) {
            ReminderTime rt = new ReminderTime();
            rt.setTimeStr(str.substring(0, indexOfComma));
            addTime(rt);
            str = str.substring(indexOfComma + 1);
            indexOfComma = str.indexOf(',');
        }
        if (str.length() > 0) {
            ReminderTime rt = new ReminderTime();
            rt.setTimeStr(str);
            addTime(rt);
        }
    }

    /* Converts the array of times into a string of times separated by commas, like "20:30, 5:23, 11:01" */
    private String getTimeStringFromTimes() {
        String timeStr = "";
        for (int i=0; i < times.size(); i++) {
            ReminderTime rt = times.get(i);
            timeStr += (rt.getTimeString());
            if (i < (times.size() - 1)) {
                timeStr += ",";
            }
        }
        return timeStr;
    }

    /* Creates this reminder in the database. */
    public void createInDatabase(SQLiteDatabase db) {
        ContentValues values = new ContentValues();
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_TITLE, title);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_TYPE, frequencyType);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_DAYS, frequencyDays);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_IS_COMPLETED, isCompleted);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_TIMES, getTimeStringFromTimes());
        this.dbId = db.insert(ReminderContract.ReminderEntry.TABLE_NAME, null, values);
    }

    /* Updates this reminder in the database */
    public void updateInDatabase(SQLiteDatabase db) {
        // New value for one column
        ContentValues values = new ContentValues();
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_TITLE, title);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_TYPE, frequencyType);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_DAYS, frequencyDays);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_IS_COMPLETED, isCompleted);
        values.put(ReminderContract.ReminderEntry.COLUMN_NAME_TIMES, getTimeStringFromTimes());
        // Which row to update, based on the ID
        String selection = ReminderContract.ReminderEntry._ID + "=" + this.dbId;
        int count = db.update(
                ReminderContract.ReminderEntry.TABLE_NAME,
                values,
                selection,
                null);
    }

    /* Deletes this reminder in the database */
    public void deleteInDatabase(SQLiteDatabase db) {
        // Define 'where' part of query.
        String selection = ReminderContract.ReminderEntry._ID + "=" + this.dbId;
        // Specify arguments in placeholder order.
        db.delete(ReminderContract.ReminderEntry.TABLE_NAME, selection, null);
    }
}
