package com.project.mytasktracker;

import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.DialogFragment;
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
import com.project.mytasktracker.Fragments.Priority.Labels.LabelsDialogFragment;
import com.project.mytasktracker.Fragments.Priority.PriorityDialogFragment;

import java.util.ArrayList;


public class EditTaskActivity extends AppCompatActivity implements EditTaskRecyclerViewAdapter.OnListItemSelectCallback, PriorityDialogFragment.OnDialogResultListener, LabelsDialogFragment.OnDialogResultListener {

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

    TaskItem taskitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        taskitem = new TaskItem(getIntent());

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

        items = new ArrayList<>();
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_date_range_black_24dp, getTheme()), "Due date", "today", EditTaskRecyclerViewItem.ItemType.DATE));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_priority_high_black_24dp, getTheme()), "Priority", "default_priority", EditTaskRecyclerViewItem.ItemType.PRIORITY));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_label_outline_black_24dp, getTheme()), "Labels", default_value_labels, EditTaskRecyclerViewItem.ItemType.LABELS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_low_priority_black_24dp, getTheme()), "Parent", default_value_parent, EditTaskRecyclerViewItem.ItemType.PARENT));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_chat_bubble_outline_black_24dp, getTheme()), "Comments", default_value_comments, EditTaskRecyclerViewItem.ItemType.COMMENTS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_photo_library_black_24dp, getTheme()), "Attached photos", default_value_photos, EditTaskRecyclerViewItem.ItemType.PHOTOS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_notifications_none_black_24dp, getTheme()), "Reminders", default_value_reminders, EditTaskRecyclerViewItem.ItemType.REMINDERS));

//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.DATE), "Due date", "today"));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PRIORITY), "Priority", "default_priority"));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.LABELS), "Labels", default_value_labels));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PARENT), "Parent", default_value_parent));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.COMMENTS), "Comments", default_value_comments));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.PHOTOS), "Attached photos", default_value_photos));
//        items.add(new EditTaskRecyclerViewItem(getImageOf(EditTaskRecyclerViewItem.ItemType.REMINDERS), "Reminders", default_value_reminders));

        adapter = new EditTaskRecyclerViewAdapter(items, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        //adapter.notifyItemRangeChanged(0, items.size());
        //TaskItem taskItem = TaskItem.fromIntent(getIntent());

    }

    public void onListItemSelect(EditTaskRecyclerViewItem.ItemType type) {
        switch (type) {
            case DATE:

                break;
            case PRIORITY:
//                Fragment fragment = new PriorityFragment();
//                FragmentManager fm = getSupportFragmentManager();
//                FragmentTransaction ft = fm.beginTransaction();
//                ft.add(R.id.edit_task_activity_root, fragment);
//                ft.commit();
                DialogFragment f1 = new PriorityDialogFragment(taskitem, this);
                f1.show(getSupportFragmentManager(), "dialog-priority");

                break;
            case LABELS:
                DialogFragment f2 = new LabelsDialogFragment(taskitem, this);
                f2.show(getSupportFragmentManager(), "dialog-labels");
                break;
            case PARENT:
                break;
            case COMMENTS:
                break;
            case PHOTOS:
                break;
            case REMINDERS:
                break;
        }
    }

    @Override
    public void call(EditTaskRecyclerViewItem.ItemType type) {
        onListItemSelect(type);
    }

    @Override
    public void onDialogResult(int priority) {
        adapter.getItem(EditTaskRecyclerViewItem.ItemType.PRIORITY).setDescription("Priority " + priority);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDialogResult(String labels) {
        adapter.getItem(EditTaskRecyclerViewItem.ItemType.LABELS).setDescription("Labels: " + labels);
        adapter.notifyDataSetChanged();
    }
}