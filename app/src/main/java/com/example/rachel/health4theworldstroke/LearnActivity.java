package com.example.rachel.health4theworldstroke;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.ListView;
import android.widget.ArrayAdapter;
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
        String[] listItems = new String[learnContent.size()];
        for (int i=0; i < learnContent.size(); i++) {
            ReadLearnContent item = learnContent.get(i);
            listItems[i] = item.title;
        }
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, listItems);
        learnContentListView.setAdapter(adapter);
    }
}
