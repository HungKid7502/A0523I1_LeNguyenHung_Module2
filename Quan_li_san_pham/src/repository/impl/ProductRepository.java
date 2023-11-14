package repository.impl;

import model.Product;
import repository.IProductRepository;

import java.util.Scanner;

public class ProductRepository implements IProductRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static Product[] productList = new Product[10];

    static {
        productList[0] = new Product(1, "prd2", 5,"Good");
        productList[1] = new Product(2, "prd2", 10, "Good");
        productList[2] = new Product(3, "prd3", 15, "Good");
    }

    @Override
    public Product[] getList() {
        return productList;
    }

    @Override
    public void add(Product product) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = product;
                break;
            }
        }
    }

    public void updateById(int id) {
        boolean flag = false;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null && productList[i].getId() == id) {
                flag = true;
                System.out.println("Đã tìm thấy sản phẩm!!!");
                System.out.println("1. Sửa tên sản phẩm" +
                        "\n2. Sửa giá sản phẩm" +
                        "\n3. Sửa mô tả sản phẩm");
                System.out.println("Mời bạn chọn: ");
                int option = Integer.parseInt(scanner.nextLine());
                switch (option) {
                    case 1: {
                        System.out.println("Tên mới: ");
                        productList[i].setName(scanner.nextLine());
                        break;
                    }
                    case 2: {
                        System.out.println("Giá mới: ");
                        productList[i].setPrice(Double.parseDouble(scanner.nextLine()));
                        break;
                    }
                    case 3: {
                        System.out.println("Mô tả mới: ");
                        productList[i].setDescribe(scanner.nextLine());
                    }
                }
                System.out.println("Sửa sản phẩm thành công!!!");
                break;
            }
            if (productList[i] == null) {
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng!!!");
        }
    }

    @Override
    public void deleteById(int idDel) {
        boolean flag = false;
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] != null && productList[i].getId() == idDel) {
                flag = true;
                productList[i] = null;
                break;
            }
            if (productList[i] == null) {
                break;
            }
        }
        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng!!!");
        }
    }

    @Override
    public void find() {

    }
}
