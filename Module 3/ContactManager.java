
import java.util.*;

public class ContactManager {

    public static void main(String[] args) {

        HashMap<String, Contact> contacts = new HashMap<>();

        contacts.put("John will", new Contact("John will", "+1 617 555 0101"));
        contacts.put("adam key", new Contact("adam key", "+1 458 177 0258"));
        contacts.put("sarah", new Contact("sarah", "+1 654 525 0147"));
        contacts.put("monica", new Contact("monica", "+1 123 025 6969"));
        contacts.put("rachle", new Contact("rachle", "+1 444 587 2547"));// Step 4: add contacts here

        Contact found = contacts.get("monica"); // Step 5: look up a contact

        if ((found) != null) {
            System.out.println("Details: " + found);

        } else {
            System.out.println("Contact not found.  ");
        } // with a name that does not exist

        if ((found = contacts.get("joey")) != null) {
            System.out.println("Details: " + found);

        } else {
            System.out.println("Contact not found.  ");
        } // with a name that does not exist

        // Step 6: print sorted list

        ArrayList<Contact> sorted = new ArrayList<>(contacts.values());
        sorted.sort((a, b) -> a.getName().compareToIgnoreCase(b.getName()));   // ignoring uper or lower case to sort because contacts can be save in any form

        System.out.println(" === All Contacts ===  ");

        for (Contact con : sorted) {
            
            System.out.println(con);
        }

    

}

}
