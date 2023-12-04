package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;
import java.util.ArrayList;

public class ProductController {
    private static IProductService productService = new ProductService();

    public void display() {
        productService.display();
    }

    public void addProduct() {
        productService.addProduct();
    }

    public void editById(int id) {
        productService.editById(id);
    }

    public void deleteById(int idDel) {
        productService.deleteById(idDel);
    }
}
