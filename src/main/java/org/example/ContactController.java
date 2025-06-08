package org.example;

import java.sql.SQLException;
import java.util.List;

public class ContactController {
    private final ContactDao dao;
    private final ContactView view;

    public ContactController(ContactDao dao, ContactView view) {
        this.dao = dao;
        this.view = view;
    }

    public void start() {
        while (true) {
            view.showMenu();
            int choice = view.getUserChoice();

            try {
                switch (choice) {
                    case 1 -> addContact();
                    case 2 -> showAllContact();
                    case 3 -> updateContact();
                    case 4 -> deleteContact();
                    case 5 -> {
                        System.out.println("Excited...");
                        return;
                    }
                    default -> System.out.println("Unknown choice " + choice);
                }
            } catch (SQLException e) {
                System.out.println("Error In Database: " + e.getMessage());
            }
        }
    }

    public void addContact() throws SQLException {
        String name = view.getInput("First Name: ");
        String lastname = view.getInput("Last Name: ");
        String phone = view.getInput("Phone Number: ");
        dao.addContact(new Contact(name, lastname, phone));
        System.out.println("Contact Added");
    }

    public void showAllContact() throws SQLException {
        List<Contact> contacts = dao.getAllContacts();

        System.out.printf("%-15s %-15s %-15s\n", "First Name", "Last Name", "Phone");
        System.out.println("------------------------------------------------------");

        for (Contact contact : contacts) {
            System.out.printf("%-15s %-15s %-15s\n",
                    contact.getName(),
                    contact.getLastname(),
                    contact.getPhone());
        }
    }


    public void updateContact() throws SQLException {
        String phone = view.getInput("New Contact Phone Number: ");
        String name = view.getInput("New Contact Name: ");
        String lastname = view.getInput("New Contact Last Name: ");
        dao.updateContact(new Contact(name, lastname, phone));
        System.out.println("Contact Updated");
    }

    public void deleteContact() throws SQLException {
        String phone = view.getInput("Contact Phone Number to Delete: ");
        dao.deleteContactByPhone(phone);
        System.out.println("Contact Deleted");
    }
}
