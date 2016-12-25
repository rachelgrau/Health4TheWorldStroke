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

import com.example.rachel.health4theworldstroke.Adapters.InfoListAdapter;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;

public class InfoListActivity extends AppCompatActivity {
    public static final String EXTRA_INFO_TYPE = "infoType";
    public static final String INFO_TYPE_ABOUT_US = "About Us";
    public static final String INFO_TYPE_TERMS = "Terms & Conditions";
    public static final String INFO_TYPE_PRIVACY_POLICY = "Privacy Policy";
    public static final String INFO_TYPE_COPYRIGHT = "Copyright";

    private ListView listView; // list of read or video content, depending which tab is selected
    private InfoListAdapter adapter;
    private ArrayList<String> content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_list);
        setUpToolbar();
        setUpListView();
    }

    /* Sets up the top toolbar. */
    private void setUpToolbar() {
        Toolbar myToolbar = (Toolbar) findViewById(R.id.info_list_toolbar);
        myToolbar.setTitle("");
        Typeface font = Typeface.createFromAsset(getAssets(), "Roboto-Light.ttf");
        TextView toolbarTitle = (TextView) myToolbar.findViewById(R.id.toolbar_title);
        toolbarTitle.setText(R.string.info_title);
        toolbarTitle.setTypeface(font);
        setSupportActionBar(myToolbar);
    }

    private void setUpListView() {
        content = new ArrayList<String>();
        content.add(INFO_TYPE_ABOUT_US);
        content.add(INFO_TYPE_TERMS);
        content.add(INFO_TYPE_PRIVACY_POLICY);

        /* Populate list view with read content to start */
        listView = (ListView)findViewById(R.id.info_list_view);
        adapter = new InfoListAdapter(this, content);
        listView.setAdapter(adapter);

        /* Set up callback for when an item in the list is selected. */
        final Context context = this;
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)  {
                /* Transition to content activity */
                String infoType = content.get(position);
                System.out.println("GO TO: " + infoType);
                Intent infoIntent = new Intent(context, InfoActivity.class);
                infoIntent.putExtra(EXTRA_INFO_TYPE, infoType);
                startActivity(infoIntent);
            }
        });
    }
}
