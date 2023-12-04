package repository.impl;

import model.Product;
import repository.IProductRepository;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductRepository implements IProductRepository {
    private static Scanner scanner = new Scanner(System.in);
    private static ArrayList<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "Samsung", 20, "Màn hình đẹp"));
        productList.add(new Product(2, "Xiaomi", 15, "Chip mạnh"));
        productList.add(new Product(3, "Oppo", 13, "Pin trâu"));
    }

    @Override
    public ArrayList<Product> getList() {
        return productList;
    }

    @Override
    public void add(Product product) {
        productList.add(product);
    }

    @Override
    public void editById(int index) {
        System.out.println("Đã tìm thấy sản phẩm!!!");
        System.out.println("1. Sửa tên sản phẩm" +
                           "\n2. Sửa giá sản phẩm" +
                           "\n3. Sửa mô tả sản phẩm" +
                           "\nMời bạn chọn thông tin cần sửa: ");
        int option = Integer.parseInt(scanner.nextLine());
        switch (option) {
            case 1: {
                System.out.println("Tên mới: ");
                productList.get(index).setName(scanner.nextLine());
                break;
            }
            case 2: {
                System.out.println("Giá mới: ");
                productList.get(index).setPrice(Double.parseDouble(scanner.nextLine()));
                break;
            }
            case 3: {
                System.out.println("Mô tả mới: ");
                productList.get(index).setDescribe(scanner.nextLine());
            }
        }
    }

    @Override
    public void deleteById(int index) {
        productList.remove(index);
    }
 }



