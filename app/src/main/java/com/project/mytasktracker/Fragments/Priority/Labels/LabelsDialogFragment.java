package com.project.mytasktracker.Fragments.Priority.Labels;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.project.mytasktracker.ContentTaskItem.TaskItem;
import com.project.mytasktracker.R;


public class LabelsDialogFragment extends DialogFragment {
    public interface OnDialogResultListener {
        void onDialogResult(String labels);
    }

    OnDialogResultListener listener;

    TaskItem item;

    public LabelsDialogFragment(TaskItem item, OnDialogResultListener listener) {
        this.item = item;
        this.listener = listener;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().setTitle("Title");
        View v = inflater.inflate(R.layout.dialogfragment_labels, null);
        //init children of v
        final EditText editText = (EditText) v.findViewById(R.id.dialogfragment_labels_edittext);

        Button cancelBtn = (Button) v.findViewById(R.id.dialogfragment_labels_cancelbtn);
        Button applyBtn = (Button) v.findViewById(R.id.dialogfragment_labels_applybtn);
        cancelBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        applyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
                listener.onDialogResult(editText.getText().toString());
            }
        });
        return v;
    }
}