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
    private ArrayList<Integer> selectedItemPositions;

    Activity activity;

    boolean isSelectionMode = false;

    public TaskRecyclerViewAdapter(Activity activity, ArrayList<TaskItem> m_items) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        this.m_items = m_items;
        selectedItemPositions = new ArrayList<>();
    }

    @Override
    public TaskRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.content_task_item, parent, false);
        return new TaskRecyclerViewHolder(view, activity, this);
    }

    @Override
    public void onBindViewHolder(TaskRecyclerViewHolder holder, int position) {
        //if(isSelectionMode) {
        holder.bindData(m_items.get(position), position);
        //}
        //else {
        //    holder.bindData(m_items.get(position), position);
        //}
    }

    @Override
    public int getItemCount() {
        return m_items.size();
    }

    public void add(ArrayList<TaskItem> items) {
        m_items = new ArrayList<>();
        m_items.addAll(items);
    }

    public void setSelectionMode(boolean selectionMode) {
        isSelectionMode = selectionMode;
        if(!isSelectionMode) {
            resetSelected();
            //notifyAllChanged();
        }
        else {
            //notifyAllChanged();
        }
    }

    public void notifyAllChanged() {
        notifyItemRangeChanged(0, m_items.size());
    }

    public void onItemClick(TaskRecyclerViewHolder holder, int position) {
        manipulateDependingOnSelection(holder, position);
    }

    private void resetSelected() {
        for(int i = 0; i < selectedItemPositions.size(); ++i) {
            int position = selectedItemPositions.get(i);
            TaskItem item = m_items.get(position);
            //item.isItemSelected = false;
            notifyItemChanged(position);
        }
        selectedItemPositions.clear();
    }

    private void changeSelectingStatus(int position, boolean status) {
        TaskItem item = m_items.get(position);
        //item.isItemSelected = status
    }

    public boolean isItemSelected(int position) {
        return selectedItemPositions.contains(position);
    }

    //calling from Holder
    private void manipulateDependingOnSelection(TaskRecyclerViewHolder holder, int itemPosition) {
        boolean newStatus;
        if(isItemSelected(itemPosition)) {
            newStatus = false;

            //int taskIndex = selectedItemPositions.get(new Integer(itemPosition));
            selectedItemPositions.remove(new Integer((itemPosition))); //remove itemIndex from selected
        }
        else {
            newStatus = true;

            selectedItemPositions.add(itemPosition);
        }

        holder.changeItemSelectionStatus(newStatus);
    }
}
