package controller;

import service.IProductService;
import service.ProductService;
import util.CheckInputData;

import java.util.Scanner;

public class Controller {
    IProductService productService = new ProductService();

    private final int ADD = 1;
    private final int DELETE = 2;
    private final int DISPLAY = 3;
    private final int SEARCH = 4;
    public void showMainMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("\nCHƯƠNG TRÌNH QUẢN LÍ SẢN PHẨM" +
                    "\n1. Thêm mới " +
                    "\n2. Xóa" +
                    "\n3. Xem danh sách các sản phẩm" +
                    "\n4. Tìm kiếm" +
                    "\n5. Thoát");
            int userChoice = CheckInputData.checkInputInt("Mời bạn nhập chức năng quản lí", "Chức năng quản lí");
            switch (userChoice) {
                case ADD: {
                    System.out.println("Chức năng thêm mới sản phẩm");
                    productService.addProduct();
                    break;
                }
                case DELETE: {
                    System.out.println("Chức năng xóa sản phẩm");
                    productService.deleteProduct();
                    break;
                }
                case DISPLAY: {
                    System.out.println("Chức năng hiển thị danh sách sản phẩm");
                    productService.displayAll();
                    break;
                }
                case SEARCH: {
                    System.out.println("Chức năng tìm kiếm sản phẩm");
                    productService.searchProduct();
                    break;
                }
                default: {
                    flag = false;
                }
            }
        } while (flag);
    }
}
