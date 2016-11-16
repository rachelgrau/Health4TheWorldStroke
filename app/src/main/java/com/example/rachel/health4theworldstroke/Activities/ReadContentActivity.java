package com.example.rachel.health4theworldstroke.Activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

public class ReadContentActivity extends AppCompatActivity {
    public String title;
    public String text; // The actual content

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_read_content);

        this.title = this.getIntent().getExtras().getString("title");
        this.text = this.getIntent().getExtras().getString("text");

        System.out.println(this.title);
        TextView titleTextView = (TextView)findViewById(R.id.title_text_view);
        titleTextView.setText(this.title);
    }
}
