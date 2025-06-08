package org.example;

import java.util.Scanner;

public class ContactView {
    private final Scanner scanner = new Scanner(System.in);

    public void showMenu() {
        System.out.println("\n--- دفترچه تلفن ---");
        System.out.println("1. اضافه کردن مخاطب");
        System.out.println("2. نمایش همه مخاطبین");
        System.out.println("3. ویرایش مخاطب");
        System.out.println("4. حذف مخاطب");
        System.out.println("5. خروج");
    }

    public int getUserChoice() {
        System.out.print("انتخاب شما: ");
        return scanner.nextInt();
    }

    public String getInput(String message) {
        System.out.print(message + ": ");
        return scanner.next();
    }
}
