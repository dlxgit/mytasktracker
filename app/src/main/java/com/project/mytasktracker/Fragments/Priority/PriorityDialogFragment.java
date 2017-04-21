package com.project.mytasktracker.Fragments.Priority;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.project.mytasktracker.R;

import java.util.ArrayList;

/**
 * Created by Andrey on 21.04.2017.
 */

public class PriorityDialogFragment extends DialogFragment {
    ListView listView;
    PriorityListViewAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Title");
        View v = inflater.inflate(R.layout.fragment_priority, null);
        //init children of v

        listView = (ListView) v.findViewById(R.id.priority_fragment_listview);
        initAdapter();
        listView.setAdapter(adapter);

        //return super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }

    public void initAdapter() {
        ArrayList<PriorityItem> priorityItems = new ArrayList<>();
        for(int i = 4; i > 0; --i) {
            priorityItems.add(new PriorityItem(i));
        }
        adapter = new PriorityListViewAdapter(priorityItems, this, listView );
    }
}
