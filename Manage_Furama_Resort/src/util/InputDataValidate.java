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
            if (gender.equalsIgnoreCase("Male") || gender.equalsIgnoreCase("Female") || gender.equalsIgnoreCase("LGBT"))
                return gender;
            else System.out.println("Must enter gender as \'Male\', \'Female\' or \'LGBT\'!!!");
        }
    }

    public static double checkInputSalary(String mess, double min) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            try {
                double salary = Double.parseDouble(scanner.nextLine());
                if (salary < min) {
                    System.out.println("Salary must be greater than 0!!!");
                    continue;
                }
                return salary;
            } catch (NumberFormatException e) {
                System.out.println("Salary must be numeric!!!");;
            }
        }
    }

    public static String checkInputNull(String mess, String str) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.length() == 0 || result == null) {
                System.out.println(str + "cannot be blank!!!");
                continue;
            }
            return result;
        }
    }

    public static boolean confirm(String mess) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        while (true) {
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) return true;
            else if (option.equalsIgnoreCase("N")) return false;
            else System.out.println("Please enter \'Y (y)\' or \'N (n)\'");
        }
    }
}
