package com.project.mytasktracker.Fragments.Priority.Photos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.Fragments.Priority.OnDialogResultListener;
import com.project.mytasktracker.R;

/**
 * Created by Andrey on 24.04.2017.
 */

public class PhotosDialogFragment extends DialogFragment {
    TaskItem item;
    OnDialogResultListener listener;

    public PhotosDialogFragment(TaskItem item, OnDialogResultListener listener) {
        this.item = item;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialogfragment_photos, null);
        return v;
    }
}
