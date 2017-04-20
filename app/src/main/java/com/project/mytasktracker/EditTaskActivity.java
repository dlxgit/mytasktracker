package com.project.mytasktracker;

import android.graphics.BitmapFactory;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewAdapter;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewItem;

import java.util.ArrayList;

public class EditTaskActivity extends AppCompatActivity {
    String default_value_labels = "No label";
    String default_value_parent = "No parent";
    String default_value_comments = "No comments";
    String default_value_photos = "No photos";
    String default_value_reminders = "No reminders";

    FloatingActionButton fab;
    EditText editTextTask;
    TextView textViewProjectName;

    RecyclerView recyclerView;
    EditTaskRecyclerViewAdapter adapter;

    ArrayList<EditTaskRecyclerViewItem> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        fab = (FloatingActionButton) findViewById(R.id.edit_task_activity_fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: implement
                setResult(RESULT_OK);
                finish();
            }
        });

        editTextTask = (EditText) findViewById(R.id.edit_task_activity_toolbar_edittext);
        textViewProjectName = (TextView) findViewById(R.id.edit_task_activity_toolbar_project_name);
        textViewProjectName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO: add impl (dialog for selecting folder)
            }
        });

        recyclerView = (RecyclerView) findViewById(R.id.edit_task_activity_recyclerview);

        items = new ArrayList<>();
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.DATE), "Due date", "today"));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PRIORITY), "Priority", "default_priority"));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.LABELS), "Labels", default_value_labels));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PARENT), "Parent", default_value_parent));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.COMMENTS), "Comments", default_value_comments));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PHOTOS), "Attached photos", default_value_photos));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.REMINDERS), "Reminders", default_value_reminders));
        
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.DATE), "Due date", "today"));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PRIORITY), "Priority", "default_priority"));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.LABELS), "Labels", default_value_labels));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PARENT), "Parent", default_value_parent));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.COMMENTS), "Comments", default_value_comments));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PHOTOS), "Attached photos", default_value_photos));
        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.REMINDERS), "Reminders", default_value_reminders));

        adapter = new EditTaskRecyclerViewAdapter(items);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //adapter.notifyItemRangeChanged(0, items.size());
        //TaskItem taskItem = TaskItem.fromIntent(getIntent());
    }


}