package com.project.mytasktracker.Fragments.Priority.Parent;

import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.project.mytasktracker.R;

import java.util.ArrayList;


public class ParentListViewAdapter extends BaseAdapter{

    ArrayList<ParentItem> items;
    DialogFragment fragment;
    LayoutInflater inflater;

    public ParentListViewAdapter(ArrayList<ParentItem> items, DialogFragment fragment, ListView listView) {
        this.items = items;
        this.fragment = fragment;

        inflater = LayoutInflater.from(fragment.getContext());
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public ParentItem getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null) {
            convertView = inflater.inflate(R.layout.priority_fragment_listview_item, parent, false);
        }
        //convertView = inflater.inflate(R.layout.priority_fragment_listview_item, null);
        TextView textView = (TextView) convertView.findViewById(R.id.priority_fragment_listview_item_textview);
        textView.setText("Priority " + items.get(position).getValue());
        return convertView;
    }
}