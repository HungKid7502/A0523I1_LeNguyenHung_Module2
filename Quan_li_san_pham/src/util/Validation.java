package util;

import java.util.Scanner;

public class Validation {
    private static Scanner scanner = new Scanner(System.in);

    public int getInt(String mess, int min) {
        while (true) {
            System.out.println(mess);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result < min) {
                    System.out.printf("ID không thể nhỏ hơn %d!!!Vui lòng nhập lại\n", min);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Id sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }

    public String getString(String mess) {
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Tên không được để trống!!!Vui lòng nhập lại");
                continue;
            }
            return result;
        }
    }

    public Double getDouble(String mess, int min, int max) {
        while (true) {
            System.out.println(mess);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.println("Vượt mức giá quy định!!!Vui lòng nhập lại");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Giá sản phẩm phải là số!!!Vui lòng nhập lại");
            }
        }
    }
}
