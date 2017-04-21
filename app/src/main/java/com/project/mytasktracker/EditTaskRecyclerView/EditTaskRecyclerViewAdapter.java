package com.project.mytasktracker.EditTaskRecyclerView;


import android.support.v4.app.DialogFragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.Callback;
import com.project.mytasktracker.ContentTaskItem.TaskRecyclerViewHolder;
import com.project.mytasktracker.EditTaskActivity;
import com.project.mytasktracker.Fragments.Priority.PriorityDialogFragment;
import com.project.mytasktracker.R;

import java.util.ArrayList;

public class EditTaskRecyclerViewAdapter extends RecyclerView.Adapter<EditTaskRecyclerViewHolder> {

    ArrayList<EditTaskRecyclerViewItem> m_items;
    OnListItemSelectCallback onSelectItemCallBack;


    public EditTaskRecyclerViewAdapter(ArrayList<EditTaskRecyclerViewItem> items, OnListItemSelectCallback onSelectItemCallBack) {
        this.m_items = items;
        this.onSelectItemCallBack = onSelectItemCallBack;
    }

    @Override
    public EditTaskRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.edit_task_activity_recycler_layout, parent, false);
        return new EditTaskRecyclerViewHolder(view, this);
    }

    @Override
    public void onBindViewHolder(EditTaskRecyclerViewHolder holder, int position) {
        holder.bind(m_items.get(position));
    }

    @Override
    public int getItemCount() {
        return m_items.size();
    }

    public interface OnListItemSelectCallback{
        void call(EditTaskRecyclerViewItem.ItemType type);
    }


    public EditTaskRecyclerViewItem getItem(EditTaskRecyclerViewItem.ItemType type) {
        switch (type) {
            case DATE:
                return m_items.get(0);
            case PRIORITY:
                return m_items.get(1);
            case LABELS:
                return m_items.get(2);
            case PARENT:
                return m_items.get(3);
            case COMMENTS:
                return m_items.get(4);
            case PHOTOS:
                return m_items.get(5);
            default:
                return m_items.get(6);
        }
    }
}
