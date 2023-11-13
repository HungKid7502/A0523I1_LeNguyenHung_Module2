package controller;

import java.util.Scanner;

public class Validation {
    public int getInt(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while (true) {
            int result = Integer.parseInt(scanner.nextLine());
            if (result < min || result > max) {
                System.out.println("Vui lòng nhập lại!!!");
                continue;
            }
            return result;
        }
    }

    public Double getDouble(String message, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while (true) {
            double result = scanner.nextDouble();
            if (result < min || result > max) {
                System.out.println("Vui lòng nhập lại!!!");
                continue;
            }
            return result;
        }
    }

    public String getString(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        while (true) {
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Vui lòng nhập lại!!!");
                continue;
            }
            return result;
        }
    }
}

