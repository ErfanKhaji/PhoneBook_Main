package org.example;

import org.example.Contact;

import java.sql.*;

public class ContactDao {
    public static final String URL = "jdbc:postgresql://localhost:5432/MyDataBase";
    public static final String user = "postgres";
    public static final String password = "1234";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL, user, password);

    }

    public void getAllContacts() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyDataBase", "postgres", "1234");
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM contacts");
        while (resultSet.next()) {
            String firstName = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            String phone = resultSet.getString("phone");
            System.out.println("Name: " + firstName + ", Lastname: " + lastname + ", Phone: " + phone);
//aa
        }
    }

    public void UpdateContact(Contact updateContact) throws SQLException {
        String Sql = "UPDATE contacts SET WHERE firstname = ?, AND lastname = ?,AND phone = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyDataBase", "postgres", "1234")
             ; PreparedStatement preparedStatement = connection.prepareStatement(Sql)) {
            preparedStatement.setString(1, updateContact.getName());
            preparedStatement.setString(2, updateContact.getLastname());
            preparedStatement.setString(3, updateContact.getPhone());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Contact updated successfully");
            } else {
                System.out.println("Contact not updated");
            }


        }

    }
    public void DeleteContact(Contact deleteContact) throws SQLException {
        String Sql = "DELETE FROM contacts WHERE firstname = ? AND lastname = ? AND phone = ?";
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/MyDataBase", "postgres", "1234")
             ; PreparedStatement preparedStatement = connection.prepareStatement(Sql)) {
            preparedStatement.setString(1, deleteContact.getName());
            preparedStatement.setString(2, deleteContact.getLastname());
            preparedStatement.setString(3, deleteContact.getPhone());
            int count = preparedStatement.executeUpdate();
            if (count > 0) {
                System.out.println("Contact deleted successfully");
            } else {
                System.out.println("Contact not deleted");
            }
        }


    }

    public void addContact(Contact contact) throws SQLException {
        String URL = "jdbc:postgresql://localhost:5432/MyDataBase";
        String user = "postgres";
        String password = "1234";
        String sql = "INSERT INTO student(id,firstname) VALUES (?,?)";
        try (Connection connection = connect();
             PreparedStatement statement = connection.prepareStatement(sql);) {
            statement.setString(1, contact.getName());
            statement.setString(2, contact.getLastname());
            statement.setString(3, contact.getPhone());
            statement.executeUpdate();


        }


    }
}

