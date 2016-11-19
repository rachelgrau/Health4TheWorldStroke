package com.example.rachel.health4theworldstroke.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

public class VideoContentActivity extends AppCompatActivity {
    public String title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_content);

        this.title = this.getIntent().getExtras().getString("title");

        TextView titleTextView = (TextView)findViewById(R.id.title_text_view);
        titleTextView.setText(this.title);
    }
}
