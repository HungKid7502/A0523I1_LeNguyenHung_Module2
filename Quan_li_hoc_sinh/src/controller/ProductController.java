package controller;

import model.Student;
import service.IProductService;
import service.impl.ProductService;
import java.util.ArrayList;

public class ProductController {
    private IProductService productService = new ProductService();

    public void display() {
        productService.display();
    }

    public void addStudent() {
        productService.addStudent();
    }

    public void editById(int id) {
        productService.editById(id);
    }

    public void deleteById(int idDel) {
        productService.deleteById(idDel);
    }

    public void findByName(String nameFind) {
      productService.findByName(nameFind);
    }
}
