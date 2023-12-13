package util;

import java.util.Scanner;

public class CheckInputData {
    private static Scanner scanner = new Scanner(System.in);

    private static final String VALID_EMAIL = "^[a-zA-Z][a-zA-Z0-9]+@gmail.com";

    private static final String DATEOFBIRTH_VALID = "^(0[1-9]|[12][0-9]|3[01])\\/(0[1-9]|1[012])\\/\\d{4}$";

    public static int checkInputId(String mess, int min) {
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
                System.out.println("Id học sinh phải là số!!!Vui lòng nhập lại");
            }
        }
    }

    public static String checkInputName(String mess) {
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

    public static Double checkInputMark(String mess, int min, int max) {
        while (true) {
            System.out.println(mess);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.printf("Điểm phải trong khoảng %d đến %d\n", min, max);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Điểm học sinh phải là số!!!Vui lòng nhập lại");
            }
        }
    }

    public static String checkInputEmail(String mess) {
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Email không được để trống!!!Vui lòng nhập lại");
                continue;
            } else if (result.matches(VALID_EMAIL)) {
                return result;
            } else {
                System.out.println("Email sai định dạng!!!Vui lòng nhập lại");
            }
        }
    }

    public static String checkInputDateOfBirth(String mess) {
        while (true) {
            System.out.println(mess);
            String datOfBirth = scanner.nextLine();
            if (datOfBirth.matches(DATEOFBIRTH_VALID)) return datOfBirth;
            else {
                System.out.println("Ngày sinh không đúng định dạng!!!Vui lòng nhập lại");
            }
        }
    }

    public static int checkInputOption(String mess, int min, int max) {
        while (true) {
            System.out.println(mess);
            try {
                int option = Integer.parseInt(scanner.nextLine());
                if (option < min || option > max ) {
                    System.out.printf("Option phải từ %d đến %d!!!Vui lòng nhập lại\n", min, max);
                    continue;
                }
                return option;
            } catch (NumberFormatException e) {
                System.out.println("Id học sinh phải là số!!!Vui lòng nhập lại");
            }
        }
    }
}
