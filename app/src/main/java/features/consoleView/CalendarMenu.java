
package features.consoleView;

import consoleKit.MenuItem;
import features.model.EventList;
import consoleKit.*;
import features.model.CurrentWeek;


 public class CalendarMenu implements MenuItem{
    
    private MenuStack menus;
    
    CurrentWeek thisWeek;   // CurrentWeek.****
    
    public CalendarMenu(MenuStack menus, CurrentWeek thisWeek){
        this.menus = menus;
        this.thisWeek = thisWeek;
    }
    
    public void execute(){
        Menu calendarSubMenu = new Menu("Calendar Submenu", menus);
        calendarSubMenu.add(new DisplayWeek(thisWeek));
        calendarSubMenu.add(new DisplayEvents(thisWeek));
        calendarSubMenu.add(new AddEvent(thisWeek));
        calendarSubMenu.add(new ReturnFromMenu("Main Menu", menus));
    }
    
    
    // Description of this command
    @Override
    public String toString() {
        return "Calendar";
    } 
}

