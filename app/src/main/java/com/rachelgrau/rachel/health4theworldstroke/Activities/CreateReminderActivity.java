package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Database.ReminderDbHelper;
import com.rachelgrau.rachel.health4theworldstroke.Models.Reminder;
import com.rachelgrau.rachel.health4theworldstroke.Models.ReminderTime;
import com.rachelgrau.rachel.health4theworldstroke.Models.TimePickerFragment;
import com.rachelgrau.rachel.health4theworldstroke.R;
import com.rachelgrau.rachel.health4theworldstroke.Views.ReminderTimeView;

import java.util.ArrayList;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.RemindersActivity.EXTRA_CREATED_REMINDER;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.RemindersActivity.EXTRA_DELETED_REMINDER;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.RemindersActivity.EXTRA_IS_EDITING;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.RemindersActivity.EXTRA_REMINDER;

public class CreateReminderActivity extends AppCompatActivity implements View.OnClickListener {
    /* True if the user is editing this reminder, false if they're creating a new one */
    private boolean isEditing;
    /* The reminder they're either creating or editing. */
    private Reminder thisReminder;

    public static final String DAILY_TAB = "Daily";
    public static final String WEEKLY_TAB = "Weekly";
    public static final String CUSTOM_TAB = "Custom";

    public static final int DAY_IS_SELECTED = 0;
    public static final int DAY_IS_UNSELECTED = 1;

    private String reminderTitle;
    private String frequencyTabSelected; // current tab selected
    private ArrayList<TextView> days; // ArrayList of the day buttons
    private Button createButton; // Button they press to create reminder
    private EditText reminderTitleEditText; // Edit text where they put title of reminder

    private ArrayList<ReminderTime> reminderTimes;
    private ArrayList<ReminderTimeView> reminderTimeViews;

    ReminderDbHelper rDbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        rDbHelper = new ReminderDbHelper(getApplicationContext());
        isEditing = getIntent().getBooleanExtra(EXTRA_IS_EDITING, false);
        if (isEditing) {
            thisReminder = (Reminder)getIntent().getSerializableExtra(EXTRA_REMINDER);
        } else {
            thisReminder = new Reminder();
        }

        setContentView(R.layout.activity_create_reminder);
        setUpToolbar();

        reminderTitle = "";

        /* Set up delete reminder button (only appears if editing) */
        setUpDeleteReminder();

        /* Set up listener for add reminder time button */
        ImageButton addReminderTimeButton = (ImageButton)findViewById(R.id.add_reminder_time_button);
        addReminderTimeButton.setOnClickListener(this);

        /* Set up reminder title listener */
        setUpTitleListener();

        /* Set up reminder frequency stuff */
        setUpDayButtons();
        frequencyTabSelected = DAILY_TAB;

        /* Set up reminder time list view + stuff */
        setUpReminderTimes();

        /* Set up listener for new reminder button */
        this.createButton = (Button)findViewById(R.id.create_reminder_button);
        if (isEditing) {
            this.createButton.setText(R.string.save);
        } else {
            this.createButton.setText(R.string.create_reminder);
        }
        enableCreateButtonIfNeeded();
        createButton.setOnClickListener(this);

