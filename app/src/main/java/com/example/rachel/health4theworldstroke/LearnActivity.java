package com.example.rachel.health4theworldstroke;

import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {

    private ListView learnContentListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        setUpToolbar();
        setUpListView();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        learnContentListView = (ListView)findViewById(R.id.learn_content_list_view);
        final ArrayList<ReadLearnContent> learnContent = ReadLearnContent.getReadContent();
        ReadLearnAdapter adapter = new ReadLearnAdapter(this, learnContent);
        learnContentListView.setAdapter(adapter);
    }
}
