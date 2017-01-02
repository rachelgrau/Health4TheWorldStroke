package com.rachelgrau.rachel.health4theworldstroke.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by rachel on 12/16/16.
 */

public class ReminderDbHelper extends SQLiteOpenHelper {
    // If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 4;
    public static final String DATABASE_NAME = "FeedReader.db";

    private static final String TEXT_TYPE = " TEXT";
    private static final String COMMA_SEP = ",";
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + ReminderContract.ReminderEntry.TABLE_NAME + " (" +
                    ReminderContract.ReminderEntry._ID + " INTEGER PRIMARY KEY," +
                    ReminderContract.ReminderEntry.COLUMN_NAME_TITLE + TEXT_TYPE + COMMA_SEP +
                    ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_TYPE + TEXT_TYPE + COMMA_SEP +
                    ReminderContract.ReminderEntry.COLUMN_NAME_IS_COMPLETED + TEXT_TYPE + COMMA_SEP +
                    ReminderContract.ReminderEntry.COLUMN_NAME_TIMES + TEXT_TYPE + COMMA_SEP +
                    ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_DAYS + TEXT_TYPE + " )";

    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + ReminderContract.ReminderEntry.TABLE_NAME;

    public ReminderDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // This database is only a cache for online data, so its upgrade policy is
        // to simply to discard the data and start over
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
}
