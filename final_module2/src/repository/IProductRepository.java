package repository;

import model.Product;

import java.util.List;

public interface IProductRepository {
    List<Product> getAll();
    void addProduct(Product product);
    void update(List<Product> productList);
}
