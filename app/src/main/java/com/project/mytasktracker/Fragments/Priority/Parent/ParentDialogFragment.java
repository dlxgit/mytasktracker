package com.project.mytasktracker.Fragments.Priority.Parent;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.EditTaskActivity;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewItem;
import com.project.mytasktracker.Fragments.Priority.OnDialogResultListener;
import com.project.mytasktracker.R;

import java.util.ArrayList;


public class ParentDialogFragment extends DialogFragment{
//    public interface OnDialogResultListener {
//        void onDialogResult(EditTaskRecyclerViewItem.ItemType type, int priority);
//    }

    OnDialogResultListener listener;

    ListView listView;
    ParentListViewAdapter adapter;

    TaskItem item;

    public ParentDialogFragment(TaskItem item, OnDialogResultListener listener) {
        this.item = item;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Title");
        View v = inflater.inflate(R.layout.dialogfragment_parent, null);
        //init children of v

        listView = (ListView) v.findViewById(R.id.dialogfragment_parent_listview);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //item.setParent(adapter.items.get(position).getValue());
                dismiss();
                Bundle res = new Bundle();
                ArrayList<String> resData = new ArrayList<String>();
                resData.add(String.valueOf(item.getPriority()));

                res.putStringArrayList("result", resData);

                listener.onDialogResult(EditTaskRecyclerViewItem.ItemType.PARENT, res);
            }
        });
        initAdapter();
        listView.setAdapter(adapter);

        //return super.onCreateView(inflater, container, savedInstanceState);
        return v;
    }

    public void initAdapter() {
        ArrayList<ParentItem> parentItems = new ArrayList<>();
        for(int i = 4; i > 0; --i) {
            parentItems.add(new ParentItem(i));
        }
        adapter = new ParentListViewAdapter(parentItems, this, listView );
    }
}
