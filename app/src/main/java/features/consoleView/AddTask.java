/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.consoleView;

import consoleKit.MenuItem;
import features.model.AllTasks;
import features.model.Task;
import java.util.Scanner;


public class AddTask implements MenuItem{
    
    private Task newTask;
    private AllTasks list;
    
    public AddTask(AllTasks list) {
        this.list = list;
    }
    
    public void execute(){   
        newTask = new Task(setTaskName(), this.setTaskDesc());
        list.addTask(newTask);
    }
    
    public String setTaskName() {
        System.out.println("Set Task Name: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        
        return input;
    }
    
    public String setTaskDesc() {
        System.out.println("Set Task Description: ");
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        
        return input;
    }
    
    // Description of this command
    @Override
    public String toString() {
        return "Add Task";
    } 
}
