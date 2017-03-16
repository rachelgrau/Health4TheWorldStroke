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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.BLADDER_BOWEL;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_PRESSURE;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.BLOOD_SUGAR;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.DIET;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.EXERCISES;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.FAQ;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.HEART_RATE;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.HOME_MODIFICATION;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.RISK_FACTORS;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.SHOWER_BATH;

public class NewReadLearnContentActivity extends AppCompatActivity {

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
        RelativeLayout layout = (RelativeLayout)findViewById(R.id.activity_red_learn_content);
        if (this.title.equals(BLOOD_SUGAR)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpBloodSugar();
        } else if (this.title.equals(BLOOD_PRESSURE)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpBloodPressure();
        } else if (this.title.equals(HEART_RATE)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpHeartRate();
        } else if (this.title.equals(SHOWER_BATH)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpShowerBath();
        } else if (this.title.equals(EXERCISES)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpExercises();
        } else if (this.title.equals(DIET)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpDiet();
        } else if (this.title.equals(BLADDER_BOWEL)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpBladderBowel();
        } else if (this.title.equals(HOME_MODIFICATION)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpHomeMod();
        } else if (this.title.equals(FAQ)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.colorPrimaryDark));
            setUpFAQ();
        } else if (this.title.equals(RISK_FACTORS)) {
            layout.setBackgroundColor(ContextCompat.getColor(this, R.color.redBackground));
            setUpRiskFactors();
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

        addImageWithURI(R.drawable.blood_sugar);
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

        addImageWithURI(R.drawable.blood_pressure);
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

        addImageWithURI(R.drawable.heart_rate);
    }

    public void setUpShowerBath() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "Stroke patients often have difficulties regaining physical strength and capabilities.";
        Spannable firstParSpannable = new SpannableString(firstWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        /* First bullet point */
        String bulletOneFirst = "• Showers > tubs: ";
        String bulletOneSecond = "showers are safer than tubs generally. Grab bars might help make movement easier.";
        Spannable bulletOneSpannable = new SpannableString(bulletOneFirst+bulletOneSecond);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bulletOneFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletOneFirst.length(), bulletOneFirst.length() + bulletOneSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        addTextViewWithText(bulletOneSpannable);

        /* Second bullet point */
        String bulletTwoFirst = "• Bath mats ";
        String bulletTwoSecond = "showers are safer than tubs generally. Grab bars might help make movement easier.";
        Spannable bulletTwoSpannable = new SpannableString(bulletTwoFirst+bulletTwoSecond);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bulletTwoFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletTwoFirst.length(), bulletTwoFirst.length() + bulletTwoSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletTwoSpannable);

        /* Third bullet point */
        String bulletThreeFirst = "• Make sure someone is nearby to help you if needed. Keep a bell handy or have another way to call for help.";
        Spannable bulletThreeSpannable = new SpannableString(bulletThreeFirst);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletThreeFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletThreeSpannable);

        /* Fourth bullet point */
        String bulletFourFirst = "• Balance training can help individuals with balance problems.";
        Spannable bulletFourSpannable = new SpannableString(bulletFourFirst);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFourFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFourSpannable);

        addImageWithURI(R.drawable.grab_bars_new);
    }

    public void setUpExercises() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "Stroke patients often have difficulties regaining physical strength and capabilities.";
        Spannable firstParSpannable = new SpannableString(firstWord);
        firstParSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(firstParSpannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        /* First bullet point */
        String bulletOneFirst = "• To help with ";
        String bulletOneSecond = "gait limitations";
        String bulletOneThird= ": Patients should do intensive, repetitive, mobility-task training under supervision of a health care professional.";
        Spannable bulletOneSpannable = new SpannableString(bulletOneFirst+bulletOneSecond+bulletOneThird);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletOneFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletOneFirst.length(), bulletOneFirst.length() + bulletOneSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletOneSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletOneFirst.length() + bulletOneSecond.length(), bulletOneFirst.length() + bulletOneSecond.length() + bulletOneThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletOneSpannable);

        /* Second bullet point */
        String bulletTwoFirst = "• To help with ";
        String bulletTwoSecond = "falling";
        String bulletTwoThird= " Patients should do balance training.";
        Spannable bulletTwoSpannable = new SpannableString(bulletTwoFirst+bulletTwoSecond+bulletTwoThird);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletTwoFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletTwoFirst.length(), bulletTwoFirst.length() + bulletTwoSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletTwoSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletTwoFirst.length() + bulletTwoSecond.length(), bulletTwoFirst.length() + bulletTwoSecond.length() + bulletTwoThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletTwoSpannable);

        /* Third bullet point */
        String bulletThreeFirst = "• To help during ";
        String bulletThreeSecond = "hospitalization and early recovery";
        String bulletThreeThird= ": AHA/ASA recommends low-level walking, self care activities, intermittent sitting or standing, seated activities, or range of motion activities. These activities should be performed as tolerated with a guideline of achieving 10 to 20 beats per minute increases in heart rate, depending on what your physician recommends.";
        Spannable bulletThreeSpannable = new SpannableString(bulletThreeFirst+bulletThreeSecond+bulletThreeThird);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletThreeFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletThreeFirst.length(), bulletThreeFirst.length() + bulletThreeSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletThreeSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletThreeFirst.length() + bulletThreeSecond.length(), bulletThreeFirst.length() + bulletThreeSecond.length() + bulletThreeThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletThreeSpannable);

        /* Fourth bullet point */
        String bulletFourFirst = "• To help during ";
        String bulletFourSecond = "inpatient and outpatient exercise therapy or rehabilitation";
        String bulletFourThird= ": The AHA/ASA recommends activities such as walking 3-5 days per week for 20-60 min/session (or multiple 10-min sessions); stretching 2-3 days per week for 10-30 seconds; Tai chi, yoga, and recreational activities as a complement to walking or stretching.";
        Spannable bulletFourSpannable = new SpannableString(bulletFourFirst+bulletFourSecond+bulletFourThird);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFourFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletFourFirst.length(), bulletFourFirst.length() + bulletFourSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFourSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletFourFirst.length() + bulletFourSecond.length(), bulletFourFirst.length() + bulletFourSecond.length() + bulletFourThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFourSpannable);

        /* Fifth bullet point */
        String bulletFiveFirst = "• To remain ";
        String bulletFiveSecond = "safe during physical exercise";
        String bulletFiveThird= ": Use assistive devices for walking and exercise carefully, only under supervision.";
        Spannable bulletFiveSpannable = new SpannableString(bulletFiveFirst+bulletFiveSecond+bulletFiveThird);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletFiveFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletFiveFirst.length(), bulletFiveFirst.length() + bulletFiveSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletFiveSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletFiveFirst.length() + bulletFiveSecond.length(), bulletFiveFirst.length() + bulletFiveSecond.length() + bulletFiveThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletFiveSpannable);

        /* Sixth bullet point */
        String bulletSixFirst = "• To maintain ";
        String bulletSixSecond = "physical health";
        String bulletSixThird= ": Check with your doctor for customized physical activity preference, specific activity limitations, and exercise participation restrictions.";
        Spannable bulletSixSpannable = new SpannableString(bulletSixFirst+bulletSixSecond+bulletSixThird);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bulletSixFirst.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), bulletSixFirst.length(), bulletSixFirst.length() + bulletSixSecond.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        bulletSixSpannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), bulletSixFirst.length() + bulletSixSecond.length(), bulletSixFirst.length() + bulletSixSecond.length() + bulletSixThird.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(bulletSixSpannable);

        addImageWithURI(R.drawable.yoga);
        addImageWithURI(R.drawable.walking);
    }

    public void setUpDiet() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "It’s important for stroke patients to maintain a healthy lifestyle. Stroke patients residing in long-term care facilities are at risk for calcium and vitamin D deficiencies.";
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String secondPar = "It’s best to eat an overall healthy diet with a variety of fruits and vegetables, whole grains, low-fat dairy products, skinless meat and fish, and nuts and legumes. Cut back on saturated fat, trans fat, sodium, red meat, sweets and sugar-sweetened beverages.";
        spannable = new SpannableString(secondPar);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void setUpBladderBowel() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "Some patients will experience urinary incontinence or retention.";
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String secondPar = "Assess urinary retention through bladder scanning or intermittent catheterizations after voiding, and record volumes. Go to the bathroom at regular times to help train your bladder. Urinating every 2-3 hours can help prevent accidents. Drink plenty of fluids during the day to stay hydrated to help you avoid constipation.";
        spannable = new SpannableString(secondPar);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void setUpHomeMod() {
        addHeaderWithText("PROBLEM");
        addLineBreak();
        /* FIRST PARAGRAPH */
        String firstWord = "Because patients might experience limited mobility, it’s important to modify your home so that it is safe and accessible.";
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText("WHAT TO DO");
        addLineBreak();
        String bedroom = "Bedroom";
        spannable = new SpannableString(bedroom);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bedroom.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bedroomExplanation = "• Bedroom accessibility can be improved by moving items so that the door opens fully; widen doorways; reverse hinges so that door opens outwards instead of inwards. If a bed needs to be up against a wall, it should be oriented such that the patient’s affected side (weak side) is closer to the wall, so the strong side can assist the patient getting out of bed.";
        spannable = new SpannableString(bedroomExplanation);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bedroomExplanation.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.weak_side_bed);

        String general = "General";
        spannable = new SpannableString(general);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, general.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String generalExplanation = "• Eliminate rugs that can easily move to avoid trips and falls.";
        spannable = new SpannableString(generalExplanation);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, generalExplanation.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.slippery_carpet);

        String bath = "Bath";
        spannable = new SpannableString(bath);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Bold.ttf")), 0, bath.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bathExplanationOne = "• Bathrooms can be made more accessible to wheelchairs by widening the doorway.";
        spannable = new SpannableString(bathExplanationOne);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bathExplanationOne.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        String bathExplanationTwo =  "• Toilet seats can be raised to make it less challenging in getting to and from the toilet: a toilet elevator that mounts between the floor and toilet; a seat elevator that attaches to the bowl and raises the seat; installing toilet rails/grab bars to improve support for mobility.";
        spannable = new SpannableString(bathExplanationTwo);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, bathExplanationTwo.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addImageWithURI(R.drawable.grab_bars_new);
    }

    public void setUpFAQ() {
        addHeaderWithText("WHAT IS A STROKE?");
        addLineBreak();
        String firstWord = "In a stroke, the blood supply to a particular part of the brain is blocked or a blood vessel that supplies a part of the brain bursts. This results in cell death in the affected part of the brain. This may result in temporary or permanent loss of function in one or more part(s) of the body.";
        Spannable spannable = new SpannableString(firstWord);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, firstWord.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText("WHAT SHOULD YOU DO IF YOU THINK SOMEONE IS HAVING A STROKE?");
        addLineBreak();
        String word = "Call for professional medical help (doctor or nurse) immediately.";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);

        addHeaderWithText("WHY DO YOU NEED TO ACT QUICKLY?");
        addLineBreak();
        word = "Getting fast medical treatment lowers the risk of disability or even death.";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
    }

    public void setUpRiskFactors() {
        addHeaderWithText("RISK FACTORS FOR A STROKE");
        addLineBreak();
        String word = "• High blood pressure";
        Spannable spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = "• Heart disease";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = "• Smoking";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = "• Diabetes";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
        word = "• Prior stroke";
        spannable = new SpannableString(word);
        spannable.setSpan( new CustomTypefaceSpan("sans-serif",Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf")), 0, word.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        addTextViewWithText(spannable);
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

    /* Adds the given images to the layout. */
    public void addImageWithURI(int imgOne) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        ImageView imageViewOne = new ImageView(this);
        //setting image resource
        imageViewOne.setImageResource(imgOne);
        //setting image position
        imageViewOne.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                800));
        ll.addView(imageViewOne);
    }

}
