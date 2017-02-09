package com.rachelgrau.rachel.health4theworldstroke.Activities;

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

import com.rachelgrau.rachel.health4theworldstroke.Adapters.LearnContentAdapter;
import com.rachelgrau.rachel.health4theworldstroke.Models.LearnContent;
import com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.Models.VideoLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.RESOURCES;

public class LearnActivity extends AppCompatActivity {
    public static final String EXTRA_PAGE_TYPE = "pageType";
    public static final String EXTRA_VIDEO_CATEGORY = "videoCategory";
    public static final String EXTRA_TITLE = "title";

    public static final String PAGE_TYPE_READ = "Read";
    public static final String PAGE_TYPE_VIDEO = "Video";
    public static final String PAGE_TYPE_VIDEO_SUBCATEGORY = "VideoSubcategory";

    /* Page type can be:
     * Read
     * Video (Strengthening, stretching, functional mobility, exercises)
     * Video sub-category */
    private String pageType;
    private String videoCategory = ""; // if displaying videosubcategories, this string holds the main category

    private ListView listView; // list of read or video content, depending which tab is selected
    private LearnContentAdapter adapter;
    private ArrayList<LearnContent> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.pageType = this.getIntent().getStringExtra(EXTRA_PAGE_TYPE);
        if (pageType.equals(PAGE_TYPE_READ)) {
            content = ReadLearnContent.getReadContent();
        } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
            content = VideoLearnContent.getVideoCategories();
        } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
            videoCategory = this.getIntent().getStringExtra(EXTRA_VIDEO_CATEGORY);
            content = VideoLearnContent.getVideoSubcategories(videoCategory);
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

        if (pageType.equals(PAGE_TYPE_READ)) {
            toolbarTitle.setText(R.string.learn);
        } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
            toolbarTitle.setText(R.string.video);
        } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
            toolbarTitle.setText(videoCategory);
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
                if (pageType.equals(PAGE_TYPE_READ)) {
                    // To read activity
                    ReadLearnContent selectedContent = (ReadLearnContent)content.get(position);
                    String selectedContentTitle = selectedContent.title;
                    if (selectedContentTitle.equals(RESOURCES)) {
                        Intent readIntent = new Intent(context, ReadContentActivity.class);
                        readIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(readIntent);
                    } else {
                        Intent readIntent = new Intent(context, RedLearnContentActivity.class);
                        readIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(readIntent);
                    }
                } else if (pageType.equals(PAGE_TYPE_VIDEO)) {
                    VideoLearnContent selectedContent = (VideoLearnContent)content.get(position);
                    if (VideoLearnContent.categoryHasSubcategories(selectedContent.title)) {
                        // If it's one of these, we need to start another LearnActivity, this time with video subcategories
                        Intent videoSubcategoryIntent = new Intent(context, LearnActivity.class);
                        videoSubcategoryIntent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_VIDEO_SUBCATEGORY);
                        videoSubcategoryIntent.putExtra(EXTRA_VIDEO_CATEGORY, selectedContent.title);
                        startActivity(videoSubcategoryIntent);
                    } else {
                        // If it's one of these, show the video content! No subcategories.
                        Intent videoIntent = new Intent(context, VideoContentActivity.class);
                        videoIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(videoIntent);
                    }
                } else if (pageType.equals(PAGE_TYPE_VIDEO_SUBCATEGORY)) {
                    VideoLearnContent selectedContent = (VideoLearnContent)content.get(position);
                    if (VideoLearnContent.categoryHasSubcategories(selectedContent.title)) {
                        // If it's one of these, we need to start another LearnActivity, this time with video subcategories
                        Intent videoSubcategoryIntent = new Intent(context, LearnActivity.class);
                        videoSubcategoryIntent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_VIDEO_SUBCATEGORY);
                        videoSubcategoryIntent.putExtra(EXTRA_VIDEO_CATEGORY, selectedContent.title);
                        startActivity(videoSubcategoryIntent);
                    } else {
                        // If it's one of these, show the video content! No subcategories.
                        Intent videoIntent = new Intent(context, VideoContentActivity.class);
                        videoIntent.putExtra(EXTRA_TITLE, selectedContent.title);
                        startActivity(videoIntent);
                    }
                }
            }
        });
    }
}
