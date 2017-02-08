package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Html;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_PRESSURE;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_SUGAR;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.HEART_RATE;

public class RedLearnContentActivity extends AppCompatActivity {
    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_red_learn_content);
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
        if (this.title.equals(BLOOD_SUGAR)) {
            setUpBloodSugar();
        } else if (this.title.equals(BLOOD_PRESSURE)) {
            setUpBloodPressure();
        } else if (this.title.equals(HEART_RATE)) {
            setUpHeartRate();
        }
    }

    public void setUpBloodSugar() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        String firstPar = "<b>" + "High blood sugar " + "</b>" + "can increase the risk of developing strokes and heart disease. A blood test called HbA1c gives a picture of your average blood sugar control for the past 2 to 3 months.";
        addTextViewWithText(firstPar);
        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String secondPar = "The American Heart Association recommends keeping blood sugar levels (Hgb1A1c)" + "<b>" + " below 6% " + "</b>" + "for patients with pre-diabetes and" + "<b>" + " below 7% " + "</b>" + "for diabetic patients.";
        addTextViewWithText(secondPar);
    }

    public void setUpBloodPressure() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        String firstPar = "<b>" + "High blood pressure" + "</b>" + " can cause strokes by damaging arteries throughout the body causing them to burst or clog more easily.";
        addTextViewWithText(firstPar);
        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String secondPar = "In the general population aged 60 years or older, treating high BP to a goal of" + "<b>" + " lower than 150/90 mm Hg " + "</b>" + "reduces stroke.";
        addTextViewWithText(secondPar);
    }

    public void setUpHeartRate() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        String firstPar = "<b>" + "Atrial Fibrillation " + "</b>" + ", or irregular heart rate, is a risk factor for stroke.";
        addTextViewWithText(firstPar);
        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String secondPar = "If you have suspicion of an irregular heart rate, contact your doctor immediately for testing, which might include" + "<b>" + " electrocardiogram (ECG/EKG)" + "</b>" + ". Based on your past medical history and your risk for having a future stroke, there are several options for medications, like" + "<b>" + " anticoagulants" + "</b>" + ", that will help manage AFib.";
        addTextViewWithText(secondPar);
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(75, 40, 75, 10);
        textView.setTextSize(20);
        textView.setTextColor(Color.WHITE);
        ll.addView(textView);
    }

    /* Text should be in HTML */
    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        secondPar.setTypeface(font);
        secondPar.setText(Html.fromHtml(text));
        secondPar.setPadding(75, 10, 75, 0);
        secondPar.setTextSize(18);
        secondPar.setTextColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        View line = new View(this);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3);
        params.setMargins(75, 0, 75, 0);
        line.setLayoutParams(params);
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.colorWhite));
        ll.addView(line);
    }
}
