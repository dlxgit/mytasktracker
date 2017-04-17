package com.project.mytasktracker.ContentTaskItem;

import android.content.Intent;

import java.util.ArrayList;
import java.util.Date;


public class TaskItem {
    String name;
    String description;
    boolean isFinished;
    int priority;
    Date deadline;

    ArrayList<String> labels;
    ArrayList<Date> reminders;
    ArrayList<String> photos;

    public TaskItem(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isFinished = false;

        this.deadline = new Date();
        this.photos = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.reminders = new ArrayList<>();
    }

    public Intent toIntent() {
        Intent intent = new Intent();

        intent.putExtra("header", name);
        intent.putExtra("description", description);
        intent.putExtra("date", deadline);
        intent.putExtra("priority", String.valueOf(priority));
        intent.putExtra("labels", labels);
        intent.putExtra("reminders", getRemindersAsStrings());
        intent.putExtra("photos", photos);

        return intent;
    }

    private ArrayList<String> getRemindersAsStrings() {
        ArrayList<String> result = new ArrayList<>();
        for(Date date : reminders) {
            result.add(date.toString());
        }
        return result;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFinished() {
        return isFinished;
    }

    public void setFinished(boolean finished) {
        isFinished = finished;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public Date getDeadline() {
        return deadline;
    }

    public void setDeadline(Date deadline) {
        this.deadline = deadline;
    }

    public ArrayList<String> getLabels() {
        return labels;
    }

    public void setLabels(ArrayList<String> labels) {
        this.labels = labels;
    }

    public ArrayList<Date> getReminders() {
        return reminders;
    }

    public void setReminders(ArrayList<Date> reminders) {
        this.reminders = reminders;
    }
}