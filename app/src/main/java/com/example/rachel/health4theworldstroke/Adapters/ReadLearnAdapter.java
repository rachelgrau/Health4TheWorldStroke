package com.example.rachel.health4theworldstroke.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.rachel.health4theworldstroke.Models.ReadLearnContent;
import com.example.rachel.health4theworldstroke.R;

import java.util.ArrayList;


/**
 * Created by rachel on 11/11/16.
 * Adapter for the ReadLearnContent List View, which displays
 * a list of the different content the user can read.
 */

public class ReadLearnAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private ArrayList<ReadLearnContent> mDataSource;

    public ReadLearnAdapter(Context context, ArrayList<ReadLearnContent> items) {
        mContext = context;
        mDataSource = items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
//        arrowButton.setOnClickListener(new View.OnClickListener()   {
//            public void onClick(View v)  {
//                try {
//                    System.out.println("HERE!");
//                    ((ImageButton)v).setBackgroundResource(R.mipmap.white_arrow);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });

        // Populate view with relevant content
        ReadLearnContent contentItem = (ReadLearnContent) getItem(position);
        titleTextView.setText(contentItem.title);

//        Picasso.with(mContext).load(contentItem.imageUrl).placeholder(R.mipmap.ic_launcher).into(thumbnailImageView);

        return rowView;
    }

}
