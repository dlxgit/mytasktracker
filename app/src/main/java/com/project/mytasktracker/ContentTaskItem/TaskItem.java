package com.project.mytasktracker.ContentTaskItem;

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

    public TaskItem(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isFinished = false;

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