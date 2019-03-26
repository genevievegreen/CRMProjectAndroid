/*
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 
package features.model;

import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author abbypetersen
 
public class AllEvents {
    private static final int NO_CHOICE = -1;
    private final List<EventList> allevs;
    private int chosenList;

    // Initialize events to empty list
    public AllEvents() {
        allevs = new ArrayList<>();
        chosenList = NO_CHOICE;    // no list chosen
    }

    // Add a new list of reminders at the end
    public void addType(String name) {
        allevs.add(new EventList(name));
    }
    
    // Getter for the lists
    public List<EventList> getTypes() {
        return allevs;
    }

    // set the "current" list
    public void setFocus(int index) {
        chosenList = index;
    }

    // Add an event to the "current" list
    public void addEvent(Event ev) {
        //allevs.get(chosenList).add(ev);
    }

    //get all events for this week, needs to be changed to display weeks reminders for one category and months reminders for the other
    public List<Event> getWeek() {
        List<Event> result = new ArrayList<>();
        for (EventList evList: allevs)
            result.addAll(evList.getThisWeekEvents());
        return result;
    }

    public EventList getType(int chosenList) {
        return allevs.get(chosenList);
    }
}

*/
