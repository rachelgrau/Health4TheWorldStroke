package com.example.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.RemindersAdapter;
import com.example.rachel.health4theworldstroke.Models.Reminder;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class RemindersActivity extends AppCompatActivity implements View.OnClickListener {

    private RemindersAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        setUpToolbar();
        setUpListView();
        generateRemindersForListView();

        /* Set up listener for new reminder button */
        ImageButton addReminderButton = (ImageButton)findViewById(R.id.add_reminder_button);
        addReminderButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        ImageButton addReminderButton = (ImageButton)findViewById(R.id.add_reminder_button);
        if (v.equals(addReminderButton)) {
            /* Add new reminder */
            Intent intent = new Intent(this, CreateReminderActivity.class);
            startActivity(intent);
        } else {

        }
    }

    /* Loads a list of all reminders. Then loops through them and adds each on to the adapter's
     * data source in the correct order, adding section headers where needed. */
    private void generateRemindersForListView() {
        /* Load all reminders */
        ArrayList<Reminder> allReminders = Reminder.getFakeReminders();
        /* Add first section header – today's reminders */
        adapter.addSectionHeaderItem(new Reminder(getResources().getString(R.string.todays_reminders)));
        /* Loop through all reminders and only add those that are for today to the adapter's data source. */
        for (Reminder r:allReminders) {
            if (r.isToday()) {
                adapter.addItem(r);
            }
        }
        /* Add second section header – all reminders */
        adapter.addSectionHeaderItem(new Reminder(getResources().getString(R.string.all_reminders)));
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
}
