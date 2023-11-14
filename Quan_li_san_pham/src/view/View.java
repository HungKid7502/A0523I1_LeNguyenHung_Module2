package view;

import controller.ProductController;
import model.Product;

import java.util.Scanner;

public class View {
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int UPDATE = 4;
    private static final int FIND = 5;

    private static Scanner scanner = new Scanner(System.in);

    private static ProductController productController = new ProductController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chương trình quản lí sản phẩm");
            System.out.println("\n1. Hiển thị danh sách sản phẩm" +
                    "\n2. Thêm sản phẩm" +
                    "\n3. Xóa sản phẩm" +
                    "\n4. Sửa sản phẩm" +
                    "\n5. Tìm kiếm sản phẩm" +
                    "\n6. Kết thúc chương trình");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY: {
                    Product[] products = productController.getList();
                    System.out.println("Danh sách sản phẩm");
                    display(products);
                    break;
                }
                case ADD: {
                    inputDataProduct();
                    break;
                }
                case UPDATE: {
                    updateById();
                    break;
                }
                case DELETE: {
                    int idDel = delete();
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

    public static void display(Product[] products) {
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null) {
                System.out.println("Product " + (i + 1) + ". " + products[i]);
            }
        }
    }

    public static void inputDataProduct() {
        while (true) {
            System.out.println("--||Nhập thông tin sản phẩm||--");
            System.out.println("Nhập id sản phẩm: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên sản phẩm: ");
            String name = scanner.nextLine();
            System.out.println("Nhập giá sản phẩm: ");
            double price = Double.parseDouble(scanner.nextLine());
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

    public static void updateById() {
        System.out.println("Nhập id sản phẩm cần sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        productController.updateById(id);
    }

    public static int delete() {
        System.out.println("Nhập id sản phẩm cần xóa: ");
        int idDel = Integer.parseInt(scanner.nextLine());
        return idDel;
    }

    public static void find() {}
}
