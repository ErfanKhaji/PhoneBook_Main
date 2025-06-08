package org.example;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ContactDao {
    private static final String URL = "jdbc:postgresql://localhost:5432/MyDataBase";
    private static final String USER = "postgres";
    private static final String PASSWORD = "1234";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void addContact(Contact contact) throws SQLException {
        String sql = "INSERT INTO contact(firstname, lastname, phone) VALUES (?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getLastname());
            stmt.setString(3, contact.getPhone());
            stmt.executeUpdate();
        }
    }

    public List<Contact> getAllContacts() throws SQLException {
        List<Contact> contacts = new ArrayList<>();
        String sql = "SELECT * FROM contact";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                contacts.add(new Contact(rs.getString("firstname"), rs.getString("lastname"), rs.getString("phone")));
            }
        }
        return contacts;
    }

    public void updateContact(Contact contact) throws SQLException {
        String sql = "UPDATE contact SET firstname = ?, lastname = ? WHERE phone = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, contact.getName());
            stmt.setString(2, contact.getLastname());
            stmt.setString(3, contact.getPhone());
            stmt.executeUpdate();
        }
    }

    public void deleteContactByPhone(String phone) throws SQLException {
        String sql = "DELETE FROM contact WHERE phone = ?";
        try (Connection conn = connect(); PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, phone);
            stmt.executeUpdate();
        }
    }
}
