/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import java.util.*;
import java.lang.*;

// Day will hold a Calendar, EventList and string that describes its date.
public class Day {
    Calendar day;           // Day's Calendar.
    EventList daysEvents;   // Day's EventList.
    String daysDate;        // Day's date.
    
    // Constructor.
    public Day(Calendar c) {
        this.day = c;
        this.daysDate = day.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + day.get(Calendar.DAY_OF_MONTH)
                + ", " + day.get(Calendar.YEAR);
        this.daysEvents = new EventList("Events on " + daysDate);
    }
    
    // Getter for day.
    public Calendar getDay() {
        return day;
    }
    
    // Getter for daysEvents.
    public EventList getDaysEvents() {
        return daysEvents;
    }
    
    // Getter for daysDate.
    public String getDaysDate() {
        return daysDate;
    }
    
    // Setter for daysDate string. Should be called whenever daysDate is modified.
    public void setDaysDate() {
        daysDate = day.getDisplayName(Calendar.MONTH, Calendar.LONG, Locale.US) + " " + day.get(Calendar.DAY_OF_MONTH)
         + ", " + day.get(Calendar.YEAR);
    }
    
}
