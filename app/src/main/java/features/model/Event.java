/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Event will be an object that holds an event's name, date, and whether user
// will be reminded of this event.
public class Event {
    String eventName;       // Name of event.
    Calendar eventTime;     // Date of event.
    boolean wantReminder;   // Set reminder?
    
    // Constructor.
    public Event(String name, Calendar time, boolean r) {
        this.eventName = name;
        this.eventTime = time;
        this.wantReminder = r;
    }
    
    // Getter for eventName.
    public String getEventName() {
        return eventName;
    }
    
    // Getter for eventTime.
    public Calendar getEventTime() {
        return eventTime;
    }
    
    // Getter for wantReminder.
    public boolean getWantReminder() {
        return wantReminder;
    }
  
}
