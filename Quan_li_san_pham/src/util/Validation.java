package util;

import java.util.Scanner;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);
    public static int getInt(String message, int min, int max) {
        while (true) {
            System.out.println(message);
            int result = Integer.parseInt(scanner.nextLine());
            if (result < min || result > max) {
                System.out.println("Id phải từ 1 đến 100!!!");
                continue;
            }
            return result;
        }
    }

    public static String getString(String message) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Tên không được để trống!!!");
                continue;
            }
            return result;
        }
    }

    public static Double getDouble(String message, int min, int max) {
        while (true) {
            System.out.println(message);
            Double result = Double.parseDouble(scanner.nextLine());
            if (result < min || result > max) {
                System.out.println("Giá phải từ 1 đến 1000!!!");
                continue;
            }
            return result;
        }
    }
}
