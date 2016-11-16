package com.example.rachel.health4theworldstroke.Activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Adapters.ReadLearnAdapter;
import com.example.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class LearnActivity extends AppCompatActivity {

    private ListView readListView; // list of read content
    private ListView videosListView; // list of video content

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn);
        setUpToolbar();
        setUpListView();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.learn_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        readListView = (ListView)findViewById(R.id.learn_content_list_view);
        final ArrayList<ReadLearnContent> learnContent = ReadLearnContent.getReadContent();
        ReadLearnAdapter adapter = new ReadLearnAdapter(this, learnContent);
        readListView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        readListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                ReadLearnContent selectedRecipe = learnContent.get(position);
                Intent readIntent = new Intent(context, ReadContentActivity.class);
                readIntent.putExtra("title", selectedRecipe.title);
//        detailIntent.putExtra("url", selectedRecipe.instructionUrl);
                startActivity(readIntent);
            }
        });
    }


}
