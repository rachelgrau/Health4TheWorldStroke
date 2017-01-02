package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.Adapters.SpeakAdapter;
import com.rachelgrau.rachel.health4theworldstroke.Models.SpeakObject;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;
import java.util.Locale;

public class HelpMeSpeakActivity extends AppCompatActivity implements View.OnClickListener,
        TextToSpeech.OnInitListener {
    /* All speak icons */
    private ArrayList<SpeakObject> allSpeakObjects;
    private SpeakAdapter adapter;
    private TextToSpeech tts;

    /* Only speak icons that fit current search criteria */
    private ArrayList<SpeakObject> speakObjectsToDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help_me_speak);
        setUpToolbar();
        this.allSpeakObjects = SpeakObject.getSpeakObjects(this);
        this.speakObjectsToDisplay = new ArrayList<SpeakObject>(allSpeakObjects);

        /* Set up grid view */
        GridView gridView = (GridView)findViewById(R.id.grid_view);
        adapter = new SpeakAdapter(this, speakObjectsToDisplay);
        gridView.setAdapter(adapter);

        /* Set up call back for selecting an item in grid */
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View view, int position, long id) {
                String toRead = speakObjectsToDisplay.get(position).getText();
                /* Read the text out loud */
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    tts.speak(toRead,TextToSpeech.QUEUE_FLUSH,null, null);
                } else {
                    tts.speak(toRead, TextToSpeech.QUEUE_FLUSH, null);
                }
            }
        });

        /* Set up call back for search text */
        setUpSearch();

        /* Set up search button */
        ImageButton searchButton = (ImageButton)findViewById(R.id.search_button);
        searchButton.setOnClickListener(this);

        /* Set up text reader */
        tts = new TextToSpeech(this, this);
    }

    public void onClick(View v) {
        ImageButton searchButton = (ImageButton)findViewById(R.id.search_button);
        if (v.equals(searchButton)) {
            /* If they click the X button, clear the text from the text view. */
            EditText editText = (EditText)findViewById(R.id.search_edit_text);
            if (editText.getText().length() > 0) {
                editText.setText("");
                searchButton.setImageResource(R.mipmap.search_icon);
                searchButton.setClickable(false);
            }
        }
    }

    /* Sets up the search functionality */
    private void setUpSearch() {
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
                /* Perform the search */
                performSearch(String.valueOf(editText.getText()));

                ImageButton searchButton = (ImageButton)findViewById(R.id.search_button);
                if (editText.getText().length() > 0) {
                    /* If there is text in the EditText, then set the search button image to an "X" to clear text */
                    searchButton.setImageResource(R.mipmap.x_icon);
                    searchButton.setClickable(true);
                } else {
                    /* If there is no text in the EditText, then set the search button image to a search icon */
                    searchButton.setImageResource(R.mipmap.search_icon);
                    searchButton.setClickable(false);
                }
            }
        });
    }

    private void performSearch(String searchText) {
        speakObjectsToDisplay.clear();
        for (SpeakObject obj : allSpeakObjects) {
            if (obj.getText().toUpperCase().contains(searchText.toUpperCase())) {
                speakObjectsToDisplay.add(obj);
            }
        }
        adapter.notifyDataSetChanged();
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

    @Override
    public void onInit(int status) {
        if (status == TextToSpeech.SUCCESS) {
            int result = tts.setLanguage(Locale.US);

            if (result == TextToSpeech.LANG_MISSING_DATA
                    || result == TextToSpeech.LANG_NOT_SUPPORTED) {
                Log.e("TTS", "This Language is not supported");
            }
        } else {
            Log.e("TTS", "Initilization Failed!");
        }
    }

    @Override
    public void onDestroy() {
        // Don't forget to shutdown tts!
        if (tts != null) {
            tts.stop();
            tts.shutdown();
        }
        super.onDestroy();
    }
}
