package com.example.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Activities.RemindersActivity;
import com.example.rachel.health4theworldstroke.Models.Reminder;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by rachel on 11/28/16.
 */

public class RemindersAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private ArrayList<Reminder> mDataSource = new ArrayList<Reminder>();
    private Context mContext;
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();

    private LayoutInflater mInflater;

    public RemindersAdapter(Context context) {
        mContext = context;
        mDataSource = new ArrayList<Reminder>();
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataSource(ArrayList<Reminder> newData) {
        mDataSource = newData;
        this.notifyDataSetChanged();
    }

    public void clearDataSource() {
        mDataSource.clear();
        sectionHeader.clear();
        this.notifyDataSetChanged();
    }

    /* Adds a reminder to the data source by appending it to the end. */
    public void addItem(final Reminder item) {
        mDataSource.add(item);
        notifyDataSetChanged();
    }

    /* Adds a section header to the data source by appending it to the end. */
    public void addSectionHeaderItem(final Reminder item) {
        mDataSource.add(item);
        sectionHeader.add(mDataSource.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return mDataSource.size();
    }

    @Override
    public Reminder getItem(int position) {
        return mDataSource.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();
            switch (rowType) {
                case TYPE_ITEM:
                    Reminder theReminder = mDataSource.get(position);
                    convertView = mInflater.inflate(R.layout.list_item_reminder, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.reminder_title);
                    ImageButton checkButton = (ImageButton) convertView.findViewById(R.id.check_icon);
                    checkButton.setTag(position); // set position
                    checkButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Integer position = (Integer)view.getTag();
                            Reminder r = mDataSource.get(position);
                            boolean isCompleting = !r.isCompleted();
                            if (isCompleting) {
                                /* Completed reminder */
                                view.setBackgroundResource(R.mipmap.check_selected);
                            } else {
                                /* Deselected reminder */
                                view.setBackgroundResource(R.mipmap.check_deselected);
                            }
                            if(mContext instanceof RemindersActivity){
                                ((RemindersActivity)mContext).clickedCheckButton(isCompleting, r);
                            }
                        }
                    });

                    break;
                case TYPE_SEPARATOR:
                    convertView = mInflater.inflate(R.layout.reminder_section_header, null);
                    holder.textView = (TextView) convertView.findViewById(R.id.textSeparator);
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.textView.setText(mDataSource.get(position).getTitle());

        return convertView;
    }

    public static class ViewHolder {
        public TextView textView;
    }


}
