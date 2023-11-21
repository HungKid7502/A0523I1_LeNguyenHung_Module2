package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;
import java.util.ArrayList;

public class ProductController {
    private static IProductService productService = new ProductService();
    public ArrayList<Product> getList() {
        return productService.getList();
    }

    public void add(Product product) {
        productService.add(product);
    }

    public void editById(int id) {
        productService.editById(id);
    }

    public void deleteById(int idDel) {
        productService.deleteById(idDel);
    }

    public void find() {
        productService.find();
    }
}
