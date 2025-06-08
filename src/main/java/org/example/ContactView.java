package org.example;

import org.example.Contact;

import java.util.List;
import java.util.Scanner;

public class ContactView {
    private Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- Phone Book Menu ---");
        System.out.println("1. Add Contact");
        System.out.println("2. Show All Contacts");
        System.out.println("3. Update Contact");
        System.out.println("4. Delete Contact");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");
    }
    public Contact getNewContactInfo(){
        System.out.println("Enter Your name : ");
        String name = scanner.nextLine();
        System.out.println("Enter Your last name : ");
        String lastName = scanner.nextLine();
        System.out.println("Enter Your phone number : ");
        String phoneNumber = scanner.nextLine();
        return new Contact(name , lastName , phoneNumber);
    }
    public int getContactDeleteOrUpdate(String action){
        System.out.println("Enter Your Action " + action);
        return Integer.parseInt(action);

    }
    public void showAllContacts(List<Contact> contacts){
        System.out.println("Phone Book Contact List : ");
        if (contacts.isEmpty()){
            System.out.println("No Contact Found");
        }
        for (int i = 0; i < contacts.size(); i++){
            System.out.println(i+1 + ". " + contacts.get(i));
        }

    }
    public void showMessage(String message){
        System.out.println(message);
    }
    public Scanner getScanner(){
        return scanner;
    }
}
