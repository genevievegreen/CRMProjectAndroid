/*

* To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package features.model;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList; import java.util.List;
/** *
* @author abbypetersen
*/
public class AllContacts implements Serializable {
    //private static final int NO_CHOICE = -1;
    private final List<Contact> allcontacts;
    //private int chosenList;


    //create file to write contacts to
    FileOutputStream f = new FileOutputStream("Contacts");
    ObjectOutput s = new ObjectOutputStream(f);


    // Initialize contacts to empty list
    public AllContacts() throws IOException {
        allcontacts = new ArrayList<Contact>();
        //chosenList = NO_CHOICE;
    }

    // set the "current" list
    public void setFocus(int index) {
        //chosenList = index;
        // no list chosen
    }

    // Add a reminder to the "current" list
    public void addContact(Contact con) throws IOException {
        allcontacts.add(con);
        s.writeObject(con);
        s.flush();
        s.close();
    }

    public Contact getContact(int index) {
        return allcontacts.get(index);
    }

    public List<Contact> getContacts() {
        return allcontacts;
    }

    public int getContactListSize() {
        return allcontacts.size();
    }

    public Contact contactSearch(String contact) {
        Contact c = null;
        for (int i = 0; i < allcontacts.size(); i++) {
            if (allcontacts.get(i).getName() == contact) {
                c = allcontacts.get(i);
            }
        }
        return c;
    }
}
