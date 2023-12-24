package util;

import java.util.Scanner;

public class InputDataValidate {
    public static int checkInputOption(String mess, int min, int max) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            int choice = Integer.parseInt(scanner.nextLine());
            if (choice < min || choice > max) {
                System.out.printf("Option must be from %d to %d!!!", min, max);
                continue;
            }
            return choice;
        }
    }

    public static String checkInputDataRegex(String mess, String REGEX_STRING, String warnString) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.matches(REGEX_STRING)) return result;
            else {
                System.out.println(warnString);
            }
        }
    }

    public static String checkInputGender(String mess) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        while (true) {
            String gender = scanner.nextLine();
            if (gender.equalsIgnoreCase("Nam") || gender.equalsIgnoreCase("Nữ") || gender.equalsIgnoreCase("LGBT"))
                return gender;
            else System.out.println("Bạn vui lòng nhập \'Nam\', \'Nữ\' hoặc \'LGBT\'!!!");
        }
    }

    public static double checkInputDouble(String mess, String str) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            try {
                double salary = Double.parseDouble(scanner.nextLine());
                return salary;
            } catch (NumberFormatException e) {
                System.out.println("Xin lỗi!!!" + str + "phải ở dạng số");;
            }
        }
    }

    public static String checkInputNull(String mess, String str) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println("Xin lỗi!!!" + str + "không được để trống!!!");
                continue;
            }
            return result;
        }
    }

    public static Double checkInputDouble(String mess, double min, String s) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                if (result <= min) {
                    System.out.println(s + "must be greater than " + min);
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println(s + " must be numeric!!!");;
            }
        }
    }

    public static int checkInputInt(String mess, int min, int max, String warnString) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                if (result < min || result > max) {
                    System.out.printf("Number of floors must be greater than 0!!!");
                    continue;
                }
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Salary must be numeric!!!");;
            }
        }
    }

    public static boolean confirm(String mess) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        while (true) {
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) return true;
            else if (option.equalsIgnoreCase("N")) return false;
            else System.out.println("Xin lỗi!!!Bạn vui lòng nhập \'Y (y)\' hoặc \'N (n)\'");
        }
    }
}
