package com.project.mytasktracker.DatePicking;

import android.graphics.Bitmap;

import java.util.Date;


public class DateItem {
    Bitmap image;
    String title;

    public Bitmap getImage() {
        return image;
    }

    public void setImage(Bitmap image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public DateItem(Bitmap image, String title) {
        this.image = image;
        this.title = title;
    }


}
