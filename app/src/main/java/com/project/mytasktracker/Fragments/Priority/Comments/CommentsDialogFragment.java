package com.project.mytasktracker.Fragments.Priority.Comments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.Fragments.Priority.OnDialogResultListener;
import com.project.mytasktracker.R;


public class CommentsDialogFragment extends DialogFragment {

    TaskItem item;
    OnDialogResultListener listener;

    public CommentsDialogFragment(TaskItem item, OnDialogResultListener listener) {
        this.item = item;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialogfragment_comments, null);


        return v;
    }
}
