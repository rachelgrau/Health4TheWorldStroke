package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.RemindersAdapter;
import com.rachelgrau.rachel.health4theworldstroke.Database.ReminderContract;
import com.rachelgrau.rachel.health4theworldstroke.Database.ReminderDbHelper;
import com.rachelgrau.rachel.health4theworldstroke.Models.Reminder;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class RemindersActivity extends AppCompatActivity implements View.OnClickListener {
    public static final int CREATE_REMINDER = 0;
    public static final String EXTRA_IS_EDITING = "isEditing";
    public static final String EXTRA_REMINDER = "reminder";
    public static final String EXTRA_CREATED_REMINDER = "created_reminder";
    public static final String EXTRA_DELETED_REMINDER = "deleted_reminder";


    private static final int TODAYS_REMINDER_SECTION = 0;
    private static final int ALL_REMINDER_SECTION = 1;

    private ArrayList<Reminder> allReminders;
    private RemindersAdapter adapter;
    private ListView listView;

    ReminderDbHelper rDbHelper;

    /* If the user selects a reminder to be edited, save that reminder here while they edit */
    private Reminder reminderBeingEdited;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        allReminders = new ArrayList<Reminder>();
        loadRemindersFromDb();

        setContentView(R.layout.activity_reminders);
        setUpToolbar();
        setUpListView();
        generateRemindersForListView();

        /* Set up listener for new reminder button */
        ImageButton addReminderButton = (ImageButton)findViewById(R.id.add_reminder_button);
        addReminderButton.setOnClickListener(this);
    }

    /* Loads all stored reminders from the database and creates a Reminder object for each one. Puts those
     * reminder objects in allReminders ArrayList. */
    private void loadRemindersFromDb() {
        rDbHelper = new ReminderDbHelper(getApplicationContext());
                /* Read from DB */
        SQLiteDatabase db = rDbHelper.getReadableDatabase();
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        String[] projection = {
                ReminderContract.ReminderEntry._ID,
                ReminderContract.ReminderEntry.COLUMN_NAME_TITLE,
                ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_TYPE,
                ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_DAYS,
                ReminderContract.ReminderEntry.COLUMN_NAME_IS_COMPLETED,
                ReminderContract.ReminderEntry.COLUMN_NAME_TIMES,
        };

//        // Filter results WHERE "title" = 'My Title'
//        String selection = FeedEntry.COLUMN_NAME_TITLE + " = ?";
//        String[] selectionArgs = { "My Title" };
//
//        // How you want the results sorted in the resulting Cursor
//        String sortOrder =
//                ReminderContract.COLUMN_NAME_SUBTITLE + " DESC";

        Cursor c = db.query(
                ReminderContract.ReminderEntry.TABLE_NAME,// The table to query
                projection,                               // The columns to return
                null,                                // The columns for the WHERE clause
                null,                            // The values for the WHERE clause
                null,                                     // don't group the rows
                null,                                     // don't filter by row groups
                null                                 // The sort order
        );

        int count = c.getCount();
        c.moveToFirst();
        for (int i=0; i < count; i++) {
            long itemId = c.getLong(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry._ID));
            String theTitle = c.getString(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry.COLUMN_NAME_TITLE));
            String freqType = c.getString(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_TYPE));
            String freqDays = c.getString(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry.COLUMN_NAME_FREQUENCY_DAYS));
            boolean isCompleted = c.getInt(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry.COLUMN_NAME_IS_COMPLETED)) > 0;
            String timesStr = c.getString(c.getColumnIndexOrThrow(ReminderContract.ReminderEntry.COLUMN_NAME_TIMES));
            Reminder savedReminder = new Reminder();
            savedReminder.setDbId(itemId);
            savedReminder.setTitle(theTitle);
            savedReminder.setFrequencyType(freqType);
            savedReminder.setFrequencyDays(freqDays);
            savedReminder.setCompleted(isCompleted);
            savedReminder.convertTimeStringToTimes(timesStr);
            System.out.println("TIME STR: " + timesStr);
            allReminders.add(savedReminder);

            if (!c.isLast()) {
                c.moveToNext();
            }
        }
    }

    public void onClick(View v) {
        ImageButton addReminderButton = (ImageButton)findViewById(R.id.add_reminder_button);
        if (v.equals(addReminderButton)) {
            /* Add new reminder */
            Intent intent = new Intent(this, CreateReminderActivity.class);
            intent.putExtra(EXTRA_IS_EDITING, false);
            startActivityForResult(intent, CREATE_REMINDER);
        } else {

        }
    }

    /* Call back for when an activity started from this activity finished. */
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == CREATE_REMINDER) {
            if (resultCode == RESULT_OK){
                Reminder newReminder = (Reminder)data.getSerializableExtra(EXTRA_CREATED_REMINDER);
                boolean wasEditing = data.getBooleanExtra(EXTRA_IS_EDITING, false);
                boolean deletedReminder = data.getBooleanExtra(EXTRA_DELETED_REMINDER, false);
                if (deletedReminder) {
                    /* Means they deleted the reminder */
                    Reminder reminderToDelete = (Reminder)data.getSerializableExtra(EXTRA_CREATED_REMINDER);
                    if (reminderBeingEdited != null) {
                        for (int i=0; i < allReminders.size(); i++) {
                            Reminder r = allReminders.get(i);
                            if (r.equals(reminderBeingEdited)) {
                                allReminders.remove(i);
                                break;
                            }
                        }
                    }
                    reminderBeingEdited = null;
                } else if (wasEditing) {
                    /* If they were editing the reminder, then replace it in |allReminders| with the newly edited one */
                    if (reminderBeingEdited != null) {
                        for (int i=0; i < allReminders.size(); i++) {
                            Reminder r = allReminders.get(i);
                            if (r.equals(reminderBeingEdited)) {
                                allReminders.remove(i);
                                allReminders.add(i, newReminder);
                                break;
                            }
                        }
                    }
                    reminderBeingEdited = null;
                } else {
                    /* Just add the newly created reminder */
                    allReminders.add(newReminder);
                }
                /* Update list view! */
                generateRemindersForListView();
            }
        }
    }

    /* Loads a list of all reminders. Then loops through them and adds each on to the adapter's
     * data source in the correct order, adding section headers where needed. */
    private void generateRemindersForListView() {
        adapter.clearDataSource();
        /* Add first section header – today's reminders */
        Reminder sectionHeaderOne = new Reminder(getResources().getString(R.string.todays_reminders));
        sectionHeaderOne.setIsSectionHeader(true);
        adapter.addSectionHeaderItem(sectionHeaderOne);
        /* Loop through all reminders and only add those that are for today to the adapter's data source. */
        for (Reminder r:allReminders) {
            if (r.isToday()) {
                adapter.addItem(r);
            }
        }
        /* Add second section header – all reminders */
        Reminder sectionHeaderTwo = new Reminder(getResources().getString(R.string.all_reminders));
        sectionHeaderTwo.setIsSectionHeader(true);
        adapter.addSectionHeaderItem(sectionHeaderTwo);
        /* Loop through all reminders and add each one to the data source. */
        for (Reminder r:allReminders) {
            adapter.addItem(r);
        }
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.reminders_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    /* Initializes an adapter (with empty data source) for the list view. */
    private void setUpListView() {
        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.reminders_list_view);
        adapter = new RemindersAdapter(this);
        listView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* TO DO: transition to reminder detail view */
            }
        });
    }

    /* Callback for when the user "checks" or "unchecks" a reminder. */
    public void clickedCheckButton(boolean selected, Reminder reminderSelected) {
        for (Reminder r: this.allReminders) {
            if (reminderSelected.equals(r)) {
                r.setCompleted(!r.isCompleted());
                r.updateInDatabase(rDbHelper.getWritableDatabase());
            }
        }
    }

    /* Callback for when the user clicks the info button on a reminder. */
    public void clickedEditButton(Reminder reminderSelected) {
        /* TO DO: start new activity in edit mode */
        Intent intent = new Intent(this, CreateReminderActivity.class);
        intent.putExtra(EXTRA_IS_EDITING, true);
        intent.putExtra(EXTRA_REMINDER, reminderSelected);
        this.reminderBeingEdited = reminderSelected;
        startActivityForResult(intent, CREATE_REMINDER);
    }
}
