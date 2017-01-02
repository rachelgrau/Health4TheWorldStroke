package com.rachelgrau.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.ARMS;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.ARMS_AND_HANDS;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.COORDINATION;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.FUNCTIONAL_MOBILITY;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.LEGS;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.LEGS_AND_FEET;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.MIND_EXERCISES;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S1;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S2;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S3;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S4;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S5;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S6;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S7;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S8;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.S9;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.STRENGTHENING;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.STRETCHING;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U1;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U2;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U3;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U4;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U5;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U6;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U7;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.VideoContentActivity.U8;

/**
 * Created by rachel on 11/7/16.
 */

public class VideoLearnContent extends LearnContent{

    public static ArrayList<LearnContent> getVideoCategories() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        VideoLearnContent strengthening = new VideoLearnContent();
        strengthening.title = STRENGTHENING;

        VideoLearnContent stretching = new VideoLearnContent();
        stretching.title = STRETCHING;

        VideoLearnContent functionalMobility = new VideoLearnContent();
        functionalMobility.title = FUNCTIONAL_MOBILITY;

        VideoLearnContent mindExercises = new VideoLearnContent();
        mindExercises.title = MIND_EXERCISES;

        content.add(strengthening);
        content.add(stretching);
        content.add(functionalMobility);
        content.add(mindExercises);

        return content;
    }

    public static ArrayList<LearnContent> getVideoSubcategories(String mainCategory) {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        if (mainCategory.equals(STRENGTHENING)) {
            VideoLearnContent legs = new VideoLearnContent();
            legs.title = LEGS;

            VideoLearnContent arms = new VideoLearnContent();
            arms.title = ARMS;

            VideoLearnContent coordination = new VideoLearnContent();
            coordination.title = COORDINATION;

            content.add(legs);
            content.add(arms);
            content.add(coordination);
        } else if (mainCategory.equals(STRETCHING)) {
            VideoLearnContent legAndFoot = new VideoLearnContent();
            legAndFoot.title = LEGS_AND_FEET;

            VideoLearnContent armAndHand = new VideoLearnContent();
            armAndHand.title = ARMS_AND_HANDS;

            content.add(legAndFoot);
            content.add(armAndHand);
        } else if (mainCategory.equals(LEGS)) {
            VideoLearnContent u8 = new VideoLearnContent();
            u8.title = U8;
            VideoLearnContent s1 = new VideoLearnContent();
            s1.title = S1;
            VideoLearnContent s2 = new VideoLearnContent();
            s2.title = S2;

            content.add(u8);
            content.add(s1);
            content.add(s2);
        } else if (mainCategory.equals(ARMS)) {
            VideoLearnContent u4 = new VideoLearnContent();
            u4.title = U4;
            VideoLearnContent u7 = new VideoLearnContent();
            u7.title = U7;

            content.add(u4);
            content.add(u7);
        } else if (mainCategory.equals(COORDINATION)) {
            VideoLearnContent u5 = new VideoLearnContent();
            u5.title = U5;
            VideoLearnContent u6 = new VideoLearnContent();
            u6.title = U6;

            content.add(u5);
            content.add(u6);
        } else if (mainCategory.equals(LEGS_AND_FEET)) {
            VideoLearnContent s4 = new VideoLearnContent();
            s4.title = S4;
            VideoLearnContent s7 = new VideoLearnContent();
            s7.title = S7;
            VideoLearnContent s9 = new VideoLearnContent();
            s9.title = S9;

            content.add(s4);
            content.add(s7);
            content.add(s9);
        } else if (mainCategory.equals(ARMS_AND_HANDS)) {
            VideoLearnContent s8 = new VideoLearnContent();
            s8.title = S8;
            VideoLearnContent s5 = new VideoLearnContent();
            s5.title = S5;
            VideoLearnContent s6 = new VideoLearnContent();
            s6.title = S6;

            content.add(s8);
            content.add(s5);
            content.add(s6);
        } else if (mainCategory.equals(FUNCTIONAL_MOBILITY)) {
            System.out.println("Functional mobility");
            VideoLearnContent u1 = new VideoLearnContent();
            u1.title = U1;
            VideoLearnContent u3 = new VideoLearnContent();
            u3.title = U3;
            VideoLearnContent s3 = new VideoLearnContent();
            s3.title = S3;

            content.add(u1);
            content.add(u3);
            content.add(s3);
        }
        return content;
    }

    /* Returns true if |mainCategory| is a category that has subcategories and false otherwise. */
    public static boolean categoryHasSubcategories(String mainCategory) {
        if (mainCategory.equals(STRENGTHENING)) {
            return true;
        } else if (mainCategory.equals(STRETCHING)) {
            return true;
        } else if (mainCategory.equals(LEGS)) {
            return true;
        } else if (mainCategory.equals(ARMS)) {
            return true;
        } else if (mainCategory.equals(COORDINATION)) {
            return true;
        } else if (mainCategory.equals(LEGS_AND_FEET)) {
            return true;
        } else if (mainCategory.equals(ARMS_AND_HANDS)) {
            return true;
        } else if (mainCategory.equals(FUNCTIONAL_MOBILITY)) {
            return true;
        } else {
            return false;
        }
    }

    public static String getInstructionsForVideo(String title) {
        String instructions = "";
        if (title.equals(U1)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U2)) {

        } else if (title.equals(U3)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U4)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U5)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U6)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U7)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(U8)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(S1)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(S2)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(S3)) {
            instructions = "Please repeat 10 times every day with active assistance from caregiver if needed.";
        } else if (title.equals(S4)) {
            instructions = "You can do this exercise lying down or sitting in a stable chair. Lying on your back, slide the affected leg out to the side for 30 seconds and back in. Repeat 3 times.";
        } else if (title.equals(S5)) {
            instructions = "Lie on your side with involved arm resting on hip. Bring shoulder up towards the ear and then gently back down.";
        } else if (title.equals(S6)) {
            instructions = "Lie on your side with the involved side up and arm resting on hip. Gently bring the lower arm towards the leg. Hold for 30 seconds. Repeat 3 times. Make sure that you hold the shoulder and stop it from moving forward.";
        } else if (title.equals(S7)) {
            instructions = "You can do this exercise lying down or sitting in a stable chair. Lie down on your back with your knees bent and straighten the knee upwards towards the sky for 30 seconds.";
        } else if (title.equals(S8)) {
            instructions = "Side lying with the involved side up and arm resting on the hip. Support the elbow on the hip but use your other hand to move the wrist up and away from the stomach. Bring the wrist back to its resting position. Support the wrist with one hand and try to open the fingers with the other hand. Progress to trying to open the hand when the wrist is moved up and away from the stomach. Hold the stretch for 30 seconds. Repeat 3 times.";
        } else if (title.equals(S9)) {
            instructions = "You can do this exercise lying down or sitting in a stable chair. Push the foot upwards towards torso and hold for 30 sec. Repeat 3 times.";
        }

        return instructions;
    }
}
