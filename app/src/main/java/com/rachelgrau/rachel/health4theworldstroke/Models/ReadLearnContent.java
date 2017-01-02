package com.rachelgrau.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/7/16.
 */

public class ReadLearnContent extends LearnContent{
    public String text;

    /* READ TOPICS */
    public static final String RISK_FACTORS = "Risk Factors";
    public static final String BLOOD_PRESSURE = "Blood Pressure";
    public static final String HEART_RATE = "Heart Rate";
    public static final String BLOOD_SUGAR = "Blood Sugar";
    public static final String EXERCISES = "Exercises";
    public static final String DIET = "Diet";
    public static final String SHOWER_BATH = "Shower/bath";
    public static final String BLADDER_BOWEL = "Bladder/bowel";
    public static final String HOME_MODIFICATION = "Home Modification";
    public static final String FAQ = "FAQ";
    public static final String RESOURCES = "Resources";

    public static ArrayList<LearnContent> getReadContent() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        ReadLearnContent riskFactors = new ReadLearnContent(RISK_FACTORS);
        ReadLearnContent bloodPressure = new ReadLearnContent(BLOOD_PRESSURE);
        ReadLearnContent heartRate = new ReadLearnContent(HEART_RATE);
        ReadLearnContent bloodSugar = new ReadLearnContent(BLOOD_SUGAR);
        ReadLearnContent exercises = new ReadLearnContent(EXERCISES);
        ReadLearnContent diet = new ReadLearnContent(DIET);
        ReadLearnContent showerBath = new ReadLearnContent(SHOWER_BATH);
        ReadLearnContent bladderBowel = new ReadLearnContent(BLADDER_BOWEL);
        ReadLearnContent homeMod = new ReadLearnContent(HOME_MODIFICATION);
        ReadLearnContent faq = new ReadLearnContent(FAQ);
        ReadLearnContent resources = new ReadLearnContent(RESOURCES);

        content.add(riskFactors);
        content.add(bloodPressure);
        content.add(heartRate);
        content.add(bloodSugar);
        content.add(exercises);
        content.add(diet);
        content.add(showerBath);
        content.add(bladderBowel);
        content.add(homeMod);
        content.add(faq);
        content.add(resources);

        return content;
    }

    public ReadLearnContent(String title) {
        this.title = title;
    }

}
