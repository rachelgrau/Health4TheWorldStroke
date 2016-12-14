package com.example.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.LearnContentAdapter;
import com.example.rachel.health4theworldstroke.Models.LearnContent;
import com.example.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.example.rachel.health4theworldstroke.Models.VideoLearnContent;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {
    public static final String EXTRA_IS_READ = "isRead";

    private boolean isRead; // true if displaying read content, false if displaying video content

    private ListView listView; // list of read or video content, depending which tab is selected
    private LearnContentAdapter adapter;
    private ArrayList<LearnContent> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.isRead = this.getIntent().getBooleanExtra(EXTRA_IS_READ, true);
        if (isRead) {
            content = ReadLearnContent.getReadContent();
        } else {
            content = VideoLearnContent.getVideoContent();
        }
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
        if (isRead) {
            toolbarTitle.setText(R.string.learn);
        } else {
            toolbarTitle.setText(R.string.video);
        }
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.learn_content_list_view);
        adapter = new LearnContentAdapter(this, content);
        listView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                if (isRead) {
                    // To read activity
                    ReadLearnContent selectedContent = (ReadLearnContent)content.get(position);
                    Intent readIntent = new Intent(context, ReadContentActivity.class);
                    readIntent.putExtra("title", selectedContent.title);
                    startActivity(readIntent);
                } else {
                    // To video activity
                    VideoLearnContent selectedContent = (VideoLearnContent)content.get(position);
                    Intent videoIntent = new Intent(context, VideoContentActivity.class);
                    videoIntent.putExtra("title", selectedContent.title);
                    startActivity(videoIntent);
                }
            }
        });
    }
}
