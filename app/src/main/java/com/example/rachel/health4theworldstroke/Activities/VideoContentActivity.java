package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnPreparedListener;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.GridLayout;
import android.widget.ImageView;
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
    public static final String U1 = "Bridge hip lift";
    public static final String U2 = "U2";
    public static final String U3 = "Arm + trunk strengthening";
    public static final String U4 = "Elbow";
    public static final String U5 = "Leg 1";
    public static final String U6 = "Leg 2";
    public static final String U7 = "Shoulder";
    public static final String U8 = "Toe";
    public static final String S1 = "Knee";
    public static final String S2 = "Hip";
    public static final String S3 = "Sit to stand";
    public static final String S4 = "Adductors";
    public static final String S5 = "Shoulder stretches";
    public static final String S6 = "Arm stretch";
    public static final String S7 = "Hamstrings";
    public static final String S8 = "Hand stretch";
    public static final String S9 = "Dorsiflexors";

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
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(S2)) {
            addVideoWithURI(getUriPath(R.raw.s2_hip_flexion));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(S3)) {
            addVideoWithURI(getUriPath(R.raw.s3_sit_to_stand));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U1)) {
            addVideoWithURI(getUriPath(R.raw.u1_bridge_hip_lift));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U3)){
            addVideoWithURI(getUriPath(R.raw.u3_arm_trunk_strengthening));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U4)) {
            addVideoWithURI(getUriPath(R.raw.u4_elbow_flexion));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U5)) {
            addVideoWithURI(getUriPath(R.raw.u5_leg_control));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U6)) {
            addVideoWithURI(getUriPath(R.raw.u6_leg_control));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U7)) {
            addVideoWithURI(getUriPath(R.raw.u7_shoulder_flexion));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U8)) {
            addVideoWithURI(getUriPath(R.raw.u8_toe_dorsiflexion));
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(S4)) {
            /* Adductors */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.adductors1, R.drawable.adductors2);
        } else if (title.equals(S7)) {
            /* Hamstrings */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.hamstrings1, R.drawable.hamstrings2);
        }  else if (title.equals(S8)) {
            /* Hand */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.hand1, R.drawable.hand2);

        }  else if (title.equals(S5)) {
            /* Shoulder */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.shoulder1, R.drawable.shoulder2);
        }  else if (title.equals(S6)) {
            /* Arm */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.arm1, R.drawable.arm2);
        }  else if (title.equals(S9)) {
            /* Dorsiflexors */
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
            addImagesWithURI(R.drawable.dorsiflexors1, R.drawable.dorsiflexors2);
        } else if (title.equals(MIND_EXERCISES)) {
            /* TEMP UNTIL WE GET MIND EXERCISES*/
            addVideoFooterWithTitle("Coming soon!");
        }
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
        header.setTextSize(20);
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

    public void addImagesWithURI(int imgOne, int imgTwo) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.videos);

        ImageView imageViewOne = new ImageView(this);
        //setting image resource
        imageViewOne.setImageResource(imgOne);
        //setting image position
        imageViewOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));
        ImageView imageViewTwo = new ImageView(this);
        //setting image resource
        imageViewTwo.setImageResource(imgTwo);
        //setting image position
        imageViewTwo.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));

        layout.addView(imageViewOne);
        layout.addView(imageViewTwo);
    }
}
