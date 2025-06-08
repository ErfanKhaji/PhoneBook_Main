package org.example;

import jdk.dynalink.linker.LinkerServices;
import org.example.Contact;
import org.example.ContactView;

import java.util.ArrayList;
import java.util.List;

public class ContatctController {
    private List<Contact> contacts = new ArrayList<Contact>();
    private ContactView view = new ContactView();

    public void Start() {
        boolean running = true;
        while (running) {
            view.showMenu();
            String choise = view.getScanner().nextLine();

            switch (choise) {
                case "1":
                    Contact newContact = view.getNewContactInfo();
                    contacts.add(newContact);
                    view.showMessage("New Contact Added");
                    break;
                case "2":
                    view.showAllContacts(contacts);
                    break;
                case "3":
                    view.showAllContacts(contacts);
                    int updateIndex = view.getContactDeleteOrUpdate("Update") - 1;
                    if (updateIndex >= 0 && updateIndex < contacts.size()) {
                        Contact updateContact = view.getNewContactInfo();
                        contacts.set(updateIndex, updateContact);

                        view.showMessage("Contact Updated");
                    } else {
                        view.showMessage("Contact Not Added");
                    }
                    break;
                case "4":
                    view.showAllContacts(contacts);
                    int deleteIndex = view.getContactDeleteOrUpdate("Delete") - 1;
                    if (deleteIndex >= 0 && deleteIndex < contacts.size()) {
                        Contact deleteContact = view.getNewContactInfo();
                        contacts.set(deleteIndex, deleteContact);
                    } else {
                        view.showMessage("Contact Not Added");
                    }
                    break;
                case "5":
                    view.showMessage("Exiting....");
                    break;
                default:
                    view.showMessage("Unknown");

            }

        }
    }
}
