package org.example;

public class Main {
    public static void main(String[] args) {
        ContactDao dao = new ContactDao();
        ContactView view = new ContactView();
        ContactController controller = new ContactController(dao, view);
        controller.start();
    }
}
