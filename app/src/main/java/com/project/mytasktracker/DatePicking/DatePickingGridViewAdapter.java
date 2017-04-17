package com.project.mytasktracker.DatePicking;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.project.mytasktracker.R;

import java.util.ArrayList;

/**
 * Created by Andrey on 13.04.2017.
 */

public class DatePickingGridViewAdapter extends BaseAdapter {
    ArrayList<DateItem> m_items;
    LayoutInflater inflater;
    Context context;

    public DatePickingGridViewAdapter(ArrayList<DateItem> items, Context context) {
        super();
        m_items = items;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        this.context = context;
    }

    @Override
    public int getCount() {
        return m_items.size();
    }

    @Override
    public Object getItem(int i) {
        return m_items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ImageView imageView;
        TextView textView;
        if(view == null) {
            //inflater.inflate(R.layout.date_settings_layout_item, viewGroup, false);
            imageView = new ImageView(context);
        }
        else {
            DateItem item = m_items.get(i);
            imageView = (ImageView) view.findViewById(R.id.date_settings_layout_item_image);
            textView = (TextView) view.findViewById(R.id.date_settings_layout_item_text);

            //TODO: change soon
            //imageView.setImageResource(R.mipmap.ic_date_range);
            //Bitmap img = item.getImage();
            //imageView.setImageBitmap(img);
            //textView.setText(item.getTitle());
        }
        return view;
    }
}