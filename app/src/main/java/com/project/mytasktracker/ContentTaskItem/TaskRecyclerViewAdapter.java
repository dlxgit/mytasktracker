package com.project.mytasktracker.ContentTaskItem;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.R;

import java.util.ArrayList;


public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewHolder> {
    LayoutInflater layoutInflater;
    ArrayList<TaskItem> m_items;
    Activity activity;

    public TaskRecyclerViewAdapter(Activity activity, ArrayList<TaskItem> m_items) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        this.m_items = m_items;
    }

    @Override
    public TaskRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_task_item, parent, false);
        return new TaskRecyclerViewHolder(view, activity);
    }

    @Override
    public void onBindViewHolder(TaskRecyclerViewHolder holder, int position) {
        holder.bindData(m_items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return m_items.size();
    }

    public void add(ArrayList<TaskItem> items) {
        m_items = new ArrayList<>();
        m_items.addAll(items);
    }
}
