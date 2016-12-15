package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.rachel.health4theworldstroke.Models.VideoLearnContent;
import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_TITLE;

public class VideoContentActivity extends AppCompatActivity {
    /* Video categories */
    public static final String STRENGTHENING = "Strengthening";
    public static final String LEGS = "Legs";
    public static final String ARMS = "Arms";
    public static final String COORDINATION = "Coordination";
    public static final String STRETCHING = "Stretching";
    public static final String LEGS_AND_FEET = "Legs and feet";
    public static final String ARMS_AND_HANDS = "Arms and hands";
    public static final String FUNCTIONAL_MOBILITY = "Functional mobility";
    public static final String MIND_EXERCISES = "Mind exercises";
    /* Videos */
    public static final String U1 = "U1";
    public static final String U2 = "U2";
    public static final String U3 = "U3";
    public static final String U4 = "Elbow";
    public static final String U5 = "Leg";
    public static final String U6 = "Leg";
    public static final String U7 = "Shoulder";
    public static final String U8 = "Toe";
    public static final String S1 = "Knee";
    public static final String S2 = "Hip";
    public static final String S3 = "S3";
    public static final String S4 = "S4";
    public static final String S5 = "S5";
    public static final String S6 = "S6";
    public static final String S7 = "S7";
    public static final String S8 = "S8";
    public static final String S9 = "S9";

    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_content);
        this.title = this.getIntent().getExtras().getString(EXTRA_TITLE);
        setUpToolbar();
        loadVideos();
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

    private void loadVideos() {
        if (title.equals(S1)) {
            addVideoWithURI(getUriPath(R.raw.s1_knee_flexion));
        } else if (title.equals(S2)) {
            addVideoWithURI(getUriPath(R.raw.s2_hip_flexion));
        } else if (title.equals(U4)) {
            addVideoWithURI(getUriPath(R.raw.u4_elbow_flexion));
        } else if (title.equals(U5)) {
            addVideoWithURI(getUriPath(R.raw.u5_leg_control));
        } else if (title.equals(U6)) {
            addVideoWithURI(getUriPath(R.raw.u6_leg_control));
        } else if (title.equals(U7)) {
            addVideoWithURI(getUriPath(R.raw.u7_shoulder_flexion));
        } else if (title.equals(U8)) {
            addVideoWithURI(getUriPath(R.raw.u8_toe_dorsiflexion));
        } else {
            /* TO DO: when we get more videos, add them here! */
        }
        addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
    }

    /* Returns the URI Path to the video with the given name, or the empty string if there is none. */
    private String getUriPath(int videoId) {
        String uriPath = "android.resource://com.example.rachel.health4theworldstroke/";
        uriPath += videoId;
        return uriPath;
    }

    public void addVideoFooterWithTitle(String title) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.videos);
        TextView header = new TextView(this);
        header.setText(title);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        layoutParams.setMargins(35, 35, 35, 35);
        header.setLayoutParams(layoutParams);
        layout.addView(header);
    }

    public void addVideoWithURI(String uriPath) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.videos);

        VideoView video = new VideoView(this);

        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        video.setLayoutParams(layoutParams);

        Uri uri2 = Uri.parse(uriPath);
        video.setVideoURI(uri2);
        video.requestFocus();
        video.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        video.start();


        layout.addView(video);
    }
}
