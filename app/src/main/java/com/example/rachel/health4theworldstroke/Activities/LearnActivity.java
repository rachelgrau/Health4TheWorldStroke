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

import com.example.rachel.health4theworldstroke.Adapters.ReadLearnAdapter;
import com.example.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {
    public static final String READ_TAB = "Read";
    public static final String VIDEO_TAB = "Video";

    private ListView readListView; // list of read content
    private ListView videosListView; // list of video content
    private String tabSelected; // current tab selected

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        tabSelected = READ_TAB;
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
        readListView = (ListView)findViewById(R.id.learn_content_list_view);
        final ArrayList<ReadLearnContent> learnContent = ReadLearnContent.getReadContent();
        ReadLearnAdapter adapter = new ReadLearnAdapter(this, learnContent);
        readListView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        readListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                ReadLearnContent selectedContent = learnContent.get(position);
                Intent readIntent = new Intent(context, ReadContentActivity.class);
                readIntent.putExtra("title", selectedContent.title);
                readIntent.putExtra("text", selectedContent.text);
                startActivity(readIntent);
            }
        });
    }

    /* When they click the read tab, we update the views of each tab.
     * We add a 5dp gray bar below the read tab, and make the read tab shorter (45dp) to fit this bar.
     * We remove the gray bar below the video tab, and make the video tab taller (50dp) to fill the space. */
    public void clickReadTab(View v) {
        if (!tabSelected.equals(READ_TAB)) {
            tabSelected = READ_TAB;
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

    /* When they click the video tab, we update the views of each tab.
     * We add a 5dp gray bar below the video tab, and make the video tab shorter (45dp) to fit this bar.
     * We remove the gray bar below the read tab, and make the read tab taller (50dp) to fill the space. */
    public void clickVideoTab(View v) {
        if (!tabSelected.equals(VIDEO_TAB)) {
            tabSelected = VIDEO_TAB;
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
