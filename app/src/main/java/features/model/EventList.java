/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;


import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

// EventList will be a class that stores a list of Events.
public class EventList implements Parcelable {
    
    String listDesc;        // Description of the list of Events.
    List<Event> eventList;      // Declare List of Events called eventList.
    int listSize;               // Number of Events in list.
    
    // Constructor.
    public EventList(String desc) {
        this.listDesc = desc;
        this.eventList = new ArrayList<>();
        this.listSize = 0;
    }

    // Assuming these are correct for Parcelable...
    protected EventList(Parcel in) {
        listDesc = in.readString();
        listSize = in.readInt();
        //*******************
        eventList = in.createTypedArrayList(Event.CREATOR);
    }

    public static final Creator<EventList> CREATOR = new Creator<EventList>() {
        @Override
        public EventList createFromParcel(Parcel in) {
            return new EventList(in);
        }

        @Override
        public EventList[] newArray(int size) {
            return new EventList[size];
        }
    };

    // Getter for listDesc.
    public String getListDesc() {
        return listDesc;
    }
    
    // Getter for eventList.
    public List<Event> getEventList() {
        return eventList;
    }
    
    // Getter for listSize.
    public int getListSize() {
        return listSize;
    }

    // Getter for Event in list by index. This could be useful for retrieving
    // and editing/displaying an Event's information.
    public Event getEventFromList(int i) {
        return eventList.get(i);
    }
    
    // Add an Event to list. Increment listSize.
    public void addEvent(Event e) {
        eventList.add(e);
        listSize++;
    }
    
    //Remove an Event from list by its index. Decrement listSize.
    public void removeEvent(int i) {
        eventList.remove(i);
        listSize--;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(listDesc);
        dest.writeInt(listSize);
    }

    /*
    public List<Event> getThisWeekEvents() {
        List<Event> thisWeek = new ArrayList<>();
        Calendar curWeek = new GregorianCalendar();
        int thisYear = curWeek.get(Calendar.YEAR),
          thisMonth = curWeek.get(Calendar.MONTH);
        int currentWeek = curWeek.get(Calendar.WEEK_OF_MONTH);
        eventList.stream().filter((ev) -> (ev.getTime() != null
                && thisYear == ev.getTime().get(Calendar.YEAR)
                && thisMonth == ev.getTime().get(Calendar.MONTH)
                && currentWeek == ev.getTime().get(Calendar.WEEK_OF_MONTH))).forEachOrdered((ev) -> {
                    thisWeek.add(ev);
        });
        return thisWeek;
    }    
    
    
        public List<Event> getThisMonthEvents(){
        List<Event> thisMonth = new ArrayList<>();
        Calendar curMonth = new GregorianCalendar();
        int thisyear = curMonth.get(Calendar.YEAR),
            month = curMonth.get(Calendar.MONTH);
            events.stream().filter((ev) -> (ev.getTime() != null
                && thisyear == ev.getTime().get(Calendar.YEAR)
                && month == ev.getTime().get(Calendar.MONTH))).forEachOrdered((ev) -> {
                    thisMonth.add(ev);
        });         
        return thisMonth;
    }*/
}
