package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.BLADDER_BOWEL;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_PRESSURE;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_SUGAR;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.DIET;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.EXERCISES;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.FAQ;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.HEART_RATE;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.HOME_MODIFICATION;
import static com.example.rachel.health4theworldstroke.Models.ReadLearnContent.SHOWER_BATH;

public class ReadContentActivity extends AppCompatActivity {
    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content);
        this.title = this.getIntent().getExtras().getString("title");
        setUpToolbar();
        setUpContent();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.read_content_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpContent() {
        if (title.equals(BLOOD_PRESSURE)) {
            setUpBloodPressure();
        } else if (title.equals(HEART_RATE)) {
            /* TO DO*/
        } else if (title.equals(BLOOD_SUGAR)) {
            setUpBloodSugar();
        } else if (title.equals(DIET)) {
            setUpDiet();
        } else if (title.equals(EXERCISES)) {
            setUpExercises();
        } else if (title.equals(SHOWER_BATH)) {
            setUpShowerBath();
        } else if (title.equals(BLADDER_BOWEL)) {
            setUpBladderBowel();
        } else if (title.equals(HOME_MODIFICATION)) {
            setUpHomeModification();
        } else if (title.equals(FAQ)) {
            setUpFaq();
        }
    }

    public void setUpBloodPressure() {
        addTextViewWithText("High blood pressure can cause strokes by damaging arteries throughout the body such that they burst or clog more easily.");
        addHeaderWithText("Goal:");
        addTextViewWithText("In the general population aged 60 years or older, treating high BP to a goal of lower than 150/90 mm Hg reduces stroke.");
    }

    public void setUpBloodSugar() {
        addTextViewWithText("High blood sugar can increase the risk of developing strokes and heart disease.");
        addTextViewWithText("A blood test called HbA1c gives a picture of your average blood sugar control for the past 2 to 3 months.");
        addHeaderWithText("Goal:");
        addTextViewWithText("The American Heart Association recommends keeping blood sugar levels (Hgb1A1c) below 6% for patients with pre diabetes and below 7% for diabetic patients.");
    }

    public void setUpExercises() {
        addTextViewWithText("Stroke survivors should receive rehabilitation at an intensity commensurate with anticipated benefit and tolerance.");
        addTextViewWithText("Intensive, repetitive, mobility-task training under supervision of a health care professional can help individuals with gait limitations after stroke.");
        addTextViewWithText("Balance training can help prevent falls.");
        addTextViewWithText("Check with your doctor for customized physical activity preference, specific activity limitations, and exercise participation restrictions.");
        addTextViewWithText("During hospitalization and early recovery, the AHA/ASA recommends low-level walking, self care activities, intermittent sitting or standing, seated activities, or range of motion activities. These activities should be performed as tolerated with a guideline of achieving 10 to 20 bmp increases in heart rate depending on what your physician recommends.");
        addTextViewWithText("During inpatient and outpatient exercise therapy or rehabilitation, the AHA/ASA recommends activities such as walking 3-5 days per week for 20-60 min/session (or multiple 10-min sessions); stretching 2-3 days per week for 10-30 seconds; Tai chi, yoga, and recreational activities as a complement to walking or stretching.");
        addTextViewWithText("During inpatient and outpatient exercise therapy or rehabilitation, the AHA/ASA recommends activities such as walking 3-5 days per week for 20-60 min/session (or multiple 10-min sessions); stretching 2-3 days per week for 10-30 seconds; Tai chi, yoga, and recreational activities as a complement to walking or stretching.");
    }

    public void setUpDiet() {
        addTextViewWithText("It’s best to eat an overall healthy diet with a variety of fruits and vegetables, whole grains, low-fat dairy products, skinless meat and fish, and nuts and legumes.");
        addTextViewWithText("Individuals with stroke residing in long-term care facilities should be evaluated for calcium and vitamin D supplementation.");
        addTextViewWithText("Cut back on saturated fat, trans fat, sodium, red meat, sweets and sugar-sweetened beverages.");
    }

    public void setUpShowerBath() {
        addTextViewWithText("Showers are safer than tubs generally. Grab bars might help make movement easier.");
        addTextViewWithText("Bath mats with suction cups will help you avoid slipping.");
        addTextViewWithText("Make sure someone is nearby to help you if needed. Keep a bell handy or have another way to call for help.");
        addTextViewWithText("Balance training can help individuals with balance problems.");
    }

    public void setUpBladderBowel() {
        addTextViewWithText("Assessment of urinary retention through bladder scanning or intermittent catheterizations after voiding while recording volumes can be helpful with patients with urinary incontinence or retention.");
        addTextViewWithText("Going to the bathroom at regular times can help train your bladder. Urinating every 2-3 hours can help prevent accidents.");
        addTextViewWithText("Drinking plenty of fluids during the day to stay hydrated can help you avoid constipation.");
    }

    public void setUpHomeModification() {
        addHeaderWithText("Bedroom:");
        addTextViewWithText("Bedroom accessibility can be improved by moving items so that the door opens fully; widen doorways; reverse hinges so that door opens outwards instead of inwards.");
        addTextViewWithText("Drinking plenty of fluids during the day to stay hydrated can help you avoid constipation.");
        addHeaderWithText("General:");
        addTextViewWithText("Eliminate rugs that can easily move to avoid trips and falls.");
        addHeaderWithText("Bath:");
        addTextViewWithText("Bathrooms can be made more accessible to wheelchairs by widening the doorway.");
        addTextViewWithText("Toilet seats can be raised to make it less challenging in getting to and from the toilet: a toilet elevator that mounts between the floor and toilet; a seat elevator that attaches to the bowl and raises the seat; installing toilet rails/grab bars to improve support for mobility.");
    }

    public void setUpFaq() {
        addHeaderWithText("What is a stroke?");
        addTextViewWithText("In stroke, the blood supply to a particular part of the brain is blocked or a blood vessel that supplies a part of the brain bursts. This results in cell death in the affected part of the brain.");
        addHeaderWithText("What are the signs of a stroke?");
        addTextViewWithText("TO DO!");
        addHeaderWithText("What should you do if you think someone is having a stroke?");
        addTextViewWithText("Call for professional medical help immediately.");
        addHeaderWithText("Why do you need to act quickly?");
        addTextViewWithText("Getting fast medical treatment lowers the risk of disability or even death.");
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(60, 60, 60, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(60, 60, 60, 60);
        secondPar.setTextSize(20);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }
}