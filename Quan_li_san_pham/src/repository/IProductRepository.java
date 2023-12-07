package repository;

import model.Product;
import java.util.ArrayList;
import java.util.List;

public interface IProductRepository {
    List<Product> getList();

    void add(Product product);

    void editById(int idEdit);

    void deleteById(int idDel);
}
