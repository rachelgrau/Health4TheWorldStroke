package com.rachelgrau.rachel.health4theworldstroke;

/**
 * Created by rachel on 12/14/16.
 */

public class Utilities {

    /* Returns a time string of the form "5:32PM" */
    public static String getAmPmTimeString(int hr, int min) {
        boolean isAM = false;
        if (hr < 12) {
            isAM = true;
        } else if (hr > 12){
            hr -= 12;
        }

        String hrStr = String.valueOf(hr);
        String minStr = String.valueOf(min);

        String timeStr = String.valueOf(hr) + ":";

        if (minStr.length() == 1) {
            minStr = "0" + minStr;
        }

        timeStr += minStr;

        if (isAM) {
            timeStr += " AM";
        } else {
            timeStr += " PM";
        }
        return timeStr;
    }

    /* Returns a time string of the form "5:32PM" */
    public static String getMilitaryTimeString(int hr, int min) {
        String hrStr = String.valueOf(hr);
        String minStr = String.valueOf(min);
        String timeStr = String.valueOf(hr) + ":";
        if (minStr.length() == 1) {
            minStr = "0" + minStr;
        }
        timeStr += minStr;
        return timeStr;
    }
}
