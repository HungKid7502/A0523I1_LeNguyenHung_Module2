package util;

import java.util.Scanner;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);

    public int getInt(String message, int min) {
        while (true) {
            System.out.println(message);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result < min) {
                    System.out.println("ID không thể nhỏ hơn 1!!!Vui lòng nhập lại");
                    continue;
                }
                return result;
            } catch (NumberFormatException nfe) {
                System.out.println("Id sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }

    public String getString(String message) {
        while (true) {
            System.out.println(message);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Tên không được để trống!!!Vui lòng nhập lại");
                continue;
            }
            return result;
        }
    }

    public Double getDouble(String message, int min, int max) {
        while (true) {
            System.out.println(message);
            try {
                Double result = Double.parseDouble(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.println("Vượt mức giá quy định!!!Vui lòng nhập lại");
                    continue;
                }
                return result;
            } catch (NumberFormatException nfe) {
                System.out.println("Giá sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }
}
