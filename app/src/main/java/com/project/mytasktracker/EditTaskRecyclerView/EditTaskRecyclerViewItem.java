package com.project.mytasktracker.EditTaskRecyclerView;


import android.support.graphics.drawable.VectorDrawableCompat;

public class EditTaskRecyclerViewItem {

    public enum ItemType {
        DATE,
        PRIORITY,
        LABELS,
        PARENT,
        COMMENTS,
        PHOTOS,
        REMINDERS,
    }

    VectorDrawableCompat image;
    String header;
    String description;

    public EditTaskRecyclerViewItem(VectorDrawableCompat image, String header, String description) {
        this.image = image;
        this.header = header;
        this.description = description;
    }

    public VectorDrawableCompat getImage() {
        return image;
    }

    public void setImage(VectorDrawableCompat image) {
        this.image = image;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
