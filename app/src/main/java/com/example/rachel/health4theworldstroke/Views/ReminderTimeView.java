package com.example.rachel.health4theworldstroke.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.example.rachel.health4theworldstroke.R;

/**
 * Created by rachel on 12/5/16.
 */

public class ReminderTimeView extends RelativeLayout {
    private EditText hour;
    private EditText minute;
    private ImageButton button;

    public ReminderTimeView(Context context) {
        super(context);
        init();
    }

    public ReminderTimeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ReminderTimeView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    /* Sets the ID of the ImageButton */
    public void setButtonId(int idNum) {
        this.button.setId(idNum);
    }

    public void showButton() {
        this.button.setVisibility(VISIBLE);
    }

    public void hideButton() {
        this.button.setVisibility(INVISIBLE);
    }

    private void init() {
        inflate(getContext(), R.layout.reminder_time, this);
        this.hour = (EditText)findViewById(R.id.hour_text);
        this.minute = (EditText) findViewById(R.id.minute_text);
        this.button = (ImageButton) findViewById(R.id.time_button);

        this.hour.setText("00:");
        this.minute.setText("00");
    }
}
