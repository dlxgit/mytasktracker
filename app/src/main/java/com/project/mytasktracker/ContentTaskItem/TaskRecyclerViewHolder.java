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
    View container;
    int position;
    NavigationDrawerActivity activity;

    public TaskRecyclerViewHolder(View root, Activity activity) {
        super(root);
        this.root = root;
        this.activity = (NavigationDrawerActivity) activity;
        name = (TextView) root.findViewById(R.id.content_task_item_text);
        container = (View) root.findViewById(R.id.content_task_item_root);
        container.setOnClickListener(this);
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
        activity.onTaskSelect(position);
        root.setBackgroundColor(Color.GREEN);
    }
}