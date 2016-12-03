package com.example.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.ReminderTimesAdapter;
import com.example.rachel.health4theworldstroke.Models.ReminderTime;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class CreateReminderActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String DAILY_TAB = "daily";
    public static final String WEEKLY_TAB = "weekly";
    public static final String CUSTOM_TAB = "custom";

    public static final int DAY_IS_SELECTED = 0;
    public static final int DAY_IS_UNSELECTED = 1;

    private String reminderTitle;
    private String frequencyTabSelected; // current tab selected
    private ArrayList<TextView> days; // ArrayList of the day buttons

    private ArrayList<ReminderTime> reminderTimes;
    private ListView listView;
    private ReminderTimesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_reminder);
        setUpToolbar();

        reminderTitle = "";

        /* Set up listener for new reminder button */
        Button createButton = (Button)findViewById(R.id.create_reminder_button);
        createButton.setOnClickListener(this);

        /* Set up reminder title listener */
        setUpTitleListener();

        /* Set up reminder frequency stuff */
        setUpDayButtons();
        frequencyTabSelected = DAILY_TAB;

        /* Set up reminder time list view + stuff */
        reminderTimes = new ArrayList<ReminderTime>();
        reminderTimes.add(new ReminderTime());
        setUpListView();
    }

    /* Adds all the selectable day textviews to the arraylist "days" */
    private void setUpDayButtons() {
        days = new ArrayList<TextView>();
        days.add((TextView)findViewById(R.id.sunday));
        days.add((TextView)findViewById(R.id.monday));
        days.add((TextView)findViewById(R.id.tuesday));
        days.add((TextView)findViewById(R.id.wednesday));
        days.add((TextView)findViewById(R.id.thursday));
        days.add((TextView)findViewById(R.id.friday));
        days.add((TextView)findViewById(R.id.saturday));
        for (TextView day: days) {
            /* Starts out with tab on daily, so all days are selected */
            day.setTag(DAY_IS_SELECTED);
        }
    }

    /* Callback for when the user clicks on one of the days of the week. If the day is already selected, then
     * this method unselects that day. If the day isn't yet selected, then it selects the day. */
    public void clickedDay(View v) {
        /* Days are only selectable in the "weekly" and "custom" tabs; in "daily" they're just all selected. */
        TextView day = (TextView)v;
        if (frequencyTabSelected.equals(WEEKLY_TAB)) {
            if ((int)day.getTag() == DAY_IS_SELECTED) {
                /* Deselect day */
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTextColor(ContextCompat.getColor(this, R.color.red));
                day.setTag(DAY_IS_UNSELECTED);
            } else {
                /* Select day */
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                day.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTag(DAY_IS_SELECTED);
            }
            /* Deselect all other days */
            for (TextView currDay: days) {
                if (!currDay.equals(day)) {
                    currDay.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
                    currDay.setTextColor(ContextCompat.getColor(this, R.color.red));
                    currDay.setTag(DAY_IS_UNSELECTED);
                }
            }
        } else if (frequencyTabSelected.equals(CUSTOM_TAB)) {
            if ((int)day.getTag() == DAY_IS_SELECTED) {
                /* Deselect day */
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTextColor(ContextCompat.getColor(this, R.color.red));
                day.setTag(DAY_IS_UNSELECTED);
            } else {
                /* Select day */
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                day.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTag(DAY_IS_SELECTED);
            }
        }
    }

    /* Callback for when the user clicks on the "daily" "weekly" or "custom" tab.
     * Updates the views of each tab (showing or hiding the pink bottom bar) and
     * updates the day views accordingly. */
    public void clickedFrequencyTab(View v) {
        /* Get the views that we'll be changing */
        TextView dailyTab = (TextView)findViewById(R.id.daily_tab_top);
        TextView weeklyTab = (TextView)findViewById(R.id.weekly_tab_top);
        TextView customTab = (TextView)findViewById(R.id.custom_tab_top);
        View dailyRedBar = (View) findViewById(R.id.daily_tab_red_bottom);
        View weeklyRedBar = (View) findViewById(R.id.weekly_tab_red_bottom);
        View customRedBar = (View) findViewById(R.id.custom_tab_red_bottom);

        final float scaleOne = getResources().getDisplayMetrics().density;
        int selectedTabHeight = (int) (45 * scaleOne + 0.5f);
        final float scaleTwo = getResources().getDisplayMetrics().density;
        int unselectedTabHeight = (int) (50 * scaleTwo + 0.5f);

        if (v.equals(dailyTab)) {
            /* DAILY TAB */
            frequencyTabSelected = DAILY_TAB;
            /* Update the heights of each tab. */
            dailyTab.getLayoutParams().height = selectedTabHeight;
            weeklyTab.getLayoutParams().height = unselectedTabHeight;
            customTab.getLayoutParams().height = unselectedTabHeight;
            /* Show the red bar on the daily tab and hide it on the weekly/custom tabs. */
            dailyRedBar.setVisibility(View.VISIBLE);
            weeklyRedBar.setVisibility(View.GONE);
            customRedBar.setVisibility(View.GONE);
            /* Select all days */
            for (TextView day: days) {
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                day.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTag(DAY_IS_SELECTED);
            }
            LinearLayout weekCalendar = (LinearLayout)findViewById(R.id.week_calendar);
            weekCalendar.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
        } else if (v.equals(weeklyTab)) {
            /* WEEKLY TAB */
            frequencyTabSelected = WEEKLY_TAB;
            /* Update the heights of each tab. */
            dailyTab.getLayoutParams().height = unselectedTabHeight;
            weeklyTab.getLayoutParams().height = selectedTabHeight;
            customTab.getLayoutParams().height = unselectedTabHeight;
            /* Show the red bar on the daily tab and hide it on the weekly/custom tabs. */
            dailyRedBar.setVisibility(View.GONE);
            weeklyRedBar.setVisibility(View.VISIBLE);
            customRedBar.setVisibility(View.GONE);
            for (TextView day: days) {
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTextColor(ContextCompat.getColor(this, R.color.red));
                day.setTag(DAY_IS_UNSELECTED);
            }
            LinearLayout weekCalendar = (LinearLayout)findViewById(R.id.week_calendar);
            weekCalendar.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        } else {
            /* CUSTOM TAB */
            frequencyTabSelected = CUSTOM_TAB;
            /* Update the heights of each tab. */
            dailyTab.getLayoutParams().height = unselectedTabHeight;
            weeklyTab.getLayoutParams().height = unselectedTabHeight;
            customTab.getLayoutParams().height = selectedTabHeight;
            /* Show the red bar on the daily tab and hide it on the weekly/custom tabs. */
            dailyRedBar.setVisibility(View.GONE);
            weeklyRedBar.setVisibility(View.GONE);
            customRedBar.setVisibility(View.VISIBLE);
            for (TextView day: days) {
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTextColor(ContextCompat.getColor(this, R.color.red));
                day.setTag(DAY_IS_UNSELECTED);
            }
            LinearLayout weekCalendar = (LinearLayout)findViewById(R.id.week_calendar);
            weekCalendar.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
        }
    }

    /* Sets up the EditText where the user types the title of the reminder. We need to listen for
     * when the title EditText is not empty  so that we can add an "X" clear button. Also sets
     * up callback for clicking on that "X" clear button. */
    private void setUpTitleListener() {
        /* Set up on click listener for the "X" clear button in EditText */
        ImageButton clearButton = (ImageButton)findViewById(R.id.clear_button);
        clearButton.setOnClickListener(this);
        /* Set up EditText on change listener*/
        EditText editText = (EditText)findViewById(R.id.title_creator_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText editText = (EditText)findViewById(R.id.title_creator_edit_text);
                ImageButton clearButton = (ImageButton)findViewById(R.id.clear_button);
                if (editText.getText().length() > 0) {
                    /* If there is text in the EditText, then show the clear button */
                    clearButton.setVisibility(View.VISIBLE);
                    clearButton.setClickable(true);
                } else {
                    /* If there is no text in the EditText, then hide the clear button */
                    clearButton.setVisibility(View.INVISIBLE);
                    clearButton.setClickable(false);
                }
                reminderTitle = editText.getText().toString();
            }
        });
    }

    public void onClick(View v) {
        Button createButton = (Button)findViewById(R.id.create_reminder_button);
        ImageButton clearTitleButton = (ImageButton)findViewById(R.id.clear_button);

        if (v.equals(createButton)) {
            /* Create reminder */
            Intent intent = new Intent();
            /* TO DO: pass new reminder back in intent */
            intent.putExtra("test", "HELLO!");
            setResult(RESULT_OK, intent);
            finish();
        } else if (v.equals(clearTitleButton)) {
            /* Clear text in title EditText */
            EditText editText = (EditText)findViewById(R.id.title_creator_edit_text);
            if (editText.getText().length() > 0) {
                editText.setText("");
                clearTitleButton.setVisibility(View.INVISIBLE);
                clearTitleButton.setClickable(false);
            }
        } else {
        }
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.create_reminder_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.reminder_times_list_view);
        adapter = new ReminderTimesAdapter(this, reminderTimes);
        listView.setAdapter(adapter);
    }

    /* Called when the button (which might be add or remove) on a reminder time is pressed. */
    public void timeButtonPressed(View v) {
        RelativeLayout vwParentRow = (RelativeLayout)v.getParent();
        int index = (int)v.getTag(); // index in list view
        if (index == (reminderTimes.size() - 1)) {
            /* They want to add a new time */
            reminderTimes.add(new ReminderTime());
        } else {
            /* They want to remove the time at index |index| */
            reminderTimes.remove(index);
        }
        adapter.notifyDataSetChanged();
    }
}


