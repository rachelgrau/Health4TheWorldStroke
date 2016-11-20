package com.example.rachel.health4theworldstroke.Models;

import android.content.Context;

import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by rachel on 11/20/16.
 */

public class SpeakObject {
    public String text;
    public String imageName;

    public SpeakObject(String text, String imageName) {
        this.text = text;
        this.imageName = imageName;
    }

    /* Returns an ArrayList of all speak objects */
    public static ArrayList<SpeakObject> getSpeakObjects(Context context) {
        ArrayList<SpeakObject> speakObjects = new ArrayList<SpeakObject>();

        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.yes), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.no), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.thanks), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.bathroom), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.water), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.hungry), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.notgivingup), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.pain), ""));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.cantspeak), ""));

        return speakObjects;
    }
}
