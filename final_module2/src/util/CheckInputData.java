package util;

import model.Product;
import repository.IProductRepository;
import repository.ProductRepository;

import java.util.List;
import java.util.Scanner;

public class CheckInputData {
    static Scanner scanner = new Scanner(System.in);

    public static String checkInputRegex(String mess, String REGEX, String str) {
        while (true) {
            System.out.println(mess);
            String result = scanner.nextLine();
            if (result.matches(REGEX)) return result;
            else System.out.println(str);
        }
    }

    public static int checkInputInt(String mess, String str) {
        while (true) {
            System.out.println(mess);
            try {
                int result = Integer.parseInt(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Xin lỗi!!!" + str + " phải ở dạng số");
            }
        }
    }

    public static double checkInputDouble(String mess, String str) {
        while (true) {
            System.out.println(mess);
            try {
                double result = Double.parseDouble(scanner.nextLine());
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Xin lỗi!!!" + str + " phải là số");
            }
        }
    }

    public static boolean confirm(String mess) {
        while (true) {
            System.out.println(mess);
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Yes")) return true;
            else if (option.equalsIgnoreCase("No")) return false;
            else System.out.println("Vui lòng nhập lựa chọn \'Yes (yes)\' hoặc \'No (no)\'");
        }
    }

    public static boolean checkTheSameProductCode(String checkCode) {
        IProductRepository productRepository = new ProductRepository();
        List<Product> productList = productRepository.getAll();
        for (Product product : productList) {
            if (product.getMa().equals(checkCode)) {
                return true;
            }
        }
        return false;
    }
}
