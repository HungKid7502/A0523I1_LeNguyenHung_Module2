package repository;

import model.Product;
import model.ProductNK;
import model.ProductXK;
import util.ReadAndWriteFile;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository implements IProductRepository{
    private final String PRODUCT_FILE_PATH = "D:\\C0723L1_LeNguyenHung_Module2\\final_module2\\src\\data\\product.csv";

    @Override
    public List<Product> getAll() {
        List<String> stringList = ReadAndWriteFile.readFromFile(PRODUCT_FILE_PATH);
        List<Product> productList = new ArrayList<>();
        String array[];
        for (String s : stringList) {
            array = s.split(",");
//            dùng số lượng thuộc tính để phân biệt 2 đối tượng
            if (array.length == 9) {
//                                            String ma, String ten, double gia, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanh, double thue
                Product productNK = new ProductNK(array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], Double.parseDouble(array[6]), array[7], Double.parseDouble(array[8]));
                productList.add(productNK);
            } else {
//                                            String ma, String ten, double gia, int soLuong, String nhaSanXuat, double giaXuatKhau, String quocGia
                Product productXK = new ProductXK(array[1], array[2], Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], Double.parseDouble(array[6]), array[7]);
                productList.add(productXK);
            }
        }
        return productList;
    }

    @Override
    public void addProduct(Product product) {
        List<String> stringList = new ArrayList<>();
        stringList.add(product.getInfoToCSV());
        ReadAndWriteFile.writeToFile(PRODUCT_FILE_PATH, stringList, true);
    }

    @Override
    public void update(List<Product> productList) {
        List<String> stringList = new ArrayList<>();
        for (Product product: productList) {
            stringList.add(product.getInfoToCSV());
        }
        ReadAndWriteFile.writeToFile(PRODUCT_FILE_PATH, stringList, false);
    }
}
