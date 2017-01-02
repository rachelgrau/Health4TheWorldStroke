package com.rachelgrau.rachel.health4theworldstroke.Views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.rachelgrau.rachel.health4theworldstroke.R;

/**
 * Created by rachel on 12/5/16.
 */

public class ReminderTimeView extends RelativeLayout {
    private EditText timeText;
    private ImageButton button;

    public ReminderTimeView(Context context, String time) {
        super(context);
        init(time);
    }

    public ReminderTimeView(Context context, AttributeSet attrs, String time) {
        super(context, attrs);
        init(time);
    }

    public ReminderTimeView(Context context, AttributeSet attrs, int defStyle, String time) {
        super(context, attrs, defStyle);
        init(time);
    }

    /* Sets the ID of the ImageButton */
    public void setButtonId(int idNum) {
        this.button.setId(idNum);
    }

    private void init(String time) {
        inflate(getContext(), R.layout.reminder_time, this);
        this.timeText = (EditText)findViewById(R.id.time_text);
        this.button = (ImageButton) findViewById(R.id.time_button);
        this.timeText.setText(time);
    }
}
