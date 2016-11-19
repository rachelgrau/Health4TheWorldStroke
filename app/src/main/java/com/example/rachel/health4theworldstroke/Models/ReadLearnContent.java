package com.example.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/7/16.
 */

public class ReadLearnContent extends LearnContent{
    public String text;

    public static ArrayList<LearnContent> getReadContent() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        ReadLearnContent aboutStrokes = new ReadLearnContent();
        aboutStrokes.title = "About Strokes";

        ReadLearnContent nutrition = new ReadLearnContent();
        nutrition.title = "Nutrition";

        ReadLearnContent heartRate = new ReadLearnContent();
        heartRate.title = "Heart Rate";

        ReadLearnContent homeModification = new ReadLearnContent();
        homeModification.title = "Home Modification";

        content.add(aboutStrokes);
        content.add(nutrition);
        content.add(heartRate);
        content.add(homeModification);

        return content;
    }


}
