package com.project.mytasktracker.Fragments.Priority.Parent;


public class ParentItem {
    String name;
    boolean isSelected = false;

    public ParentItem(String value) {
        this.name = value;
    }

    public String getValue() {
        return name;
    }

    public void setSelected(boolean flag) {
        this.isSelected = flag;
    }

    public boolean isSelected() {
        return isSelected;
    }
}
