package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.SpeakAdapter;
import com.example.rachel.health4theworldstroke.Models.SpeakObject;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class HelpMeSpeakActivity extends AppCompatActivity {
    /* All speak icons */
    private ArrayList<SpeakObject> allSpeakObjects;

    /* Only speak icons that fit current search criteria */
    private ArrayList<SpeakObject> speakObjectsToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me_speak);
        setUpToolbar();
        this.allSpeakObjects = SpeakObject.getSpeakObjects(this);

        /* Set up grid view */
        GridView gridView = (GridView)findViewById(R.id.grid_view);
        SpeakAdapter speakAdapter = new SpeakAdapter(this, allSpeakObjects);
        gridView.setAdapter(speakAdapter);

        /* Set up call back for selecting an item in grid */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                String toRead = allSpeakObjects.get(position).getText();
                /* TO DO: read |toRead| out loud here. */
                System.out.println(toRead);
            }
        });

        /* Set up call back for search text */
        setUpSearch();
    }

    /* Sets up the search functionality */
    private void setUpSearch() {
        allSpeakObjects = "";
        EditText editText = (EditText)findViewById(R.id.search_edit_text);
        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                EditText editText = (EditText)findViewById(R.id.search_edit_text);
                performSearch(String.valueOf(editText.getText()));
            }
        });
    }

    private void performSearch(String searchText) {
        if (searchText.length() == 0) {

        }
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.help_me_speak_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    /* Updates the speakObjects array based on search criteria. */
    private void updateSpeakObjects() {

    }
}
