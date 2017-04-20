package com.project.mytasktracker.EditTaskRecyclerView;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.R;


public class EditTaskRecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    ImageView imageView;
    TextView header;
    TextView description;
    EditTaskRecyclerViewAdapter adapter;

    EditTaskRecyclerViewItem item;

    public EditTaskRecyclerViewHolder(View itemView, EditTaskRecyclerViewAdapter adapter) {
        super(itemView);
        this.adapter = adapter;

        imageView = (ImageView) itemView.findViewById(R.id.edit_task_activity_recycler_item_image);
        header = (TextView) itemView.findViewById(R.id.edit_task_activity_recycler_item_header);
        description = (TextView) itemView.findViewById(R.id.edit_task_activity_recycler_item_description);
    }

    @Override
    public void onClick(View v) {

    }

    public void bind(EditTaskRecyclerViewItem item) {
        this.imageView.setImageDrawable(item.getImage());
        this.header.setText(item.getHeader());
        this.description.setText(item.getDescription());

        this.item = item;
    }

}
