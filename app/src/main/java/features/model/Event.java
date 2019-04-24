/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Calendar;
import java.util.GregorianCalendar;

// Event will be an object that holds an event's name, date, and whether user
// will be reminded of this event.
public class Event implements Parcelable {
    String eventName;       // Name of event.
    Calendar eventTime;     // Date of event.
    boolean wantReminder;   // Set reminder?
    
    // Constructor.
    public Event(String name, Calendar time, boolean r) {
        this.eventName = name;
        this.eventTime = time;
        this.wantReminder = r;
    }

    protected Event(Parcel in) {
        eventName = in.readString();
        wantReminder = in.readByte() != 0;

        //**************
        long milliseconds = in.readLong();

        eventTime = new GregorianCalendar();
        eventTime.setTimeInMillis(milliseconds);
    }

    public static final Creator<Event> CREATOR = new Creator<Event>() {
        @Override
        public Event createFromParcel(Parcel in) {
            return new Event(in);
        }

        @Override
        public Event[] newArray(int size) {
            return new Event[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(eventName);
        dest.writeByte((byte) (wantReminder ? 1 : 0));

        //***********
        dest.writeLong(eventTime.getTimeInMillis());
    }
}
