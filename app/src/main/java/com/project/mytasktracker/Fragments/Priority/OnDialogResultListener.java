package com.project.mytasktracker.Fragments.Priority;

import android.os.Bundle;

import com.project.mytasktracker.EditTaskRecyclerView.EditTaskRecyclerViewItem;


public interface OnDialogResultListener {
    void onDialogResult(EditTaskRecyclerViewItem.ItemType type, Bundle data);
}
