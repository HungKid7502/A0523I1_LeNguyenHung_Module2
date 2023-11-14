package service;

import model.Product;

public interface IProductService {
    Product[] getList();

    void add(Product product);

    void updateById(int id);

    void deleteById(int idDel);

    void find();
}
