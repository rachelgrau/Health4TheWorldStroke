package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.rachel.health4theworldstroke.R;

public class VideoContentActivity extends AppCompatActivity {
    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_content);
        this.title = this.getIntent().getExtras().getString("title");
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
        String uriPath = "android.resource://com.example.rachel.health4theworldstroke/" + R.raw.female_knee_flexion;
        Uri uri2 = Uri.parse(uriPath);
        vidView.setVideoURI(uri2);
        vidView.requestFocus();
        vidView.start();
    }
}
