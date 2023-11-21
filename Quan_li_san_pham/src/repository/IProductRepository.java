package repository;

import model.Product;
import java.util.ArrayList;

public interface IProductRepository {
    ArrayList<Product> getList();

    void add(Product product);

    void editById(int idEdit);

    void deleteById(int idDel);

    void find();
}
