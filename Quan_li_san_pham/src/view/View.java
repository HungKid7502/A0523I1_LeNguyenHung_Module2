package view;

import controller.ProductController;
import util.Validation;
import java.util.Scanner;

public class View {
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int EDIT = 4;

    private static Scanner scanner = new Scanner(System.in);

    private static ProductController productController = new ProductController();

    private static Validation validation = new Validation();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("\nChương trình quản lí sản phẩm");
            System.out.println("\n1. Hiển thị danh sách sản phẩm" +
                               "\n2. Thêm sản phẩm" +
                               "\n3. Xóa sản phẩm" +
                               "\n4. Sửa sản phẩm" +
                               "\n5. Kết thúc chương trình" +
                               "\nMời bạn chọn chức năng: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY: {
                    System.out.println("-----Danh sách sản phẩm-----");
                    productController.display();
                    break;
                }
                case ADD: {
                    System.out.println("-----Chức năng thêm sản phẩm-----");
                    productController.addProduct();
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
                default: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public static int editById() {
        return validation.getInt("Nhập id sản phẩm cần sửa: ", 1);
    }

    public static int deleteById() {
        return validation.getInt("Nhập id sản phẩm cần xóa: ", 1);
    }
}
