
package features.consoleView;
import consoleKit.MenuItem; import features.model.AllContacts; import features.model.Contact;

/** *
* @author abbypetersen
*/
public class DisplayContacts implements MenuItem{
    
    public AllContacts contacts;
    
    public DisplayContacts(AllContacts _contacts){
        contacts = _contacts; 
    }
    
    @Override
    public void execute(){
        for (Contact con: contacts.getContacts()){ 
            System.out.print(con.getName() + ": "); 
            System.out.print(con.getPhone() + ", "); 
            System.out.print(con.getEmail() + ". \n");
        } 
    }
// Description of this command @Override
    public String toString() {
        return "View All Contacts"; 
    }
    
}