        /* If isEditing, then populate all the fields with the reminder values. */
        if (isEditing) {
            populateViewsWithReminder();
        }
    }

    private void setUpDeleteReminder() {
        ImageButton deleteReminderButton = (ImageButton)findViewById(R.id.delete_reminder_button);
        if (isEditing) {
            deleteReminderButton.setVisibility(View.VISIBLE);
            deleteReminderButton.setOnClickListener(this);
        } else {
            deleteReminderButton.setVisibility(View.INVISIBLE);
        }
    }

    /* Populates all the views to display the attributes of |thisReminder| (title, frequency, and times) */
    private void populateViewsWithReminder() {
        /* Title */
        reminderTitleEditText.setText(thisReminder.getTitle());
        ImageButton clearButton = (ImageButton)findViewById(R.id.clear_button);
        clearButton.setVisibility(View.VISIBLE);
        clearButton.setClickable(true);

        /* Frequency */
        String freqType = thisReminder.getFrequencyType();
        if (freqType.equals(DAILY_TAB)) {
            selectedDailyTab();
        } else if (freqType.equals(WEEKLY_TAB)) {
            selectedWeeklyTab();
        } else {
            selectedCustomTab();
        }
       String frequencyDays = thisReminder.getFrequencyDays();

        for (int i=0; i < frequencyDays.length(); i++) {
            if (frequencyDays.charAt(i) == '1') {
                TextView day = days.get(i);
                day.setBackgroundColor(ContextCompat.getColor(this, R.color.red));
                day.setTextColor(ContextCompat.getColor(this, R.color.colorWhite));
                day.setTag(DAY_IS_SELECTED);
            }
        }

        /* Times */
        ArrayList<ReminderTime> existingTimes = thisReminder.getTimes();
        for (ReminderTime time: existingTimes) {
            addTime(time.getTimeString());
        }
    }

    /* Enables the create button if there is a reminder text, and at least one time added. */
    private void enableCreateButtonIfNeeded() {
        boolean shouldActivate = true;

        /* If the reminder title is empty, or the user hasn't added any times, then disactivate the button. */
        if (reminderTitleEditText.getText().length() == 0) {
            shouldActivate = false;
        }
        if (reminderTimes.size() == 0) {
            shouldActivate = false;
        }

        /* Set the button's appearance (color) based on whether it's activated. */
        if (shouldActivate) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                createButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_enabled, null));
            } else {
                createButton.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.button_enabled, null));
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                createButton.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.button_disabled, null));
            } else {
                createButton.setBackgroundDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.button_disabled, null));
            }
        }

        createButton.setEnabled(shouldActivate);
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

    private void selectedDailyTab() {
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
    }

    private void selectedWeeklyTab() {
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
    }

    private void selectedCustomTab() {
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

        if (v.equals(dailyTab)) {
            selectedDailyTab();
        } else if (v.equals(weeklyTab)) {
            selectedWeeklyTab();
        } else {
            selectedCustomTab();
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
        reminderTitleEditText = (EditText)findViewById(R.id.title_creator_edit_text);
        Context c = this;
        reminderTitleEditText.addTextChangedListener(new TextWatcher() {
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
                enableCreateButtonIfNeeded();
            }
        });
    }

    public void onClick(View v) {
        Button createButton = (Button)findViewById(R.id.create_reminder_button);
        ImageButton clearTitleButton = (ImageButton)findViewById(R.id.clear_button);
        ImageButton addReminderTimeButton = (ImageButton)findViewById(R.id.add_reminder_time_button);
        ImageButton deleteReminderButton = (ImageButton)findViewById(R.id.delete_reminder_button);
        if (v.equals(createButton)) {
            /* Create reminder */
            Intent intent = new Intent();
            thisReminder.setTitle(this.reminderTitle);
            /* Add frequency days */
            thisReminder.setFrequencyType(this.frequencyTabSelected);
            thisReminder.clearFrequencyDays();
            for (int i=0; i < days.size(); i++) {
                TextView day = days.get(i);
                if ((Integer)day.getTag() == DAY_IS_SELECTED) {
                    thisReminder.addDayToFrequency(i);
                }
            }
            /* Add times */
            thisReminder.setTimes(reminderTimes);

            intent.putExtra(EXTRA_CREATED_REMINDER, thisReminder);
            intent.putExtra(EXTRA_IS_EDITING, this.isEditing);
            intent.putExtra(EXTRA_DELETED_REMINDER, false);
            setResult(RESULT_OK, intent);

            /* Save reminder */
            if (isEditing) {
                thisReminder.updateInDatabase(rDbHelper.getWritableDatabase());
            } else {
                thisReminder.createInDatabase(rDbHelper.getWritableDatabase());
            }

            finish();
        } else if (v.equals(clearTitleButton)) {
            /* Clear text in title EditText */
            EditText editText = (EditText)findViewById(R.id.title_creator_edit_text);
            if (editText.getText().length() > 0) {
                editText.setText("");
                clearTitleButton.setVisibility(View.INVISIBLE);
                clearTitleButton.setClickable(false);
            }
        } else if (v.equals(addReminderTimeButton)) {
            DialogFragment newFragment = new TimePickerFragment();
            newFragment.show(getFragmentManager(),"TimePicker");
        } else if (v.equals(deleteReminderButton)){
            /* Confirmation dialog */
            new AlertDialog.Builder(this)
                    .setTitle(R.string.delete_reminder_title)
                    .setMessage(R.string.delete_reminder_message)
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int whichButton) {
                            /* Delete reminder! */
                            Intent intent = new Intent();
                            intent.putExtra(EXTRA_CREATED_REMINDER, thisReminder);
                            intent.putExtra(EXTRA_IS_EDITING, isEditing);
                            intent.putExtra(EXTRA_DELETED_REMINDER, true);
                            setResult(RESULT_OK, intent);
                            thisReminder.deleteInDatabase(rDbHelper.getWritableDatabase());
                            finish();
                        }})
                    .setNegativeButton(android.R.string.no, null).show();

        }
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.create_reminder_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        if (isEditing) {
            toolbarTitle.setText(R.string.edit_reminder);
        } else {
            toolbarTitle.setText(R.string.create_reminder);
        }
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    /* REMINDER TIME STUFF */

    /* Initialized ArrayLists of views and models and adds one blank reminder time. */
    private void setUpReminderTimes() {
        reminderTimes = new ArrayList<ReminderTime>();
        reminderTimeViews = new ArrayList<ReminderTimeView>();
    }

    /* Adds a new reminder time both to the layout (a view) and the model (the ArrayList)
     * Also gets called when the user finishes setting a time in the TimePicker. */
    public void addTime(String timeStr) {
        /* Add new reminder time to model */
        ReminderTime reminderTime = new ReminderTime();
        reminderTime.setTimeStr(timeStr);
        reminderTimes.add(reminderTime);

        /* Add blank reminder time view */
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.reminder_times);
        ReminderTimeView timeView = new ReminderTimeView(this, timeStr);

        /* We set the ID of the button to be the index of this reminder time in the list of reminder times.
         *  This way, when we get the callback that a remove button was pressed, we can look at the ID of that
         *  remove button to know which reminder time it belongs to. */
        timeView.setButtonId(reminderTimes.size() - 1);
        reminderTimeViews.add(timeView);

        linearLayout.addView(timeView);
        enableCreateButtonIfNeeded();
    }

    /* Remove the reminder view */
    public void reminderTimeButtonPressed(View v) {
        ImageButton buttonPressed = (ImageButton)v;
        int indexPressed = buttonPressed.getId();

        ReminderTimeView toRemove = reminderTimeViews.get(indexPressed);

        /* Remove reminder time view */
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.reminder_times);
        linearLayout.removeView(toRemove);

        reminderTimeViews.remove(indexPressed);
        reminderTimes.remove(indexPressed);

        /* Update indices */
        for (int i=0; i < reminderTimeViews.size(); i++) {
            ReminderTimeView cur = reminderTimeViews.get(i);
            cur.setButtonId(i);
        }
        thisReminder.updateInDatabase(rDbHelper.getWritableDatabase());
        enableCreateButtonIfNeeded();
    }
}


