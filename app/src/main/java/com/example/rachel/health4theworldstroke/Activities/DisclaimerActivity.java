package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

public class DisclaimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        setUpText();
    }

    private String getText() {
        return "This application is to be used as a guide and teaching tool for patients suffering from stroke or heart problems, family members, and health care providers.\n\n" +
                "The instructions herein are based on general and well-accepted guidelines and expert opinions for post stroke care and self-management. Although reasonable efforts have been made to ensure the information contained in these lectures was current and accurate at the time of publication, neither Health4TheWorld, nor any individual who has furnished content or been involved in the presentation of this material, either orally or in writing can guarantee that all information is accurate and valid.\n\n" +
                "Each given situation requires an individual judgment and approach, and this application is intended only for educational purposes, and is not intended to be, and should not be interpreted as, medical advice. Nothing contained in any part of this application, creates or has created or is intended to create, implicitly or explicitly, any manner of patient-physician relationship.\n\n" +
                "The use of this application and its content is at your own risk, and Health4TheWorld, or any individual who has furnished content or been involved in the design or development of the application and its content expressly disclaims any liability for any injury and/or damage to persons and/or property arising from the use of this application.\n\n" +
                "Any usage of this application may be tracked to enable us to monitor usage patterns and progress. All data will be kept anonymous.\n\n" +
                "By clicking Accept, you agree with our Terms of Use and Privacy Policy.";
    }

    private void setUpText() {
        LinearLayout layout = (LinearLayout)findViewById(R.id.text_linear_layout);
        addHeaderWithText("Welcome to Health4TheWorld!");
        addTextViewWithText(getText());
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(60, 60, 60, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(60, 60, 60, 60);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void clickedAccept(View view) {
        finish();
    }
}
