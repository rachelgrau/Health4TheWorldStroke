package com.example.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/7/16.
 */

public class ReadLearnContent extends LearnContent{
    public String text;

    public static ArrayList<LearnContent> getReadContent() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        ReadLearnContent bloodPressure = new ReadLearnContent();
        bloodPressure.title = "Blood Pressure";

        ReadLearnContent heartRate = new ReadLearnContent();
        heartRate.title = "Heart Rate/Exercise";

        ReadLearnContent diet = new ReadLearnContent();
        diet.title = "Diet";

        ReadLearnContent bath = new ReadLearnContent();
        bath.title = "Bath";

        ReadLearnContent bladderBowel = new ReadLearnContent();
        bladderBowel.title = "Bladder/bowel";

        ReadLearnContent homeMod = new ReadLearnContent();
        homeMod.title = "Home Modification";

        ReadLearnContent bloodSugar = new ReadLearnContent();
        bloodSugar.title = "Blood Sugar";

        ReadLearnContent faq = new ReadLearnContent();
        faq.title = "FAQ";

        content.add(bloodPressure);
        content.add(heartRate);
        content.add(diet);
        content.add(bath);
        content.add(bladderBowel);
        content.add(homeMod);
        content.add(bloodSugar);
        content.add(faq);

        return content;
    }


}
