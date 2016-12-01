package com.example.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

public class CreateReminderActivity extends AppCompatActivity implements View.OnClickListener {
    private String reminderTitle;

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
}
