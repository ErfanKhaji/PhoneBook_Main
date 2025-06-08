package org.example;

import java.util.Scanner;

public class ContactView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- PhoneBook Menu ---");
        System.out.println("1.Add New Contact");
        System.out.println("2. Show All Contact");
        System.out.println("3.Update Contact");
        System.out.println("4.Delete Contact");
        System.out.println("5.Excite");
    }

    public int getUserChoice() {
        System.out.print("Your choice: ");
        return scanner.nextInt();
    }

    public String getInput(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }
}
