package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_TITLE;

public class VideoContentActivity extends AppCompatActivity {
    public String title;

    /* Video titles */
    public static final String KNEE_FLEXION = "KneeFlexion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_content);
        this.title = this.getIntent().getExtras().getString(EXTRA_TITLE);
        setUpToolbar();
        loadVideo();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.video_content_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void loadVideo() {
        VideoView vidView = (VideoView) findViewById(R.id.video_view);
        String uriPath = getUriPath(KNEE_FLEXION);
        Uri uri2 = Uri.parse(uriPath);
        vidView.setVideoURI(uri2);
        vidView.requestFocus();
        vidView.start();
    }

    /* Returns the URI Path to the video with the given name, or the empty string if there is none. */
    private String getUriPath(String videoName) {
        String uriPath = "android.resource://com.example.rachel.health4theworldstroke/";
        if (videoName.equals(KNEE_FLEXION)) {
            uriPath += R.raw.female_knee_flexion;
        } else {
            uriPath = "";
        }
        return uriPath;
    }
}
