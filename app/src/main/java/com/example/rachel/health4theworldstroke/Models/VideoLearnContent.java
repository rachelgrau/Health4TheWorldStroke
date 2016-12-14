package com.example.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/7/16.
 */

public class VideoLearnContent extends LearnContent{

    public static ArrayList<LearnContent> getVideoCategories() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        VideoLearnContent strengthening = new VideoLearnContent();
        strengthening.title = "Strengthening";

        VideoLearnContent stretching = new VideoLearnContent();
        stretching.title = "Stretching";

        VideoLearnContent functionalMobility = new VideoLearnContent();
        functionalMobility.title = "Functional Mobility";

        VideoLearnContent mindExercises = new VideoLearnContent();
        mindExercises.title = "Mind Exercises";

        content.add(strengthening);
        content.add(stretching);
        content.add(functionalMobility);
        content.add(mindExercises);

        return content;
    }

    public static ArrayList<LearnContent> getVideoSubcategories(String mainCategory) {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        if (mainCategory.equals("Strengthening")) {
            VideoLearnContent legs = new VideoLearnContent();
            legs.title = "Legs";

            VideoLearnContent arms = new VideoLearnContent();
            arms.title = "Arms";

            VideoLearnContent coordination = new VideoLearnContent();
            coordination.title = "Coordination";

            content.add(legs);
            content.add(arms);
            content.add(coordination);
        } else if (mainCategory.equals("Stretching")) {
            VideoLearnContent legAndFoot = new VideoLearnContent();
            legAndFoot.title = "Leg and foot";

            VideoLearnContent armAndHand = new VideoLearnContent();
            armAndHand.title = "Arm and hand";

            content.add(legAndFoot);
            content.add(armAndHand);
        }
        return content;
    }

    /* Returns true if |mainCategory| is a category that has subcategories and false otherwise. */
    public static boolean categoryHasSubcategories(String mainCategory) {
        if (mainCategory.equals("Strengthening")) {
            return true;
        } else if (mainCategory.equals("Stretching")) {
            return true;
        } else {
            return false;
        }
    }
}
