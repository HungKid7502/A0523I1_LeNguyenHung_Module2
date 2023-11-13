package controller;

import service.impl.ServiceProduct;

import java.util.Scanner;

public class ProductController {
    ServiceProduct serviceProduct = new ServiceProduct();

    public void displayMenu() {
        System.out.println("--||Chương trình quản lý sản phẩm||--");
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng quản lý: ");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Hiển thị sản phẩm");
            System.out.println("3. Chỉnh sửa sản phẩm");
            System.out.println("4. Xóa sản phẩm");
            System.out.println("5. Sắp xếp sản phẩm");
            System.out.println("6. Kết thúc");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1: {
                    serviceProduct.add();
                    break;
                }
                case 2: {
                    serviceProduct.display();
                    break;
                }
                case 3: {
                    serviceProduct.edit();
                    break;
                }
                case 4: {
                    serviceProduct.delete();
                    break;
                }
                case 5: {
                    serviceProduct.sort();
                }
                default: {
                    System.out.println("Chương trình kêt thúc. Hẹn gặp lại!!!");
                    flag = false;
                }
            }
        } while (flag);
    }
}
