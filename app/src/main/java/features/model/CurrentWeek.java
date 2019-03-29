/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import java.util.*;

/**
 *
 * @author andrea
 */
public class CurrentWeek {
    Day today; // Today's Day.
    List<Day> currentWeek;     // List to hold Days of the week.
    
    final int MAX_DAYS_IN_WEEK = 7; // Max size of currentWeek list.
    

    // Constructor. This is a little wonky so I will probably have to change this.
    public CurrentWeek() {
        currentWeek = new ArrayList<>();
        
        Calendar c = new GregorianCalendar();
        today = new Day(c);
        currentWeek.add(today);
        for (int i = 0; i < 6; i++) {
            c.add(Calendar.DAY_OF_MONTH, 1);
            currentWeek.add(new Day(c));
        }
    }
    
    // Getter for today.
    public Day getToday() {
        return today;
    }
    
    // Getter for currentWeek.
    public List<Day> getCurrentWeek() {
        return currentWeek;
    }
    
    // Add Day to currentWeek.
    public void addDay(Day d) {
        currentWeek.add(d);
    }
    
    // Display Days of currentWeek.
    public void displayDays() {
        for (Day d : currentWeek) {
            System.out.println(d.getDaysDate());
            System.out.println("Number of events: " + d.getDaysEvents().getListSize());
        }
    }
}
