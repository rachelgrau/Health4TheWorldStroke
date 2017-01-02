package com.rachelgrau.rachel.health4theworldstroke.Database;

import android.provider.BaseColumns;

/**
 * Created by rachel on 12/16/16.
 */

public class ReminderContract {
    // To prevent someone from accidentally instantiating the contract class,
    // make the constructor private.
    private ReminderContract() {}

    /* Inner class that defines the table contents */
    public static class ReminderEntry implements BaseColumns {
        public static final String TABLE_NAME = "reminder";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_FREQUENCY_TYPE = "frequencyType";
        public static final String COLUMN_NAME_FREQUENCY_DAYS = "frequencyDays";
        public static final String COLUMN_NAME_IS_COMPLETED = "isCompleted";
        public static final String COLUMN_NAME_TIMES = "times";
    }

}
