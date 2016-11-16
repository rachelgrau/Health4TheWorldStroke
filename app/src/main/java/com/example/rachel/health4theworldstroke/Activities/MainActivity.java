package com.example.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.rachel.health4theworldstroke.R;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.health4theworldstroke.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void helpMeSpeakSelected(View view) {
        Intent intent = new Intent(this, HelpMeSpeakActivity.class);
//        intent.putExtra(EXTRA_MESSAGE, "Help Me Speak!");
        startActivity(intent);
    }

    public void learnSelected(View view) {
        Intent intent = new Intent(this, LearnActivity.class);
        startActivity(intent);
    }

    public void remindersSelected(View view) {
        Intent intent = new Intent(this, RemindersActivity.class);
        startActivity(intent);
    }
}
