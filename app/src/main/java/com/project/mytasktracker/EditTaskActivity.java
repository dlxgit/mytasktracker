package com.project.mytasktracker;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class EditTaskActivity extends AppCompatActivity {
    String default_value_labels = "No label";
    String default_value_parent = "No parent";
    String default_value_comments = "No comments";
    String default_value_photos = "No photos";
    String default_value_reminders = "No reminders";

    FloatingActionButton fab;

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


    }


}
