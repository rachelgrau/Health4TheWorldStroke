package com.example.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Models.LearnContent;
import com.example.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;


/**
 * Created by rachel on 11/11/16.
 * Adapter for the LearnContent List View (in LearnActivity) which displays
 * a list of the different content the user can read or videos they can watch.
 */

public class LearnContentAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<LearnContent> mDataSource;

    public LearnContentAdapter(Context context, ArrayList<LearnContent> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public void setDataSource(ArrayList<LearnContent> newData) {
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
        View rowView = mInflater.inflate(R.layout.list_item_learn_content, parent, false);
        TextView titleTextView =
                (TextView) rowView.findViewById(com.example.rachel.health4theworldstroke.R.id.learn_content_title);
        ImageButton arrowButton = (ImageButton) rowView.findViewById(R.id.pink_arrow);
        ImageView icon = (ImageView) rowView.findViewById(R.id.content_icon);

        // Populate view with relevant content
        LearnContent contentItem = (LearnContent) getItem(position);
        titleTextView.setText(contentItem.title);
        if (contentItem instanceof ReadLearnContent) {
            /* Read icon */
//            icon.setImageResource(R.mipmap.book_icon);
        } else {
            /* Video image*/
            icon.setImageResource(R.mipmap.video_icon);
        }

//        Picasso.with(mContext).load(contentItem.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }

}
