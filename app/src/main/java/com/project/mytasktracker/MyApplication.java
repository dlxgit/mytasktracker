package com.project.mytasktracker;

import android.app.Application;
import android.content.Intent;

import com.project.mytasktracker.MenuFolderItem.TaskFolderItem;

import java.util.ArrayList;
import java.util.HashMap;


public class MyApplication extends Application {
    private static MyApplication instance;
    private static TaskStorage taskStorage;

    public static MyApplication getInstance() {
        return instance;
    }

    public TaskStorage getTaskStorage() {
        return taskStorage;
    }

    @Override
    public void onCreate() {
        super.onCreate();

        ArrayList<String> strList = new ArrayList<>();
        for(int i = 0; i < 5; ++i) {
            strList.add( new TaskFolderItem("header" + i).getName());
        }

        taskStorage = new TaskStorage(strList);
        instance = this;
    }
}
