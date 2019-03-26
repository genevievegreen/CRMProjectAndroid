/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package features.model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author abbypetersen
 */
public class ContactList {
  
    private final String name;
    private final String email;
    private final int phone;
    private final List<Contact> contacts;
    
    
    public ContactList(String _name, int pnum, String _email) {
        name = _name;
        phone = pnum;
        email = _email;
        contacts = new ArrayList<>(); 
    }

    
     public void add(Contact con) {
        contacts.add(con);
    }

    public List<Contact> getContacts() {
        return contacts; //To change body of generated methods, choose Tools | Templates.
    }
}
