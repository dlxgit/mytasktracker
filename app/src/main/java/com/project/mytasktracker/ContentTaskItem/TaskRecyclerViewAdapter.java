package com.project.mytasktracker.ContentTaskItem;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.NavigationDrawerActivity;
import com.project.mytasktracker.R;

import java.util.ArrayList;


public class TaskRecyclerViewAdapter extends RecyclerView.Adapter<TaskRecyclerViewHolder> {
    LayoutInflater layoutInflater;
    ArrayList<TaskItem> m_items;
    private ArrayList<Integer> selectedItemPositions;

    NavigationDrawerActivity activity;

    boolean isRebindingPosition = false;

    public TaskRecyclerViewAdapter(Activity activity, ArrayList<TaskItem> m_items) {
        this.activity = (NavigationDrawerActivity) activity;
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

        if(!isRebindingPosition) {
            holder.bindData(m_items.get(position), position);
        }
        else {
            holder.bindPosition(position);
        }
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
        if(!selectionMode) {
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
        //activity.onTaskSelect(position);
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
        //changing status

        boolean isSelected = !isItemSelected(itemPosition);
        holder.changeItemSelectionStatus(isSelected); //oldStatus

        if(isSelected) {
            selectedItemPositions.add(itemPosition);
            if(selectedItemPositions.size() == 1) {
                activity.onSelectionModeBegin();
            }
        }
        else {
            selectedItemPositions.remove(new Integer((itemPosition))); //remove itemIndex from selected
            if(selectedItemPositions.isEmpty()) {
                activity.onSelectionModeEnd();
                return;
            }
        }
    }

    public boolean isSelectedListEmpty() {
        return selectedItemPositions.isEmpty();
    }

    public void doMarkAsDoneSelected() {
        deleteAllSelected();
    }
    public void doEditSelected() {

    }
    public void doEditDateSelected() {

    }
    public void doEditCommentSelected() {

    }
    public void doEditReminder() {

    }

    private void deleteSelectedItem(int position) { //position = index of element in selectedItemsList
        int indexOfItem = selectedItemPositions.remove(position);
        m_items.remove(indexOfItem);
        notifyItemRemoved(indexOfItem);
        //notifyItemRangeChanged(position,);
    }

    private void deleteAllSelected() {
        this.isRebindingPosition = true;
        for(;!selectedItemPositions.isEmpty();) {
            deleteSelectedItem(0);
        }
        this.isRebindingPosition = false;
    }
}