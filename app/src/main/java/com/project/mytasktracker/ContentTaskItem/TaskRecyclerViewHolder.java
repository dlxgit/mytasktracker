package com.project.mytasktracker.ContentTaskItem;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.mytasktracker.NavigationDrawerActivity;
import com.project.mytasktracker.R;



public class TaskRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    View root;

    TextView name;

    int position;
    TaskRecyclerViewAdapter adapter;
    NavigationDrawerActivity activity;

    public TaskRecyclerViewHolder(View root, Activity activity, TaskRecyclerViewAdapter adapter) {
        super(root);
        this.root = root;
        root.setOnClickListener(this);
        this.adapter = adapter;
        this.activity = (NavigationDrawerActivity) activity;
        name = (TextView) root.findViewById(R.id.content_task_item_text);
    }

    public void bindData(TaskItem taskItem, int position) {
        CharSequence cs = (CharSequence)taskItem.getName();
        name.setText(cs);
        this.position = position;
        root.setBackgroundColor(0);
    }

    public void bindDataWithSelectedStatus(TaskItem taskItem, int position, boolean isSelected) {
        bindData(taskItem, position);

        if(isSelected == false) {
            root.setBackgroundColor(0);
        }
    }

    @Override
    public void onClick(View view) {
        adapter.onItemClick(position);
        activity.onTaskSelect(position);
        root.setBackgroundColor(Color.GREEN);
    }
}