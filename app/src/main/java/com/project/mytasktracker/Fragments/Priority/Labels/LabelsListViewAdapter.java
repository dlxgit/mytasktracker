package com.project.mytasktracker.Fragments.Priority.Labels;

import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.project.mytasktracker.R;

import java.util.ArrayList;


public class LabelsListViewAdapter extends BaseAdapter {
    ArrayList<LabelItem> items;
    LayoutInflater inflater;


    public LabelsListViewAdapter(ArrayList<LabelItem> items, Fragment fragment) {
        this.items = items;
        inflater = LayoutInflater.from(fragment.getContext());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.label_listview_item, null);
        }

        return convertView;
    }
}
