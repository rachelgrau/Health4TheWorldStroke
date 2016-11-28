package com.example.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.RemindersAdapter;
import com.example.rachel.health4theworldstroke.Models.Reminder;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class RemindersActivity extends AppCompatActivity {

    private RemindersAdapter adapter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reminders);
        setUpToolbar();
        setUpListView();
        generateRemindersForListView();
    }

    private void generateRemindersForListView() {
        ArrayList<Reminder> allReminders = Reminder.getFakeReminders();
        adapter.addSectionHeaderItem(new Reminder("Today's Reminder"));
        for (Reminder r:allReminders) {
            if (r.isToday()) {
                adapter.addItem(r);
            }
        }
        adapter.addSectionHeaderItem(new Reminder("All Reminders"));
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
