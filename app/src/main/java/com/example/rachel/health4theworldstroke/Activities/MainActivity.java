package com.example.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Activities.LearnActivity.EXTRA_PAGE_TYPE;
import static com.example.rachel.health4theworldstroke.Activities.LearnActivity.PAGE_TYPE_READ;
import static com.example.rachel.health4theworldstroke.Activities.LearnActivity.PAGE_TYPE_VIDEO;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.health4theworldstroke.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /* If it's the first time they're using the app, show them the terms page and wait for them to accept. */
    @Override
    public void onResume() {
        super.onResume();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean previouslyStarted = prefs.getBoolean(getString(R.string.pref_previously_started), false);
        if(!previouslyStarted) {
            SharedPreferences.Editor edit = prefs.edit();
            edit.putBoolean(getString(R.string.pref_previously_started), Boolean.TRUE);
            edit.commit();
            showDisclaimer();
        }
    }

    private void fakeFirstAppOpening() {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        SharedPreferences.Editor edit = prefs.edit();
        edit.putBoolean(getString(R.string.pref_previously_started), Boolean.FALSE);
        edit.commit();
    }

    public void showDisclaimer() {
        Intent intent = new Intent(this, DisclaimerActivity.class);
        startActivity(intent);
    }


    public void helpMeSpeakSelected(View view) {
        Intent intent = new Intent(this, HelpMeSpeakActivity.class);
        startActivity(intent);
    }

    public void videoSelected(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_VIDEO);
        startActivity(intent);
    }

    public void readSelected(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        intent.putExtra(EXTRA_PAGE_TYPE, PAGE_TYPE_READ);
        startActivity(intent);
    }

    public void remindersSelected(View view) {
        Intent intent = new Intent(this, RemindersActivity.class);
        startActivity(intent);
    }

    public void infoClicked(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        startActivity(intent);
    }
}
