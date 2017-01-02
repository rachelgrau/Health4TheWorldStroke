package com.rachelgrau.rachel.health4theworldstroke.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import static com.rachelgrau.rachel.health4theworldstroke.Activities.InfoListActivity.EXTRA_INFO_TYPE;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_PRIVACY_POLICY;
import static com.rachelgrau.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_TERMS;

public class DisclaimerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disclaimer);
        setUpText();
    }

    private String getText() {
        String p1 = "Although this application is to be used as an educational tool for stroke patients, nothing contained in any part of this application, creates, has created, or is intended to create, implicitly or explicitly, any manner of patient-physician relationship.\n\n";
        String p2 = "The instructions herein are based on general and well-accepted guidelines and expert opinions for post-stroke care and self-management. Although reasonable efforts have been made to ensure the information contained in these lectures was current and accurate at the time of publication, neither Health4TheWorld, nor any individual who has furnished content or been involved in the presentation of this material, either orally or in writing can guarantee that all information is accurate and valid.\n\n";
        String p3 = "Each given situation requires an individual judgment and approach, and this application is intended only for educational purposes, and is not intended to be, and should not be interpreted as, medical advice.\n\n";
        String p4 = "The use of this application and its content is at your own risk, and Health4TheWorld, or any individual who has furnished content or been involved in the design or development of the application and its content expressly disclaims any liability for any injury and/or damage to persons and/or property arising from the use of this application. \n\n";
        String p5 = "Any usage of this application may be tracked to enable us to monitor usage patterns and progress.\n\n";
        String p6 = "By clicking Accept, you agree with our Terms of Use and Privacy Policy.";
        return p1 + p2 + p3 + p4 + p5 + p6;
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

    public void clickedTerms(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_INFO_TYPE, INFO_TYPE_TERMS);
        startActivity(intent);
    }

    public void clickedPrivacy(View view) {
        Intent intent = new Intent(this, InfoActivity.class);
        intent.putExtra(EXTRA_INFO_TYPE, INFO_TYPE_PRIVACY_POLICY);
        startActivity(intent);
    }

    public void clickedAccept(View view) {
        finish();
    }
}
