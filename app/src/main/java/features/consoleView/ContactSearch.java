package features.consoleView;
import consoleKit.MenuItem;
import features.model.AllContacts;
import features.model.Contact;

import static consoleKit.Console.STDIN;

public class ContactSearch implements MenuItem {
    private AllContacts contacts;

    public ContactSearch(AllContacts cons){
        contacts = cons;
    }

    @Override
    public void execute() {
        Contact c = null;
        boolean isInList = false;
        System.out.print("Enter the name of the contact whose information you would like to access: ");
        String name = STDIN.next();

        for (int i = 0; i < contacts.getContactListSize(); i++) {
            if (contacts.getContact(i).getName() == name) {
                isInList = true;
            }
        }

        if(isInList == true){
            c = contacts.contactSearch(name);
        }

        System.out.print("Name: " + c.getName() + ". \n");
        System.out.print("Phone: " + c.getPhone() + ", ");
        System.out.print("Email: " + c.getEmail() + ". \n");
    }

    // Description of this command @Override
    public String toString() {
        return "Search for a Contact.";
    }
}
