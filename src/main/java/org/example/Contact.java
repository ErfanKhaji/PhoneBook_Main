package org.example;

public class Contact {
    private String name;
    private String lastname;
    private String phone;

    public Contact(String name, String lastname, String phone) {
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "نام: " + name + "، نام خانوادگی: " + lastname + "، شماره: " + phone;
    }
}
