package com.project.mytasktracker.ContentTaskItem;

import android.content.Intent;
import android.os.Bundle;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.ExecutionException;


public class TaskItem {
    String name;
    String description;
    boolean isFinished;
    int priority;
    Date deadline;

    ArrayList<String> labels;
    ArrayList<Date> reminders;
    ArrayList<String> photos;

    public TaskItem() {
        this.name = new String();
        this.description = new String();
        this.deadline = new Date();
        this.labels = new ArrayList<>();
        this.reminders = new ArrayList<>();
        this.photos = new ArrayList<>();
    }

    public TaskItem(String name, String description, int priority) {
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.isFinished = false;

        this.deadline = new Date(1,1,1);
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

    public TaskItem(Intent intent) {

        Bundle extras = intent.getExtras();

        if (extras.containsKey("header")) {

            Date date = new Date();
            DateFormat format = new SimpleDateFormat("MMMM d, yyyy", Locale.ENGLISH);
            //try {
                String strr = intent.getStringExtra("date");
                //this.deadline = format.parse(str);
                this.deadline = new Date(222222);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//            }
//            catch (){
//
//            }

            try {
                ArrayList<String> strings = new ArrayList<>();
                this.reminders = new ArrayList<>();
                strings = intent.getStringArrayListExtra("reminders");
                for(String str : strings) {
                    this.reminders.add(format.parse(str));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }

            ArrayList<String> strings = new ArrayList<>();
            this.reminders = new ArrayList<>();
            this.labels = intent.getStringArrayListExtra("labels");

            //this.photos = intent.getStringExtra("photos");
        }

        this.name = intent.getStringExtra("header");
        this.description = intent.getStringExtra("description");
        this.priority = Integer.parseInt(intent.getStringExtra("priority"));

        this.deadline = new Date();
        this.photos = new ArrayList<>();
        this.labels = new ArrayList<>();
        this.reminders = new ArrayList<>();
    }


    private ArrayList<String> getRemindersAsStrings() {
        ArrayList<String> result = new ArrayList<>();
        for(Date date : reminders) {
            result.add(date.toString());
        }
        return result;
    }

    public ArrayList<String> getPhotos() {
        return photos;
    }

    public void setPhotos(ArrayList<String> photos) {
        this.photos = photos;
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