
package features.consoleView;

import consoleKit.Menu;
import consoleKit.MenuStack;
import consoleKit.QuitCMD;
import features.model.AllContacts;
import features.model.AllTasks;
import features.model.CurrentWeek;
import features.consoleView.*;


public class FeatureAppMain {
    public static void main(String[] args) {
        MenuStack menus = new MenuStack();
        
        //calendar stuff
        CurrentWeek thisWeek = new CurrentWeek();   // Initialize CurrentWeek list?
        //
        
        //junk for Tasks
        AllTasks tasklist = new AllTasks();
        //
        
        //contacts stuff
        AllContacts contactslist = new AllContacts();
        //
        
        Menu mainMenu = new Menu("Main Menu", menus);
        mainMenu.add(new QuitCMD());
        mainMenu.add(new CalendarMenu(menus, thisWeek));    // need to pass thisWeek?
        mainMenu.add(new TasksMenu(menus, tasklist));
        mainMenu.add(new ContactsMenu(menus, contactslist));
        
    
        
        
        System.out.println("Customer Relations Management");
        while (true)
            menus.run();
        
    }
    
}
