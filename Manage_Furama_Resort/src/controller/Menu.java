package controller;

public class Menu {
    public static void menuMain() {
        String[] menu = {"1. Employee Management", "2. Customer Management", "3. Facility Management", "4. Booking Management", "5. Promotion Management", "6. Exit"};
        for (String s : menu) {
            System.out.println(s);
        }
    }
}
