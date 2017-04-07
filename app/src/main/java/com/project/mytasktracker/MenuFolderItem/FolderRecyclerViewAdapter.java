package com.project.mytasktracker.MenuFolderItem;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.R;

import java.util.ArrayList;


public class FolderRecyclerViewAdapter extends RecyclerView.Adapter<FolderRecyclerViewHolder> {
    LayoutInflater layoutInflater;
    ArrayList<TaskFolderItem> m_items;
    Activity activity;

    public FolderRecyclerViewAdapter(Activity activity, ArrayList<TaskFolderItem> m_items) {
        this.activity = activity;
        layoutInflater = LayoutInflater.from(activity);
        this.m_items = m_items;
    }

    @Override
    public FolderRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.menu_item_folder,parent,false);
        return new FolderRecyclerViewHolder(view, activity);
    }

    @Override
    public void onBindViewHolder(FolderRecyclerViewHolder holder, int position) {
        holder.bindData(m_items.get(position), position);
    }

    @Override
    public int getItemCount() {
        return m_items.size();
    }

    public void add(ArrayList<TaskFolderItem> items) {
        m_items = new ArrayList<>();
        m_items.addAll(items);
    }
}