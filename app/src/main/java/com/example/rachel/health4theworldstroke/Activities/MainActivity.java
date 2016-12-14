package com.example.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.os.Bundle;
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
}
