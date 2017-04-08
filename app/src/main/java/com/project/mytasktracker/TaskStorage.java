package com.project.mytasktracker;

import com.project.mytasktracker.ContentTaskItem.TaskItem;

import java.util.ArrayList;
import java.util.HashMap;



public class TaskStorage {
    HashMap<String, ArrayList<TaskItem>> hashMap;

    public TaskStorage(ArrayList<String> folders) {
        hashMap = new HashMap<String, ArrayList<TaskItem>>();
        ArrayList<TaskItem> taskItems = new ArrayList<>();

        //testInit
        for(int i = 0; i < 10; ++i) {
            taskItems.add(new TaskItem("Name" + i, "Description" + i, 1));
        }

        for(String folder:folders) {
            ArrayList<TaskItem> newItems = new ArrayList<>();
            for(TaskItem taskItm:taskItems) {
                TaskItem newItem = new TaskItem(taskItm.getName(), taskItm.getDescription(), taskItm.getPriority());
                newItem.setName(folder + "_" + taskItm.getName());
                newItems.add(newItem);
            }

            hashMap.put(folder, newItems);

            //после вставки ^ происходит наращивание в taskItems (при каждой новой итерации - наращивается один и тот же name!!
        }

        //
        //init from json?
    }

    public void moveTasks(String oldKey, ArrayList<Integer> ids, String newKey) {
        //if not exist newKey - create new?
        ArrayList<TaskItem> found = (ArrayList<TaskItem>) hashMap.get(oldKey);

        if(found == null) {

            return;
        }

        ArrayList<TaskItem> whatToMove = deleteTasks(oldKey, ids);

        hashMap.put(oldKey, found); //update old key's value(remove moving elements)

        ArrayList<TaskItem> wheretoMove = (ArrayList<TaskItem>) hashMap.get(newKey);
        wheretoMove.addAll(whatToMove);
        hashMap.put(newKey, wheretoMove); //update new key's elements(put elements)
    }

    public ArrayList<TaskItem> deleteTasks(String key, ArrayList<Integer> ids) {
        ArrayList<TaskItem> deletedTaskItems = new ArrayList<>();
        ArrayList<TaskItem> sourceCollection = (ArrayList) hashMap.get(key);

        if(sourceCollection == null) {
            return deletedTaskItems;
        }

        for(Integer id:ids){
            TaskItem needle = sourceCollection.remove(id.intValue());
            deletedTaskItems.add(needle);
        }
        return deletedTaskItems;
    }


    public ArrayList<TaskItem> findTasks(String key, String pattern) {
        ArrayList<TaskItem> result = new ArrayList<>();
        ArrayList<TaskItem> source = (ArrayList) hashMap.get(key);

        for(TaskItem t:source) {
            if(t.getName().startsWith(pattern)) {
                result.add(t);
            }
        }

        return result;
    }

    private void sort(String key) {
        //comparator?(many) collection?
    }

    public ArrayList<TaskItem> getCurrentData(String key) {
        Object res =  hashMap.get(key);
        return (ArrayList<TaskItem>) res;
    }



}