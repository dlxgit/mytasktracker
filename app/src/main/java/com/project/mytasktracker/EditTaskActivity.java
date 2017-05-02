package com.project.mytasktracker;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.graphics.drawable.VectorDrawableCompat;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewAdapter;
import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewItem;
import com.project.mytasktracker.Fragments.Priority.Comments.CommentsDialogFragment;
import com.project.mytasktracker.Fragments.Priority.Labels.LabelsDialogFragment;
import com.project.mytasktracker.Fragments.Priority.OnDialogResultListener;
import com.project.mytasktracker.Fragments.Priority.Parent.ParentDialogFragment;
import com.project.mytasktracker.Fragments.Priority.Photos.PhotosDialogFragment;
import com.project.mytasktracker.Fragments.Priority.PriorityDialogFragment;
import com.project.mytasktracker.Fragments.Priority.Reminders.RemindersDialogFragment;

import java.util.ArrayList;


public class EditTaskActivity extends AppCompatActivity implements EditTaskRecyclerViewAdapter.OnListItemSelectCallback, OnDialogResultListener {

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

    ArrayList<TaskItem> allItems;
    TaskItem taskitem;

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_task);

        Toolbar toolbar = (Toolbar) findViewById(R.id.edit_task_activity_toolbar);
//        setSActionBar(toolbar);
//        getSupportActionBar().setTitle("Edit task");


        Bundle extras = getIntent().getExtras();
        int indexFolder = extras.getInt("selected_folder_id");
        int indexItem = extras.getInt("selected_item_id");
        allItems = MyApplication.getInstance().getTaskStorage().getCurrentData(indexFolder);
        taskitem = allItems.get(indexItem);

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
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_date_range_black_24dp, getTheme()), "Due date", "today", EditTaskRecyclerViewItem.ItemType.DATE));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_priority_high_black_24dp, getTheme()), "Priority", "default_priority", EditTaskRecyclerViewItem.ItemType.PRIORITY));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_label_outline_black_24dp, getTheme()), "Labels", default_value_labels, EditTaskRecyclerViewItem.ItemType.LABELS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_low_priority_black_24dp, getTheme()), "Parent", default_value_parent, EditTaskRecyclerViewItem.ItemType.PARENT));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_chat_bubble_outline_black_24dp, getTheme()), "Comments", default_value_comments, EditTaskRecyclerViewItem.ItemType.COMMENTS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_photo_library_black_24dp, getTheme()), "Attached photos", default_value_photos, EditTaskRecyclerViewItem.ItemType.PHOTOS));
        items.add(new EditTaskRecyclerViewItem(VectorDrawableCompat.create(this.getResources(), R.drawable.ic_vec_notifications_none_black_24dp, getTheme()), "Reminders", default_value_reminders, EditTaskRecyclerViewItem.ItemType.REMINDERS));

        adapter = new EditTaskRecyclerViewAdapter(items, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void onListItemSelect(EditTaskRecyclerViewItem.ItemType type) {
        switch (type) {
            case DATE:

                break;
            case PRIORITY:
                DialogFragment f2 = new PriorityDialogFragment(taskitem, this);
                f2.show(getSupportFragmentManager(), "dialog-priority");
                break;
            case LABELS:
                DialogFragment f3 = new LabelsDialogFragment(taskitem, this);
                f3.show(getSupportFragmentManager(), "dialog-labels");
                break;
            case PARENT:
                DialogFragment f4 = new ParentDialogFragment(taskitem, this);
                f4.show(getSupportFragmentManager(), "dialog-parent");
                break;
            case COMMENTS:
                DialogFragment f5 = new CommentsDialogFragment(taskitem, this);
                f5.show(getSupportFragmentManager(), "dialog-comments");
                break;
            case PHOTOS:
                DialogFragment f6 = new PhotosDialogFragment(taskitem, this);
                f6.show(getSupportFragmentManager(), "dialog-photos");
                break;
            case REMINDERS:
                DialogFragment f7 = new RemindersDialogFragment(taskitem, this);
                f7.show(getSupportFragmentManager(), "dialog-remidners");
                break;
        }
    }

    @Override
    public void call(EditTaskRecyclerViewItem.ItemType type) {
        onListItemSelect(type);
    }

    @Override
    public void onDialogResult(EditTaskRecyclerViewItem.ItemType type, Bundle bundle) {
        ArrayList<String> data = bundle.getStringArrayList("result");

        switch (type) {
            case DATE:

                break;
            case PRIORITY:
                adapter.getItem(EditTaskRecyclerViewItem.ItemType.PRIORITY).setDescription("Priority " + data.get(0));
                adapter.notifyDataSetChanged();
                break;
            case LABELS:
                adapter.getItem(EditTaskRecyclerViewItem.ItemType.LABELS).setDescription("Labels: " + data.get(0));
                adapter.notifyDataSetChanged();
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

}