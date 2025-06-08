package org.example;

public class Main {
    public static void main(String[] args) {
        try{
            ContactDao dao = new ContactDao();
            ContactView view = new ContactView();
            ContactController controller = new ContactController(dao, view);
            controller.start();
        }catch (Exception e){
            System.out.println("Unhandled exception: " + e);
        }


    }
}
