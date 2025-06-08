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
                        System.out.println("خروج از برنامه انجام شد");
                        return;
                    }
                    default -> System.out.println("گزینه نامعتبر!");
                }
            } catch (SQLException e) {
                System.out.println("خطا در پایگاه داده: " + e.getMessage());
            }
        }
    }

    public void addContact() throws SQLException {
        String name = view.getInput("نام");
        String lastname = view.getInput("نام خانوادگی");
        String phone = view.getInput("شماره تلفن");
        dao.addContact(new Contact(name, lastname, phone));
        System.out.println("مخاطب اضافه شد.");
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
        String phone = view.getInput("شماره مخاطب (برای ویرایش)");
        String name = view.getInput("نام جدید");
        String lastname = view.getInput("نام خانوادگی جدید");
        dao.updateContact(new Contact(name, lastname, phone));
        System.out.println("مخاطب به‌روزرسانی شد.");
    }

    public void deleteContact() throws SQLException {
        String phone = view.getInput("شماره مخاطب برای حذف");
        dao.deleteContactByPhone(phone);
        System.out.println("مخاطب حذف شد.");
    }
}
