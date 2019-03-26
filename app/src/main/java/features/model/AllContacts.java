/*

* To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package features.model;
import java.util.ArrayList; import java.util.List;
/** *
* @author abbypetersen
*/
public class AllContacts {
    //private static final int NO_CHOICE = -1; 
    private final List<Contact> allcontacts; 
    //private int chosenList;


    // Initialize contacts to empty list 
    public AllContacts() {
        allcontacts = new ArrayList<Contact>();
        //chosenList = NO_CHOICE;
    }
    
    // set the "current" list
    public void setFocus(int index) {
        //chosenList = index; 
        // no list chosen
    }
    
    // Add a reminder to the "current" list 
    public void addContact(Contact con) {
        allcontacts.add(con);   
    }
    
    public Contact getContact(int index) {
        return allcontacts.get(index);
    }

    public List<Contact> getContacts(){
        return allcontacts; 
    }
    
    public int getContactListSize() {
        return allcontacts.size();
    }
}
