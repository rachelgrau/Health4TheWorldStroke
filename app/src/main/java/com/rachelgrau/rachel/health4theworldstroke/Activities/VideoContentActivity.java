package com.rachelgrau.rachel.health4theworldstroke.Activities;

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

import com.rachelgrau.rachel.health4theworldstroke.Models.VideoLearnContent;
import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_TITLE;

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

    public static final String U1_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Bridge+Hip+Lift.mp4";
    public static final String U3_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Arm+and+Trunk+Strengthening.mp4";
    public static final String U4_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Elbow+Flexion.mp4";
    public static final String U5_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Leg+Control+1.mp4";
    public static final String U6_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Leg+Control+2.mp4";
    public static final String U7_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Shoulder+Flexion.mp4";
    public static final String U8_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Toe+Dorsiflexion.mp4";
    public static final String S1_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Knee+Flexion.mp4";
    public static final String S2_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Hip+Flexion.mp4";
    public static final String S3_URL = "https://s3.amazonaws.com/h4twappvideoswithcopyright/Sit+to+Stand.mp4";


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

    /* Figures out which video we need to add based on the title (this is just hard coded for now...)
      and adds it to the layout. */
    private void loadVideos() {
        if (title.equals(S1)) {
            addVideoWithURL(S1_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(S2)) {
            addVideoWithURL(S2_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(S3)) {
            addVideoWithURL(S3_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U1)) {
            addVideoWithURL(U1_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U3)){
            addVideoWithURL(U3_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U4)) {
            addVideoWithURL(U4_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U5)) {
            addVideoWithURL(U5_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U6)) {
            addVideoWithURL(U6_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U7)) {
            addVideoWithURL(U7_URL);
            addVideoFooterWithTitle(VideoLearnContent.getInstructionsForVideo(title));
        } else if (title.equals(U8)) {
            addVideoWithURL(U8_URL);
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

    /* Returns the URI Path to the given video ID. */
    private String getUriPath(int videoId) {
        String uriPath = "android.resource://com.example.rachel.health4theworldstroke/";
        uriPath += videoId;
        return uriPath;
    }

    /* Adds a text view with the given text to the layout. */
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

    /* Adds a video with the given URI path to the layout. */
    public void addVideoWithURL(String url) {
        LinearLayout layout = (LinearLayout) findViewById(R.id.videos);

        VideoView video = new VideoView(this);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(GridLayout.LayoutParams.MATCH_PARENT, GridLayout.LayoutParams.WRAP_CONTENT);
        video.setLayoutParams(layoutParams);
        video.setVideoURI(Uri.parse(url));
        video.start();
        video.setKeepScreenOn(true);
        video.requestFocus();
        video.setOnPreparedListener(new OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        layout.addView(video);
    }

    /* Adds the given images to the layout. */
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
