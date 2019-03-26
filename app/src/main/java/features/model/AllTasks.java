/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import java.util.ArrayList;
import java.util.List;


public class AllTasks {
    //private static final int NO_CHOICE = -1;
    private final List<Task> list;
    private int chosenList;

    // Initialize contacts to empty list
    public AllTasks() {
        list = new ArrayList<>();

    }
    
      // set the "current" list
    public void setFocus(int index) {
        chosenList = index;
    }
    
    //gets for certain tasks
    public Task getFirstTask() {
        return list.get(0);
    }
    
    public Task getTask(int index) {
        return list.get(index);
    }
    
    public Task getLastTask() {
        return list.get(list.size() - 1);
    }

    // Add a task to the "current" list
    public void addTask(Task task) {
        list.add(task);
    }
    
    public int getListSize() {
        return list.size();
    }
    
    public void viewList() {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(i + ". ");
            list.get(i).viewTask();
        }
    }
        
}
