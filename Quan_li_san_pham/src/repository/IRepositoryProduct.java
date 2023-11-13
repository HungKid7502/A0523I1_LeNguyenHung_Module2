package repository;

import model.Product;

public interface IRepositoryProduct {
    void addProduct(Product product);
    Product[] getProductList();
    void deleteProduct(int idDel);
    void editProduct(int id, Product productEdit);
    void sortProduct();
}
