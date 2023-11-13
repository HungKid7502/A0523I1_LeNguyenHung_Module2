package repository.impl;

import model.Product;
import repository.IRepositoryProduct;

public class RepositoryProduct implements IRepositoryProduct {
    private static Product[] productList = new Product[10];

    public Product[] getProductList() {
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i] == null) {
                productList[i] = product;
                break;
            }
        }
    }

    @Override
    public void deleteProduct(int idDel) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i].getId() == idDel) {
                productList[i] = null;
            }
            break;
        }
    }

    @Override
    public void editProduct(int idEdit, Product productEdit) {
        for (int i = 0; i < productList.length; i++) {
            if (productList[i].getId() == idEdit) {
                productList[i] = productEdit;
                break;
            }
        }
    }

    @Override
    public void sortProduct() {

    }
}
