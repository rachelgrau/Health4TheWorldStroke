package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;

import com.rachelgrau.rachel.health4theworldstroke.Models.ReminderTime;
import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by rachel on 12/3/16.
 */

public class ReminderTimesAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ReminderTime> mDataSource;

    public ReminderTimesAdapter(Context context, ArrayList<ReminderTime> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataSource(ArrayList<ReminderTime> newData) {
        mDataSource = newData;
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get views for this row item
        View rowView = mInflater.inflate(R.layout.list_item_reminder_time, parent, false);
        ReminderTime time = (ReminderTime)getItem(position);
        EditText timeTextView = (EditText) rowView.findViewById(R.id.time_text);
        timeTextView.setText(time.getTimeString());
        ImageButton timeButton = (ImageButton)rowView.findViewById(R.id.time_button);
        if (position < (mDataSource.size() - 1)) {
            /* If it's not the last element, the button should be a remove button. */
            timeButton.setBackgroundResource(R.mipmap.remove_button);
        }
        timeButton.setTag(position);
        return rowView;
    }
}
