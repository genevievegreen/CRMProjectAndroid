
package features.consoleView;
import consoleKit.*;
import features.model.*;

public class DisplayWeek implements MenuItem {
    
    CurrentWeek thisWeek;
    
    public DisplayWeek(CurrentWeek thisWeek) {
        this.thisWeek = thisWeek;
    }
    
    // Display dates and number of events in that Day's EventList.
    public void execute(){
        thisWeek.displayDays();
    }
    
    // Description of this command
    @Override
    public String toString() {
        return "This Week's Events";
    } 
}
