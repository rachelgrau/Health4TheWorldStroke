package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.BLADDER_BOWEL;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_SUGAR;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.DIET;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.EXERCISES;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.FAQ;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.HEART_RATE;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.HOME_MODIFICATION;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.SHOWER_BATH;

public class ReadContentActivity extends AppCompatActivity {
    public String title;
    private String text; // The actual content

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content);
        this.title = this.getIntent().getExtras().getString("title");
        setUpToolbar();
        setUpContent();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.read_content_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpContent() {
        System.out.println(title);
        TextView tv = (TextView)findViewById(R.id.content);
        text = "";
        if (title.equals(HEART_RATE)) {
            text = getString(R.string.heart_rate_content);
        } else if (title.equals(BLOOD_SUGAR)) {
            text = getString(R.string.blood_sugar_content);
        } else if (title.equals(DIET)) {
            text = getString(R.string.diet_content);
        } else if (title.equals(EXERCISES)) {
            text = getString(R.string.exercises_content);
        } else if (title.equals(SHOWER_BATH)) {
            text = getString(R.string.bath_content);
        } else if (title.equals(BLADDER_BOWEL)) {
            text = getString(R.string.bladder_bowel_content);
        } else if (title.equals(HOME_MODIFICATION)) {
            text = getString(R.string.home_mod_content);
        } else if (title.equals(FAQ)) {
            text = getString(R.string.faq_content);
        }
        tv.setText(text);
    }
}
