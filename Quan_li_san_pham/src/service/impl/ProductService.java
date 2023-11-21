package service.impl;

import model.Product;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductService implements IProductService {
    IProductRepository productRepository = new ProductRepository();

    @Override
    public ArrayList<Product> getList() {
        return productRepository.getList();
    }

    @Override
    public void add(Product product) {
        productRepository.add(product);
    }

    @Override
    public void editById(int idEdit) {
        ArrayList<Product> products = productRepository.getList();
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idEdit) {
                flag = true;
                productRepository.editById(i);
                System.out.println("Đã chỉnh sửa thành công!!!");
                break;
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng");
        }
    }

    @Override
    public void deleteById(int idDel) {
        ArrayList<Product> products = productRepository.getList();
        Scanner scanner = new Scanner(System.in);
        boolean flag = false;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == idDel) {
                flag = true;
                System.out.println("Bạn có chắc chắn muốn xóa không? (Y||N)");
                String option = scanner.nextLine();
                if (option.equalsIgnoreCase("Y")) {
                    productRepository.deleteById(i);
                    System.out.println("Đã xóa thành công!!!");
                    break;
                }
                return;
            }
        }

        if (!flag) {
            System.out.println("Không tìm thấy sản phẩm tương ứng");
        }
    }

    @Override
    public void find() {
    }
}
