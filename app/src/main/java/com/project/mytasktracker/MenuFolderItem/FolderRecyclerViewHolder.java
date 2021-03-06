package com.project.mytasktracker.MenuFolderItem;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.project.mytasktracker.NavigationDrawerActivity;
import com.project.mytasktracker.R;


public class FolderRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView name;
    View container;
    int position;
    NavigationDrawerActivity activity;

    public FolderRecyclerViewHolder(View itemView, Activity activity) {
        super(itemView);
        this.activity = (NavigationDrawerActivity) activity;
        name = (TextView) itemView.findViewById(R.id.menu_item_folder_text);
        container = (View) itemView.findViewById(R.id.menu_item_folder_root);
        container.setOnClickListener(this);
    }

    public void bindData(TaskFolderItem taskFolderItem, int position) {
        CharSequence cs = (CharSequence)taskFolderItem.getName();
        name.setText(cs);
        this.position = position;
    }

    @Override
    public void onClick(View view) {

        activity.onFolderSelect(position);
    }
}
