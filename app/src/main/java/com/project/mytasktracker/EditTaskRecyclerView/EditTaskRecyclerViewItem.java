package com.project.mytasktracker.EditTaskRecyclerView;


import android.app.Activity;
import android.content.res.Resources;
import android.support.graphics.drawable.VectorDrawableCompat;

import com.project.mytasktracker.R;

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

    public ItemType getType() {
        return type;
    }

    public void setType(ItemType type) {
        this.type = type;
    }

    ItemType type;

    public EditTaskRecyclerViewItem(ItemType itemType, Activity activity) {
        Resources resources = activity.getResources();
        Resources.Theme theme = activity.getTheme();

        switch (itemType) {
            case DATE:
                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_date_range_black_24dp, theme);
                break;
            case PRIORITY:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_priority_high_black_24dp, theme);
                break;
            case LABELS:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_label_outline_black_24dp, theme);
                break;
            case PARENT:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_low_priority_black_24dp, theme);
                break;
            case COMMENTS:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_chat_bubble_outline_black_24dp, theme);
                break;
            case PHOTOS:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_photo_library_black_24dp, theme);
                break;
            case REMINDERS:

                this.image = VectorDrawableCompat.create(resources, R.drawable.ic_vec_notifications_none_black_24dp, theme);
                break;


        }
    }

    public EditTaskRecyclerViewItem(VectorDrawableCompat image, String header, String description, ItemType type) {
        this.header = header;
        this.description = description;
        this.image = image;
        this.type = type;
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
