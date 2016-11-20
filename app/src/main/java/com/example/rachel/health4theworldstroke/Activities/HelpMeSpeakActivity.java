package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.SpeakAdapter;
import com.example.rachel.health4theworldstroke.Models.SpeakObject;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class HelpMeSpeakActivity extends AppCompatActivity {
    private ArrayList<SpeakObject> speakObjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me_speak);
        setUpToolbar();
        this.speakObjects = SpeakObject.getSpeakObjects(this);

        /* Set up grid view */
        GridView gridView = (GridView)findViewById(R.id.grid_view);
        SpeakAdapter speakAdapter = new SpeakAdapter(this, speakObjects);
        gridView.setAdapter(speakAdapter);

        /* Set up call view for selecting an item in grid */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                String toRead = speakObjects.get(position).getText();
                /* TO DO: read |toRead| out loud here. */
                System.out.println(toRead);
            }
        });
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
