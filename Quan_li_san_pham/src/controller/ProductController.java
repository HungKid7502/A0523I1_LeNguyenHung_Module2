package controller;

import model.Product;
import service.IProductService;
import service.impl.ProductService;

public class ProductController {
    private static IProductService productService = new ProductService();
    public Product[] getList() {
        return productService.getList();
    }

    public void add(Product product) {
        productService.add(product);
    }

    public void updateById(int id) {
        productService.updateById(id);
    }

    public void deleteById(int idDel) {
        productService.deleteById(idDel);
    }

    public void find() {
        productService.find();
    }

}
