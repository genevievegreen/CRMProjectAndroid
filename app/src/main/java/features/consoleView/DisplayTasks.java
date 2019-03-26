/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.consoleView;

import consoleKit.MenuItem;
import features.model.AllTasks;


public class DisplayTasks implements MenuItem {

    private AllTasks list;
    
    public DisplayTasks(AllTasks list) {
        this.list = list;
    }
    
    public void execute(){
        System.out.println("Displaying tasks...");
        
        list.viewList();
    } 
    
    // Description of this command
    @Override
    public String toString() {
        return "Display Tasks";
    }
}
