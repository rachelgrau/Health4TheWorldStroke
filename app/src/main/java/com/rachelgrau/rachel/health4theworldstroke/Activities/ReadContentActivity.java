package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
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
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.RESOURCES;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.RISK_FACTORS;
import static com.rachelgrau.rachel.health4theworldstroke.Models.ReadLearnContent.SHOWER_BATH;

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
        if (title.equals(RISK_FACTORS)) {
            setUpRiskFactors();
        } else if (title.equals(HEART_RATE)) {
            setUpHeartRate();
        } else if (title.equals(BLOOD_PRESSURE)) {
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
        } else if (title.equals(RESOURCES)) {
            setUpResources();
        }
    }

    /* DONE */
    public void setUpRiskFactors() {
        addHeaderWithText("Risk Factors for Stroke:");
        addLineBreak();
        addIndentedTextViewWithText("• High blood pressure");
        addIndentedTextViewWithText("• Heart disease");
        addIndentedTextViewWithText("• Smoking");
        addIndentedTextViewWithText("• Diabetes");
        addIndentedTextViewWithText("• Prior stroke");
    }

    /* DONE */
    public void setUpBloodPressure() {
        addTextViewWithText("High blood pressure can cause strokes by damaging arteries throughout the body such that they burst or clog more easily.");
        addHeaderWithText("Goal:");
        addTextViewWithText("In the general population aged 60 years or older, treating high BP to a goal of lower than 150/90 mm Hg reduces stroke.");
    }

    /* DONE */
    public void setUpHeartRate() {
        addTextViewWithText("Atrial Fibrillation, or irregular heart rate, is a risk factor for stroke.");
        addTextViewWithText("If you have suspicion for irregular heart rate, contact your doctor immediately for testing including electrocardiogram (ECG/EKG)");
        addTextViewWithText("Based on past medical history and risk for having a future stroke, there are several options for medications like anticoagulants in order to manage AFib.");
    }

    public void setUpBloodSugar() {
        addTextViewWithText("High blood sugar can increase the risk of developing strokes and heart disease.");
        addTextViewWithText("A blood test called HbA1c gives a picture of your average blood sugar control for the past 2 to 3 months.");
        addSubheaderWithText("Goal:");
        addTextViewWithText("The American Heart Association recommends keeping blood sugar levels (Hgb1A1c) below 6% for patients with pre diabetes and below 7% for diabetic patients.");
    }

    /*DONE*/
    public void setUpExercises() {
        addTextViewWithText("Check with your doctor for customized physical activity preference, specific activity limitations, and exercise participation restrictions.");
        addTextViewWithText("Mobility-task training under supervision of health care professional can help individuals with gait limitations after stroke.");
        addTextViewWithText("Balance training can be done to prevent falls.");
        addTextViewWithText("During hospitalization and early recovery, low-level walking, self care activities, intermittent sitting or standing, seated activities, or range of motion activities has shown to be beneficial.");
        addTextViewWithText("Use assistive devices for walking and exercise carefully only under supervision.");
        addTextViewWithText("During rehabilitation, activities such as walking, stretching, Tai chi, yoga, and recreational activities are options for exercise.");
    }

    /*DONE*/
    public void setUpDiet() {
        addTextViewWithText("Assessment of swallowing before the patient begins eating, drinking, or receiving oral medications is important.");
        addTextViewWithText("Check with your doctor and/or speech-and-swallow therapist regarding your specific dietary needs such as food consistency and eating frequency.");
        addTextViewWithText("Oral hygiene protocols to reduce the risk of aspiration pneumonia after stroke should be implemented.");
        addTextViewWithText("Better to eat an overall healthy diet with fruits and vegetables, whole grains, low-fat dairy products, skinless meat and fish, nuts and legumes. ");
        addTextViewWithText("Cut back on saturated fat, trans fat, sodium, red meat, sweets, and sugar-sweetened beverages.");
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
        addSubheaderWithText("Bedroom:");
        addTextViewWithText("Bedroom accessibility can be improved by moving items so that the door opens fully; widen doorways; reverse hinges so that door opens outwards instead of inwards.");
        addSubheaderWithText("Bath:");
        addTextViewWithText("Bathrooms can be made more accessible to wheelchairs by widening the doorway.");
        addTextViewWithText("Toilet seats can be raised to make it less challenging in getting to and from the toilet: a toilet elevator that mounts between the floor and toilet; a seat elevator that attaches to the bowl and raises the seat; installing toilet rails/grab bars to improve support for mobility.");
        addTextViewWithText("Consider using bathmats with suction cups to avoid slipping. Consider installing grab bars to make movement easier. Make sure someone is nearby to help if you need. Keep a bell handy or have another way to call for help. Take a shower instead of a bath if you can. Showers are generally safer than tubs.");
        addTextViewWithText("Bathrooms can be made more accessible to wheelchairs by widening the doorway. Toilet seats can be raised to make it less challenging in getting to and from the toilet: a toilet elevator that mounts between the floor and toilet; a seat elevator that attaches to the bowl and raises the seat; installing toilet rails/grab bars to improve support for mobility.");
        addSubheaderWithText("General:");
        addTextViewWithText("Avoid Slippery Carpet and Rugs. We suggest removing items such as movable rugs that may cause a person to slip or trip.");

    }

    public void setUpFaq() {
        addSubheaderWithText("What is a stroke?");
        addTextViewWithText("In stroke, the blood supply to a particular part of the brain is blocked or a blood vessel that supplies a part of the brain bursts. This results in cell death in the affected part of the brain.");
        addSubheaderWithText("What are the signs of a stroke?");
        addTextViewWithText("BEFAST");
        addIndentedTextViewWithText("B: Balance: Sudden loss.");
        addIndentedTextViewWithText("E: Eye: Sudden loss of vision in one or both eyes.");
        addIndentedTextViewWithText("F: Face drooping on one side when asked to smile.");
        addIndentedTextViewWithText("A: Arm weakness: can't raise arms & keep them there.");
        addIndentedTextViewWithText("S: Speech difficulty.");
        addIndentedTextViewWithText("T: Time to call an ambulance.");
        addSubheaderWithText("What should you do if you think someone is having a stroke?");
        addTextViewWithText("Call for professional medical help immediately.");
        addSubheaderWithText("Why do you need to act quickly?");
        addTextViewWithText("Getting fast medical treatment lowers the risk of disability or even death.");
    }

    public void setUpResources() {
        addTextViewWithText("2014 Evidence-Based Guideline for the Management of High Blood Pressure in Adults. 2014 JAMA. http://jamanetwork.com/journals/jama/fullarticle/1791497 (Accessed 2016-11-22).");
        addTextViewWithText("American Heart Association. Know your health numbers. http://www.heart.org/HEARTORG/Conditions/More/Diabetes/PreventionTreatofDiabetes/Know-Your-HealthNumbers_UCM_313882_Article.jsp#.WC0TE_k (Accessed Nov 16, 2016).");
        addTextViewWithText("Guidelines for Adult Stroke Rehabilitation and Recovery - A Guideline for Healthcare Professionals From the American Heart Association/American Stroke Association. 2016 Stroke. https://www.aan.com/Guidelines/home/GetGuidelineContent/744");
        addTextViewWithText("Billinger SA et al. Physical activity and exercise recommendations for stroke survivors: a statement for healthcare professionals from the American Heart Association/American Stroke Association. Stroke. 2014;45:2532-2553.");
        addTextViewWithText("American Stroke Association. Life after stroke - Nutrition Tips for Stroke Survivors. http://www.strokeassociation.org/STROKEORG/LifeAfterStroke/HealthyLivingAfterStroke/Nutrition/Nutrition-Tips-for-Stroke-Survivors_UCM_308569_SubHomePage.jsp (Accessed Nov 16, 2016)");
        addTextViewWithText("Guidelines for Adult Stroke Rehabilitation and Recovery - A Guideline for Healthcare Professionals From the American Heart Association/American Stroke Association. 2016 Stroke. https://www.aan.com/Guidelines/home/GetGuidelineContent/74");
        addTextViewWithText("American Stroke Association. Life after stroke - Bathing Tips for Stroke Survivors. http://www.strokeassociation.org/STROKEORG/LifeAfterStroke/RegainingIndependence/TipsForDailyLiving/Bathing-Tips-for-Stroke-Survivors_UCM_310105_Article.jsp#.WC0JYvkrLBU (Accessed Nov 16, 2016)");
        addTextViewWithText("National Stroke Association. Recovery after stroke: bladder and bowel function. http://www.stroke.org/sites/default/files/resources/NSAFactSheet_BowelandBladder_2014.pdf (Accessed Nov 16, 2016)");
        addTextViewWithText("American Heart Association | American Stroke Association. Carol Siebert, MS, OTR/L, FAOTA. The Bathroom: Modify the room to match your abilities. http://www.strokeassociation.org/idc/groups/stroke-public/@wcm/@hcm/@mag/documents/downloadable/ucm_463096.pdf (Accessed Nov 16, 2016)");
        addTextViewWithText("American Heart Association | American Stroke Association. Carol Siebert, MS, OTR/L, FAOTA. Modifications: Modify your bedroom to match your abilities. http://www.strokeassociation.org/idc/groups/stroke-public/@wcm/@hcm/@mag/documents/downloadable/ucm_463057.pdf (Accessed Nov 16, 2016)");
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(40, 40, 40, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addSubheaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setTypeface(Typeface.DEFAULT_BOLD);
        textView.setPadding(40, 10, 40, 0);
        textView.setTextSize(16);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(40, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addIndentedTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(65, 10, 40, 0);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.content);
        View line = new View(this);
        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3));
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGray));
        ll.addView(line);
    }
}