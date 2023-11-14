package repository;

import model.Product;

public interface IProductRepository {
    Product[] getList();

    void add(Product product);

    void updateById(int id);

    void deleteById(int idDel);

    void find();
}
