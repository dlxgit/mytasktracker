package com.project.mytasktracker.Fragments.Priority.Parent;

import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.R;

import java.util.ArrayList;


public class ParentListViewAdapter extends BaseAdapter{

    ArrayList<ParentItem> items;
    DialogFragment fragment;
    LayoutInflater inflater;
    //int unselectedItemId; //id of element which we should draw specially (grey) (to show that it can not be selected)

    public ParentListViewAdapter(ArrayList<ParentItem> items, DialogFragment fragment) {
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
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null) {
            convertView = inflater.inflate(R.layout.parent_listview_item, parent, false);
        }
//        if(items.get(position).equals(items.get(unselectedItemId))) {
//            //TODO: HOTFIX WTF IS WRONG
//            convertView.setBackgroundColor(Color.LTGRAY);
//        }
        ParentItem item = items.get(position);
        convertView.setBackgroundColor(item.isSelected() ? Color.LTGRAY : 0);

        //convertView = inflater.inflate(R.layout.priority_fragment_listview_item, null);
        TextView textView = (TextView) convertView.findViewById(R.id.parent_listview_item_text);

        textView.setText(item.getValue());
        return convertView;
    }
}