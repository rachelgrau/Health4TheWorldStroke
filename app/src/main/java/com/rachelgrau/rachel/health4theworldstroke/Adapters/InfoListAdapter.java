package com.rachelgrau.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.rachelgrau.rachel.health4theworldstroke.R;

import java.util.ArrayList;

/**
 * Created by rachel on 12/24/16.
 */

public class InfoListAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<String> mDataSource;

    public InfoListAdapter(Context context, ArrayList<String> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataSource(ArrayList<String> newData) {
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
        View rowView = mInflater.inflate(R.layout.list_item_info, parent, false);
        TextView titleTextView = (TextView) rowView.findViewById(R.id.info_item_title);
        titleTextView.setText((String)getItem(position));
        return rowView;
    }
}
