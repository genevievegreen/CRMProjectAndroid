/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dates;

import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author abbypetersen
 */
public class dates {
     // Get today's date
    public static Calendar getToday() {
        return new GregorianCalendar();
    }
    
    // Get today's year
    // Does create a Calendar object each time
    public static int getThisYear() {
        return getToday().get(Calendar.YEAR);
    }
}
