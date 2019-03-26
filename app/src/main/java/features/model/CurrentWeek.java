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
    Day today, day2, day3, day4, day5, day6, day7; // Days for the week.
    List<Day> currentWeek;     // List to hold Days of the week.
    
    final int MAX_DAYS_IN_WEEK = 7; // Max size of currentWeek list.
    

    // Constructor. This is a little wonky so I will probably have to change this.
    public CurrentWeek() {
        currentWeek = new ArrayList<>();
        
        Calendar c = new GregorianCalendar();
        today = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day2 = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day3 = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day4 = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day5 = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day6 = new Day(c);
        c.roll(Calendar.DAY_OF_MONTH, true);
        day7 = new Day(c);
        
        currentWeek.add(today);
        currentWeek.add(day2);
        currentWeek.add(day3);
        currentWeek.add(day4);
        currentWeek.add(day5);
        currentWeek.add(day6);
        currentWeek.add(day7);
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
