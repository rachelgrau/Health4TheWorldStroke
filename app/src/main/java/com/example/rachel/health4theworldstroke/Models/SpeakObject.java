package com.example.rachel.health4theworldstroke.Models;

import android.content.Context;

import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by rachel on 11/20/16.
 */

public class SpeakObject {
    public String text;
    public int imgResource;

    public SpeakObject(String text, int imgResource) {
        this.text = text;
        this.imgResource = imgResource;
    }

    public int getImageResource() {
        return imgResource;
    }

    public String getText() {
        return text;
    }

    /* Returns an ArrayList of all speak objects */
    public static ArrayList<SpeakObject> getSpeakObjects(Context context) {
        ArrayList<SpeakObject> speakObjects = new ArrayList<SpeakObject>();

        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.yes), R.mipmap.yes_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.no), R.mipmap.no_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.thanks), R.mipmap.thanks_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.bathroom), R.mipmap.bathroom_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.water), R.mipmap.water_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.hungry), R.mipmap.food_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.notgivingup), R.mipmap.not_giving_up_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.pain), R.mipmap.pain_icon));
        speakObjects.add(new SpeakObject(context.getResources().getString(R.string.cantspeak), R.mipmap.cant_speak_icon));

        return speakObjects;
    }
}
