/*
* To change this license header, choose License Headers in Project Properties. * To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package features.consoleView;

import static consoleKit.Console.STDIN; 
import consoleKit.MenuItem;
import features.model.AllContacts; 
import features.model.Contact;


/** *
* @author abbypetersen
*/

public class AddContact implements MenuItem{
    
    private AllContacts contacts;
    
    public AddContact(AllContacts cons){
        contacts = cons; }

    public void execute(){
        System.out.print("Enter the name of the new contact: ");
        String name = STDIN.next();
        System.out.print("Enter the phone number of the new contact: "); 
        long pnum = STDIN.nextLong();
        System.out.print("Enter the email of the new contact: ");
        String email = STDIN.next();
        Contact c = new Contact(name, pnum, email); 
        contacts.addContact(c);
    }
    
    // Description of this command @Override
    public String toString() {
        return "Add Contact"; 
    }
}
