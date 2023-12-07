package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;
import util.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private static IProductRepository productRepository = new ProductRepository();

    private static Validation validation = new Validation();

    @Override
    public void display() {
        List<Product> products = productRepository.getList();
        System.out.println("| ++ Sản phẩm ++ | ++ Id ++ | ++ Tên ++ | ++ Giá ++ | ++ Mô tả ++  |");
        int stt = 0;
        for (Product o : products) {
            System.out.printf("| %-14s | %-8s | %-9s | %-9s | %-12s |\n",
                    stt + 1, o.getId(), o.getName(), o.getPrice(), o.getDescribe());
            stt++;
        }
    }

    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-- Nhập thông tin sản phẩm --");
            int id;
            while (true) {
                id = validation.getInt("Mời nhập id sản phẩm: ", 1);
                if (checkId(id)) break;
//                gọi hàm checkId() để kiểm tả Id trùng lặp
                else continue;
            }
            String name = validation.getString("Mời bạn nhập tên sản phẩm: ");
            double price = validation.getDouble("Mời bạn nhập giá sản phẩm: ", 1, 100000000);
            System.out.println("Nhập mô tả sản phẩm: ");
            String describe = scanner.nextLine();
            Product product = new Product(id, name, price, describe);
            productRepository.add(product);
//          thêm sản phẩm vừa tạo vào list
            System.out.println("Thêm mới thành công!!!");
            String message = "Bạn muốn thêm sản phẩm nào khác không? (Y||N)";
            if (confirm(message)) continue;
            else return;
        }
    }

    @Override
    public void editById(int idEdit) {
        List<Product> products = productRepository.getList();
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idEdit) {
                flag = true;
                System.out.println("Đã tìm thấy sản phẩm!!!");
                while (true) {
                    productRepository.editById(i);
                    System.out.println("Đã chỉnh sửa thành công!!!");
                    String message = "Bạn có muốn sửa thêm thông tin nào không?";
                    if (confirm(message)) continue;
                    else return;
                }
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng");
        }
    }

    @Override
    public void deleteById(int idDel) {
        List<Product> products = productRepository.getList();
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idDel) {
                flag = true;
                String message = "Bạn có chắc chắn muốn xóa không? (Y||N)";
                if (confirm(message)) {
                    productRepository.deleteById(i);
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

    public boolean checkId(int idCheck) {
        List<Product> products = productRepository.getList();
        for (Product o: products) {
            if (o.getId() == idCheck) {
                System.out.println("Id đã tồn tại!!!Vui lòng nhập lại");
                return false;
            }
        }
        return true;
    }

    public boolean confirm(String mess) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(mess);
        String option = scanner.nextLine();
        if (option.equalsIgnoreCase("Y")) return true;
        else return false;
    }
//    phương thức lựa chọn yes or no
}
