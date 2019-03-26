/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.consoleView;

import consoleKit.Menu;
import consoleKit.MenuItem;
import consoleKit.MenuStack;
import consoleKit.ReturnFromMenu;
import features.model.AllTasks;

/**
 *
 * @author abbypetersen
 */
public class TasksMenu implements MenuItem{
    
    private MenuStack menus;
    private AllTasks list;
    
    public TasksMenu(MenuStack menus, AllTasks list) {
        this.menus = menus;   
        this.list = list;
    }

    
     public void execute(){
        Menu taskSubMenu = new Menu("Task Submenu", menus);
        
        taskSubMenu.add(new DisplayTasks(list));
        taskSubMenu.add(new AddTask(list));
        taskSubMenu.add(new ReturnFromMenu("Main Menu", menus));
        
        
        
    }
   
    // Description of this command
    @Override
    public String toString() {
        return "Task Menu";
    }
}
