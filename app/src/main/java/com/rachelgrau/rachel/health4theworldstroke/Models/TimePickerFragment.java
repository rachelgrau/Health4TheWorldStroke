package com.rachelgrau.rachel.health4theworldstroke.Models;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.widget.TimePicker;

import com.rachelgrau.rachel.health4theworldstroke.Activities.CreateReminderActivity;
import com.rachelgrau.rachel.health4theworldstroke.Utilities;

import java.util.Calendar;

/**
 * Created by rachel on 12/12/16.
 */

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener{

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState){
        //Use the current time as the default values for the time picker
        final Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);

        //Create and return a new instance of TimePickerDialog
        return new TimePickerDialog(getActivity(),this, hour, minute,
                DateFormat.is24HourFormat(getActivity()));
    }

    //onTimeSet() callback method
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        String timeStr = "";
        if (view.is24HourView()) {
            timeStr = Utilities.getMilitaryTimeString(hourOfDay, minute);
        } else {
            timeStr = Utilities.getAmPmTimeString(hourOfDay, minute);
        }
        CreateReminderActivity theActivity = (CreateReminderActivity)getActivity();
        theActivity.addTime(timeStr);
    }
}