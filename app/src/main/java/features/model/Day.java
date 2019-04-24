/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.*;
import java.lang.*;

// Day will hold a Calendar, EventList and string that describes its date.
public class Day implements Parcelable {
    Calendar day;           // Day's Calendar.
    EventList daysEvents;   // Day's EventList.
    String daysDate;        // Day's date.
    
    // Constructor.
    public Day(Calendar c) {
        this.day = c;
        setDaysDate();
        this.daysEvents = new EventList("Events on " + daysDate);
    }

    // Assuming these are correct for Parcelable...
    protected Day(Parcel in) {
        daysEvents = in.readParcelable(EventList.class.getClassLoader());
        daysDate = in.readString();
    }

    public static final Creator<Day> CREATOR = new Creator<Day>() {
        @Override
        public Day createFromParcel(Parcel in) {
            return new Day(in);
        }

        @Override
        public Day[] newArray(int size) {
            return new Day[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(daysEvents, flags);
        dest.writeString(daysDate);
    }
}
