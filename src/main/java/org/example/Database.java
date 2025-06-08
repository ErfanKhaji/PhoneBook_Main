package org.example;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/MyDataBase";
        String user = "postgres";
        String password = "1234";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            ContactDao dao = new ContactDao(conn);
            Contact contact = new Contact("Ali", "Ahmadi", "09123456789");
            dao.addContact(contact);
            System.out.println("Contact added successfully!");
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
