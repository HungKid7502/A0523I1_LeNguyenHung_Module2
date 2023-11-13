package service.impl;

import controller.Validation;
import model.Product;
import repository.impl.RepositoryProduct;
import service.IServiceProduct;

import java.util.Scanner;

public class ServiceProduct implements IServiceProduct {
    RepositoryProduct repositoryProduct = new RepositoryProduct();
    Validation validation = new Validation();

    @Override
    public void add() {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("--Nhập thông tin sản phẩm--");
            int id = validation.getInt("Nhập id sản phẩm: ", 1, 100);
            String name = validation.getString("Nhập tên sản phẩm: ");
            double price = validation.getDouble("Nhập giá sản phẩm: ", 1, 1000);
            System.out.println("Nhập mô tả: ");
            String describe = scanner.nextLine();
            Product product = new Product(id, name, price, describe);
            repositoryProduct.addProduct(product);

            System.out.println("Bạn có muốn thêm một sản phẩm nào khác không? (Y || N)");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) continue;
            else break;
        }
    }

    @Override
    public void display() {
        Product[] products = repositoryProduct.getProductList();
        for (int i = 0; i < products.length; i++) {
            if (products[i] != null)
                System.out.println("Product " + (i + 1) + ". " + products[i]);
        }
    }

    @Override
    public void delete() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm cần xóa: ");
        int idDel = Integer.parseInt(scanner.nextLine());
        repositoryProduct.deleteProduct(idDel);
    }

    @Override
    public void edit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id sản phẩm muốn sửa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        int id = validation.getInt("Nhập id sản phẩm để sửa: ", 1, 100);
        String name = validation.getString("Nhập tên sản phẩm để sửa: ");
        double price = validation.getDouble("Nhập giá sản phẩm để sửa: ", 1, 1000);
        System.out.println("Nhập mô tả sản phẩm cần sửa: ");
        String describe = scanner.nextLine();
        Product productEdit = new Product(id, name, price, describe);
        repositoryProduct.editProduct(idEdit, productEdit);
    }

    @Override
    public void sort() {
    }
}
