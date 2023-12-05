package ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.controller;

import ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    private static List<Product> list = new ArrayList<>();

    private static Validation vl = new Validation();

    private static Scanner scanner = new Scanner(System.in);

    static {
        list.add(new Product(1, "Android", 10));
        list.add(new Product(2, "Opple", 20));
        list.add(new Product(3, "Iphone", 30));
    }

    public void display() {
        System.out.println("| ++ Sản phẩm ++ | ++ ID ++ | ++ Tên ++ | ++ Giá ++ |");
        int stt = 0;
        for (Product o : list) {
            System.out.printf("| %-14s | %-8s | %-9s | %-9s |\n",
                    stt + 1, o.getId(), o.getName(), o.getPrice());
            stt++;
        }
    }

    public void addProduct() {
        while (true) {
            System.out.println("-- Nhập thông tin sản phẩm --");
            int id;
            while (true) {
                id = vl.getInt("Mời nhập id sản phẩm: ", 1);
                if (checkId(id)) break;
                else continue;
            }
            String name = vl.getString("Mời bạn nhập tên sản phẩm: ");
            double price = vl.getDouble("Mời bạn nhập giá sản phẩm: ", 1, 100000000);
            Product product = new Product(id, name, price);
            list.add(product);
            System.out.println("Thêm mới thành công!!!");
            String message = "Bạn muốn thêm sản phẩm nào khác không? (Y||N)";
            if (confirm(message)) continue;
            else return;
        }
    }

    public void editById(int idEdit) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idEdit) {
                flag = true;
                System.out.println("Đã tìm thấy sản phẩm!!!");
                System.out.println("1. Sửa tên sản phẩm" +
                        "\n2. Sửa giá sản phẩm" +
                        "\nMời bạn chọn thông tin cần sửa: ");
                int option = Integer.parseInt(scanner.nextLine());
                if (option == 1) {
                    System.out.println("Nhập tên mới: ");
                    list.get(i).setName(scanner.nextLine());
                } else if (option == 2) {
                    System.out.println("Nhập giá mới:");
                    list.get(i).setPrice(Double.parseDouble(scanner.nextLine()));
                } else System.out.println("Không có thông tin tương ứng!!!");
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng");
        }
    }

    public void deleteById(int idDel) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getId() == idDel) {
                flag = true;
                String message = "Bạn có chắc chắn muốn xóa không? (Y||N)";
                if (confirm(message)) {
                    list.remove(i);
//                    xóa sản phẩm khỏi list
                    System.out.println("Đã xóa thành công!!!");
                    break;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng");
        }
    }

    public void findByName(String nameFind) {
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getName().equals(nameFind)) {
                flag = true;
                System.out.println("Tìm thấy sản phẩm tên " + nameFind + "!!!");
                break;
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng!!!");
        }
    }
//
//    public void editById(int idDel) {

    public boolean checkId(int idCheck) {
        for (Product o : list) {
            if (o.getId() == idCheck) {
                System.out.println("Id bị trùng lặp!!!Vui lòng nhập lại");
                return false;
            }
        }
        return true;
    }
//    kiểm tra Id trùng lặp

    public boolean confirm(String mess) {
        System.out.println(mess);
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("Y")) return true;
        else return false;
    }
//    lựa chọn yes or no
}
