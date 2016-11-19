package com.example.rachel.health4theworldstroke.Models;

import java.util.ArrayList;

/**
 * Created by rachel on 11/7/16.
 */

public class VideoLearnContent extends LearnContent{

    public static ArrayList<LearnContent> getVideoContent() {
        ArrayList<LearnContent> content = new ArrayList<LearnContent>();

        VideoLearnContent physicalTherapy = new VideoLearnContent();
        physicalTherapy.title = "Physical Therapy Exercises";

        VideoLearnContent occupationalTherapy = new VideoLearnContent();
        occupationalTherapy.title = "Occupational Therapy Exercises";

        VideoLearnContent recreationTherapy = new VideoLearnContent();
        recreationTherapy.title = "Recreation Therapy Exercises";

        VideoLearnContent bloodPressure = new VideoLearnContent();
        bloodPressure.title = "Blood Pressure";

        VideoLearnContent heartRate = new VideoLearnContent();
        heartRate.title = "Heart Rate";

        content.add(physicalTherapy);
        content.add(occupationalTherapy);
        content.add(recreationTherapy);
        content.add(bloodPressure);
        content.add(heartRate);

        return content;
    }
}
