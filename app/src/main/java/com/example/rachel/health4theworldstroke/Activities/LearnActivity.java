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
    public static final String READ_TAB = "Read";
    public static final String VIDEO_TAB = "Video";

    private ListView listView; // list of read or video content, depending which tab is selected
    private LearnContentAdapter adapter;
    private String tabSelected; // current tab selected
    private ArrayList<LearnContent> readContent;
    private ArrayList<LearnContent> videoContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabSelected = READ_TAB;
        readContent = ReadLearnContent.getReadContent();
        videoContent = VideoLearnContent.getVideoContent();
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
        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.learn_content_list_view);
        adapter = new LearnContentAdapter(this, readContent);
        listView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                if (tabSelected.equals(READ_TAB)) {
                    // To read activity
                    ReadLearnContent selectedContent = (ReadLearnContent)readContent.get(position);
                    Intent readIntent = new Intent(context, ReadContentActivity.class);
                    readIntent.putExtra("title", selectedContent.title);
                    startActivity(readIntent);
                } else {
                    // To video activity
                    VideoLearnContent selectedContent = (VideoLearnContent)videoContent.get(position);
                    Intent videoIntent = new Intent(context, VideoContentActivity.class);
                    videoIntent.putExtra("title", selectedContent.title);
                    startActivity(videoIntent);
                }
            }
        });
    }

    /* When they click the read tab, we update the views of each tab and update the displayed list view.
     * We add a 5dp gray bar below the read tab, and make the read tab shorter (45dp) to fit this bar.
     * We remove the gray bar below the video tab, and make the video tab taller (50dp) to fill the space. */
    public void clickReadTab(View v) {
        if (!tabSelected.equals(READ_TAB)) {
            tabSelected = READ_TAB;

            /* Update the list view to show read content. */
            adapter.setDataSource(readContent);

            /* UPDATE THE VIEWS OF THE TABS
            * ------------------------------ */
            /* Update the heights of each tab. */
            TextView readButtonTop = (TextView) findViewById(R.id.read_button_top);
            TextView videoButtonTop = (TextView) findViewById(R.id.video_button_top);
            // Convert 45dp to pixels
            final float scaleOne = getResources().getDisplayMetrics().density;
            int readHeightPixels = (int) (45 * scaleOne + 0.5f);
            readButtonTop.getLayoutParams().height = readHeightPixels;
            // Convert 50 dp to pixels
            final float scaleTwo = getResources().getDisplayMetrics().density;
            int videoHeightPixels = (int) (50 * scaleTwo + 0.5f);
            videoButtonTop.getLayoutParams().height = videoHeightPixels;

            /* Show the gray bar on the read tab and hide it on the video tab. */
            View readGrayBar = (View) findViewById(R.id.read_button_gray_bottom);
            View videoGrayBar = (View) findViewById(R.id.video_button_gray_bottom);
            readGrayBar.setVisibility(View.VISIBLE);
            videoGrayBar.setVisibility(View.GONE);
        }
    }

    /* When they click the video tab, we update the views of each tab and update the displayed list view.
     * We add a 5dp gray bar below the video tab, and make the video tab shorter (45dp) to fit this bar.
     * We remove the gray bar below the read tab, and make the read tab taller (50dp) to fill the space. */
    public void clickVideoTab(View v) {
        if (!tabSelected.equals(VIDEO_TAB)) {
            tabSelected = VIDEO_TAB;

            /* Update the list view to show video content. */
            adapter.setDataSource(videoContent);

            /* UPDATE THE VIEWS OF THE TABS
            * ------------------------------ */
            /* Update the heights of each tab. */
            TextView readButtonTop = (TextView) findViewById(R.id.read_button_top);
            TextView videoButtonTop = (TextView) findViewById(R.id.video_button_top);
            final float scaleOne = getResources().getDisplayMetrics().density;
            // convert 50dp to pixels
            int readHeightPixels = (int) (50 * scaleOne + 0.5f);
            readButtonTop.getLayoutParams().height = readHeightPixels;
            final float scaleTwo = getResources().getDisplayMetrics().density;
            // convert 45dp to pixels
            int videoHeightPixels = (int) (45 * scaleTwo + 0.5f);
            videoButtonTop.getLayoutParams().height = videoHeightPixels;

            /* Show the gray bar on the video tab and hide it on the read tab. */
            View readGrayBar = (View) findViewById(R.id.read_button_gray_bottom);
            View videoGrayBar = (View) findViewById(R.id.video_button_gray_bottom);
            readGrayBar.setVisibility(View.GONE);
            videoGrayBar.setVisibility(View.VISIBLE);
        }

    }
}
