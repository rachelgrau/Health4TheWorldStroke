package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Spannable;
import android.text.SpannableString;
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
        /* FIRST PARAGRAPH */
        String firstPart = "High blood sugar ";
        String secondPart = "can increase the risk of developing strokes and heart disease. A blood test called HbA1c gives a picture of your average blood sugar control for the past 2 to 3 months.";
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        /* SECOND PARAGRAPH */
        firstPart = "The American Heart Association recommends keeping blood sugar levels (Hgb1A1c)";
        secondPart = " below 6% ";
        String thirdPart = "for patients with pre-diabetes and";
        String fourthPart = " below 7% ";
        String fifthPart = "for diabetic patients.";
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart + fourthPart + fifthPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length() + secondPart.length() + thirdPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length() + fifthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);
    }

    public void setUpBloodPressure() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstPart = "High blood pressure";
        String secondPart = " can cause strokes by damaging arteries throughout the body causing them to burst or clog more easily.";
        Spannable firstParSpannable = new SpannableString(firstPart+secondPart);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        /* SECOND PARAGRAPH */
        firstPart = "In the general population aged 60 years or older, treating high BP to a goal of";
        secondPart = " lower than 150/90 mm Hg ";
        String thirdPart = "reduces stroke.";
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);
    }

    public void setUpHeartRate() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "Atrial Fibrillation";
        String secondWord = ", or irregular heart rate, is a risk factor for stroke.";
        Spannable firstParSpannable = new SpannableString(firstWord+secondWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstWord.length(), firstWord.length() + secondWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        /* SECOND PARAGRAPH */
        String firstPart = "If you have suspicion of an irregular heart rate, contact your doctor immediately for testing, which might include";
        String secondPart = " electrocardiogram (ECG/EKG)"; // bold
        String thirdPart = ". Based on your past medical history and your risk for having a future stroke, there are several options for medications, like";
        String fourthPart = " anticoagulants"; // bold
        String fifthPart = ", that will help manage AFib.";
        Spannable secondParSpannable = new SpannableString(firstPart + secondPart + thirdPart + fourthPart + fifthPart);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length(), firstPart.length() + secondPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length(), firstPart.length() + secondPart.length() + thirdPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), firstPart.length() + secondPart.length() + thirdPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        secondParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length(), firstPart.length() + secondPart.length() + thirdPart.length() + fourthPart.length() + fifthPart.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(secondParSpannable);
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
    public void addTextViewWithText(Spannable text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        secondPar.setTypeface(font);
        secondPar.setText(text);
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
