package com.project.mytasktracker.ContentTaskItem;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.mytasktracker.NavigationDrawerActivity;
import com.project.mytasktracker.R;



public class TaskRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
    View container;
    int position;
    NavigationDrawerActivity activity;

    public TaskRecyclerViewHolder(View itemView, Activity activity) {
        super(itemView);
        this.activity = (NavigationDrawerActivity) activity;
        name = (TextView) itemView.findViewById(R.id.content_task_item_text);
        container = (View) itemView.findViewById(R.id.content_task_item_root);
        container.setOnClickListener(this);
    }

    public void bindData(TaskItem taskFolderItem, int position) {
        CharSequence cs = (CharSequence)taskFolderItem.getName();
        name.setText(cs);
        this.position = position;
    }

    @Override
    public void onClick(View view) {
        activity.onTaskSelect(position);
    }
}