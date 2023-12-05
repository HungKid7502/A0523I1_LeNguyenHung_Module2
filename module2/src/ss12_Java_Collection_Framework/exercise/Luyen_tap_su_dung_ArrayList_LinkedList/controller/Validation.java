package ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.controller;

import java.util.Scanner;

public class Validation {
    private static final Scanner scanner = new Scanner(System.in);
    public int getInt(String mess, int min) {
        while (true) {
            System.out.println(mess);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result < min) {
                    System.out.println("Id không thể nhỏ hơn " + min + "!!!Vui lòng nhập lại");
                    continue;
                }
                return result;
            } catch (NumberFormatException nfe) {
                System.out.println("Id sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }

    public String getString(String mess) {
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Tên sản phẩm không được để trống!!!Vui lòng nhập lại");
                continue;
            }
            return result;
        }
    }

    public double getDouble(String mess, int min, int max) {
        while (true) {
            System.out.println(mess);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.println("Giá phải từ " + min + " đến " + max + "!!!Vui lòng nhập lại");
                    continue;
                }
                return result;
            } catch (NumberFormatException nfe) {
                System.out.println("Giá sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }
}
