package com.project.mytasktracker.Fragments.Priority;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewItem;
import com.project.mytasktracker.R;

import java.util.ArrayList;



public class PriorityDialogFragment extends DialogFragment{
//    public interface OnDialogResultListener {
//        void onDialogResult(EditTaskRecyclerViewItem.ItemType type, int priority);
//    }

    OnDialogResultListener listener;

    ListView listView;
    PriorityListViewAdapter adapter;

    TaskItem item;

    public PriorityDialogFragment(TaskItem item, OnDialogResultListener listener) {
        this.item = item;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Title");
        View v = inflater.inflate(R.layout.fragment_priority, null);
        //init children of v

        listView = (ListView) v.findViewById(R.id.priority_fragment_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                item.setPriority(adapter.items.get(position).getValue());
                dismiss();

                Bundle res = new Bundle();
                ArrayList<String> resData = new ArrayList<String>();
                resData.add(String.valueOf(item.getPriority()));

                res.putStringArrayList("result", resData);
                listener.onDialogResult(EditTaskRecyclerViewItem.ItemType.PRIORITY, res);
            }
        });
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
