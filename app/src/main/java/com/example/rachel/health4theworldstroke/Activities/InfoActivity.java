package com.example.rachel.health4theworldstroke.Activities;

import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.R;

import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.EXTRA_INFO_TYPE;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_ABOUT_US;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_COPYRIGHT;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_PRIVACY_POLICY;
import static com.example.rachel.health4theworldstroke.Activities.InfoListActivity.INFO_TYPE_TERMS;

public class InfoActivity extends AppCompatActivity {
    private String title = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
        this.title = this.getIntent().getExtras().getString(EXTRA_INFO_TYPE);
        setUpToolbar();
        setUpText();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.info_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(this.title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpText() {
        if (this.title.equals(INFO_TYPE_ABOUT_US)) {
            setUpAboutUs();
        } else if (this.title.equals(INFO_TYPE_TERMS)) {
            setUpTerms();
        } else if (this.title.equals(INFO_TYPE_PRIVACY_POLICY)) {
            setUpPrivacyPolicy();
        } else if (this.title.equals(INFO_TYPE_COPYRIGHT)) {
            setUpCopyright();
        }
    }

    public void addHeaderWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView textView = new TextView(this);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(text);
        textView.setPadding(40, 40, 40, 10);
        textView.setTextSize(20);
        textView.setBackgroundColor(Color.WHITE);
        ll.addView(textView);
    }

    public void addTextViewWithText(String text) {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        TextView secondPar = new TextView(this);
        secondPar.setText(text);
        secondPar.setPadding(40, 40, 40, 40);
        secondPar.setTextSize(14);
        secondPar.setBackgroundColor(Color.WHITE);
        ll.addView(secondPar);
    }

    public void addLineBreak() {
        LinearLayout ll = (LinearLayout) findViewById(R.id.text_linear_layout);
        View line = new View(this);
        line.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 3));
        line.setBackgroundColor(ContextCompat.getColor(this, R.color.darkGray));
        ll.addView(line);
    }

    public void setUpAboutUs() {

    }

    public void setUpTerms() {

    }

    public void setUpPrivacyPolicy() {
        addHeaderWithText("Purpose");
        addLineBreak();
        addTextViewWithText("heyyy");

        addHeaderWithText("What Information this Privacy Policy Covers");
        addLineBreak();
        addTextViewWithText("yoooo");

        addHeaderWithText("What You Consent to by Using Our Website");
        addLineBreak();
        addTextViewWithText("yo.");

        addHeaderWithText("What Information We Collect");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("How We Use the Information");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("External Links");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("Confidentiality & Security of Personal Information");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("Updating or Deleting Your Personal Information");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("California Privacy Rights");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("International Privacy Practices");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("Changing Our Privacy Policy");
        addLineBreak();
        addTextViewWithText("hey");

        addHeaderWithText("No Information from Children Under 13");
        addLineBreak();
        addTextViewWithText("hey");
    }

    public void setUpCopyright() {

    }
}
