package com.example.ivan.joilytree.MainTreeRecyclerView;

import android.util.Log;

import java.util.Date;
import java.util.List;

/**
 * Created by Ivan on 11.09.2017.
 */

public class Task {
    private String taskName;
    private Date taskDeadLine;
    private List<Task> subTasks;

    public Task(){
        this.taskName = "";
        this.taskDeadLine = new Date();
    }

    public Task(String taskName, Date taskDeadLine){
        this.taskName = taskName;
        this.taskDeadLine = taskDeadLine;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getTaskDeadLine() {
        return taskDeadLine;
    }

    public void setTaskDeadLine(Date taskDeadLine) {
        this.taskDeadLine = taskDeadLine;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public Task getSubTasksByIndex(int index){
        try{
            Task subTask = subTasks.get(index);
            return subTask;
        }catch (IndexOutOfBoundsException e){
            Log.d("ErrorTag", "IndexOutOfDoundsException from getTaskByIndex");
            return null;
        }
    }
}
