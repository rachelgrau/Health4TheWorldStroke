package com.example.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Models.SpeakObject;

import java.util.ArrayList;

/* Created by rachel on 11/11/16.
 * Adapter for the Grid View in HelpMeSpeakActivity which displays icons
 * that the user can click on to be read out loud.
 */


public class SpeakAdapter extends BaseAdapter {
    private final Context mContext;
    private final ArrayList<SpeakObject> speakObjects;

    public SpeakAdapter(Context context, ArrayList<SpeakObject> speakObjects) {
        this.mContext = context;
        this.speakObjects = speakObjects;
    }

    @Override
    public int getCount() {
        return speakObjects.size();
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        SpeakObject obj = speakObjects.get(position);

        TextView dummyTextView = new TextView(mContext);
        dummyTextView.setText(obj.text);
        return dummyTextView;
    }
}
