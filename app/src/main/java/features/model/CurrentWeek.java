/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;

/**
 *
 * @author andrea
 */
public class CurrentWeek implements Parcelable {
    Day today; // Today's Day.
    List<Day> currentWeek;     // List to hold Days of the week.
    
    //final int MAX_DAYS_IN_WEEK = 7; // Max size of currentWeek list.
    

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

    protected CurrentWeek(Parcel in) {
        //Does anything need to go in here?
    }

    public static final Creator<CurrentWeek> CREATOR = new Creator<CurrentWeek>() {
        @Override
        public CurrentWeek createFromParcel(Parcel in) {
            return new CurrentWeek(in);
        }

        @Override
        public CurrentWeek[] newArray(int size) {
            return new CurrentWeek[size];
        }
    };

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

    // Get Day in Week
    public Day getDayInWeek(int i) {
       return currentWeek.get(i);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
    }
}
