package view;

import controller.ProductController;
import model.Product;
import util.Validation;
import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int EDIT = 4;
    private static final int FIND = 5;

    private static Scanner scanner = new Scanner(System.in);

    private static ProductController productController = new ProductController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("\nChương trình quản lí sản phẩm");
            System.out.println("\n1. Hiển thị danh sách sản phẩm" +
                    "\n2. Thêm sản phẩm" +
                    "\n3. Xóa sản phẩm" +
                    "\n4. Sửa sản phẩm" +
                    "\n5. Tìm kiếm sản phẩm" +
                    "\n6. Kết thúc chương trình" +
                    "\nMời bạn chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY: {
                    ArrayList<Product> products = productController.getList();
                    System.out.println("-----Danh sách sản phẩm-----");
                    displayProductList(products);
                    break;
                }
                case ADD: {
                    System.out.println("-----Chức năng thêm sản phẩm-----");
                    addProduct();
                    break;
                }
                case EDIT: {
                    System.out.println("-----Chức năng chỉnh sửa sản phẩm-----");
                    int idEdit = editById();
                    productController.editById(idEdit);
                    break;
                }
                case DELETE: {
                    System.out.println("-----Chức năng xóa sản phẩm-----");
                    int idDel = deleteById();
                    productController.deleteById(idDel);
                    break;
                }
                case FIND: {

                }
                default: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public static void displayProductList(ArrayList<Product> products) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i) != null) {
                System.out.println("Product " + (i + 1) + ". " + products.get(i));
            }
        }
    }

    public static void addProduct() {
        Validation validation = new Validation();
        while (true) {
            System.out.println("--||Nhập thông tin sản phẩm||--");
            int id = validation.getInt("Mời nhập id sản phẩm: ", 1, 100);
            String name = validation.getString("Mời bạn nhập tên sản phẩm: ");
            double price = validation.getDouble("Mời bạn nhập giá sản phẩm: ", 1, 1000);
            System.out.println("Nhập mô tả sản phẩm: ");
            String describe = scanner.nextLine();
            Product product = new Product(id, name, price, describe);
            productController.add(product);
            System.out.println("Thêm mới thành công!!!");
            System.out.println("Bạn muốn thêm sản phẩm nào khác không? (Y||N)");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public static int editById() {
        System.out.println("Nhập id sản phẩm cần sửa: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static int deleteById() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void find() {
    }
}
