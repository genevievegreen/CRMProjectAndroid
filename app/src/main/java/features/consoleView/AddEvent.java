/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.consoleView;
import consoleKit.*;

import features.model.*;
import java.util.Calendar;
import java.util.Scanner;

public class AddEvent implements MenuItem {
    
    CurrentWeek thisWeek;
    int dayChoice;

    
    public AddEvent(CurrentWeek thisWeek) {
        this.thisWeek = thisWeek;
    }
    
    public void execute(){
        // ADDING EVENT WILL DSPLAY DAYS OF WEEK, ASK FOR CHOICE OF WHICH DAY TO ADD EVENT TO, GET THAT DAY'S INFO AND PASS INFO TO EVENT TO ADD, ADD EVENT TO THAT DAY's EVENTLIST
        // DISPLAY THE DAYS, GET THE CHOICE, ADD NEW EVENT WITH THE INFO TO THE LIST
        displayWeek();
        setDayChoice();
        Day d = thisWeek.getCurrentWeek().get(dayChoice);
        Calendar c = d.getDay();
        Event newEvent = new Event(setEventName(), c, setWantReminder());
        d.getDaysEvents().addEvent(newEvent);
        dayChoice = -1;
    }
    
    public void setDayChoice() {
        dayChoice = -1;
        do {
            System.out.println("Choose day to add event: ");
            Scanner scanner = new Scanner(System.in);
            dayChoice = scanner.nextInt();
        } while (dayChoice < 0 || dayChoice > 6); 
    }
    
    public void displayWeek() {
        int count = 0;
        System.out.println("This Week:");
        for (Day d : thisWeek.getCurrentWeek()) {
            System.out.println(count + ". " + d.getDaysDate());
            count++;
        }
    }
    
    public String setEventName() {
        System.out.println("Enter name of new event: ");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    
    public boolean setWantReminder() {
        boolean wantReminder = false; // False by default.
        int userChoice;
        System.out.print("Would you like a reminder for this event?");
        System.out.println(" Enter a 1 for yes or any number for no.");
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        if (userChoice == 1) {
            wantReminder = true;
        }
        return wantReminder;
    }
    
    // Description of this command
    @Override
    public String toString() {
        return "Add Event";
    } 
}
