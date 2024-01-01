package service;

import model.Product;
import model.ProductNK;
import model.ProductXK;
import repository.IProductRepository;
import repository.ProductRepository;
import util.CheckInputData;
import util.NotFoundProductException;

import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
    private final String PRODUCT_REGEX = "^[S][P]\\d{5}$";

    @Override
    public void addProduct() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choice;
        do {
            System.out.println("1. Thêm sản phẩm nhập khẩu" +
                    "\n2. Thêm sản phẩm xuất khẩu" +
                    "\n3. Quay trở lại");
            while (true) {
                choice = CheckInputData.checkInputInt("Mời bạn chọn loại sản phẩm", "Loại sản phẩm");
                if (choice < 1 || choice > 3) {
                    System.out.println("Vui lòng nhập lựa chọn từ 1 đến 3");
                    continue;
                }
                break;
            }
            switch (choice) {
                case 1: {
                    addProductNK();
                    System.out.println("Đã thêm mới sản phẩm thành công!!!");
                    break;
                }
                case 2: {
                    addProductXK();
                    System.out.println("Đã thêm mới sản phẩm thành công!!!");
                    break;
                }
                default: {
                    flag = false;
                }
            }
        } while (flag);
    }

    @Override
    public void displayAll() {
        IProductRepository productRepository = new ProductRepository();
        List<Product> products = productRepository.getAll();
        for (Product product : products) {
            System.out.println(product.getInfoToCSV());
        }
    }

    @Override
    public void deleteProduct() {
        IProductRepository productRepository = new ProductRepository();
        Scanner scanner = new Scanner(System.in);
        displayAll();
        List<Product> productList = productRepository.getAll();
        String maDel;
        while (true) {
            try {
                System.out.println("Mời bạn nhập mã sản phẩm cần xóa: ");
                maDel = scanner.nextLine();
                checkProductCodeException(maDel);
                break;
            } catch (NotFoundProductException e) {
                System.out.println(e.getMessage());
            }
        }
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMa().equals(maDel)) {
                flag = true;
                System.out.println("Đã tìm thấy mã sản phẩm tương ứng!!!");
                if (CheckInputData.confirm("Bạn có chắc chắn muốn xóa không? (Yes||No)")) {
                    productList.remove(i);
                    System.out.println("--Đã xóa thành công--");
                    productRepository.update(productList);
                    System.out.println("Danh sách sản phẩm sau khi xóa: ");
                    displayAll();
                    return;
                }
            }
        }

        if (!flag) System.out.println("Không tìm mã sản phẩm tương ứng!!!");
    }

    @Override
    public void searchProduct() {
        Scanner scanner = new Scanner(System.in);
        IProductRepository productRepository = new ProductRepository();
        List<Product> productList = productRepository.getAll();
        System.out.println("Mời bạn nhập mã sản phẩm cần tìm kiếm: ");
        String tenSearch = scanner.nextLine();
        boolean flag = false;
        for (int i = 0; i < productList.size(); i++) {
            if (productList.get(i).getMa().contains(tenSearch)) {
//                tìm kiêm tương đối theo tên sản phẩm
                flag = true;
                System.out.println("Đã tìm thấy tên sản phẩm tương ứng!!!");
                System.out.println(productList.get(i).getInfoToCSV());
                return;
            }
        }

        if (!flag) System.out.println("Xin lỗi!!!Không tìm thấy tên sản phẩm tương ứng!!!");
    }

    public void addProductNK() {
        IProductRepository productRepository = new ProductRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Thông tin sản phẩm--");
        String ma;
        while (true) {
            ma = CheckInputData.checkInputRegex("Mời bạn nhập mã sản phẩm: ", PRODUCT_REGEX, "Mã sản phẩm chưa hợp lệ!!!");
            if (CheckInputData.checkTheSameProductCode(ma)) {
                System.err.println("Mã sản phẩm tồn tại!!!Vui lòng nhập một mã khác");
                continue;
            }
            break;
        }
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String ten = scanner.nextLine();
        double gia;
        while (true) {
            gia = CheckInputData.checkInputDouble("Mời bạn nhập giá bán: ", "Giá bán");
            if (gia < 0) {
                System.out.println("Giá bán phải là số dương!!!");
                continue;
            }
            break;
        }
        int soLuong;
        while (true) {
            soLuong = CheckInputData.checkInputInt("Mời bạn số lượng bán: ", "Số lượng bán");
            if (soLuong < 0) {
                System.out.println("Số lượng phải là số dương!!!");
                continue;
            }
            break;
        }
        System.out.println("Mời bạn nhập nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();
        double giaNhapKhau;
        while (true) {
            giaNhapKhau = CheckInputData.checkInputDouble("Mời bạn nhập giá nhập khẩu: ", "Gía nhập khẩu");
            if (giaNhapKhau < 0) {
                System.out.println("Giá nhập khẩu phải là số dương!!!");
                continue;
            }
            break;
        }
        System.out.println("Mời bạn nhập tỉnh thành: ");
        String tinhThanh = scanner.nextLine();
        double thue;
        while (true) {
            thue = CheckInputData.checkInputDouble("Mời bạn nhập thuế: ", "Thuế");
            if (thue < 0) {
                System.out.println("Thuế phải là số dương!!!");
                continue;
            }
            break;
        }
        ProductNK productNK = new ProductNK(ma, ten, gia, soLuong, nhaSanXuat, giaNhapKhau, tinhThanh, thue);
        productRepository.addProduct(productNK);
    }

    public void addProductXK() {
        IProductRepository productRepository = new ProductRepository();
        Scanner scanner = new Scanner(System.in);
        System.out.println("--Thông tin sản phẩm--");
        String ma = CheckInputData.checkInputRegex("Mời bạn nhập mã sản phẩm: ", PRODUCT_REGEX, "Mã sản phẩm chưa hợp lệ!!!");
        System.out.println("Mời bạn nhập tên sản phẩm: ");
        String ten = scanner.nextLine();
        double gia;
        while (true) {
            gia = CheckInputData.checkInputDouble("Mời bạn nhập giá bán: ", "Gía bán");
            if (gia < 0) {
                System.out.println("Gía bán phải là số dương!!!");
                continue;
            }
            break;
        }
        int soLuong;
        while (true) {
            soLuong = CheckInputData.checkInputInt("Mời bạn số lượng bán: ", "Số lượng bán");
            if (soLuong < 0) {
                System.out.println("Số lượng phải là số dương!!!");
                continue;
            }
            break;
        }
        System.out.println("Mời bạn nhập nhà sản xuất: ");
        String nhaSanXuat = scanner.nextLine();
        double giaXuatKhau;
        while (true) {
            giaXuatKhau = CheckInputData.checkInputDouble("Mời bạn nhập giá xuất khẩu: ", "Giá xuất khẩu");
            if (giaXuatKhau < 0) {
                System.out.println("Giá xuất khẩu phải là số dương!!!");
                continue;
            }
            break;
        }
        System.out.println("Mời bạn nhập quốc gia để xuất khẩu: ");
        String quocGia = scanner.nextLine();
        ProductXK productXK = new ProductXK(ma, ten, gia, soLuong, nhaSanXuat, giaXuatKhau, quocGia);
        productRepository.addProduct(productXK);
    }

    public boolean checkProductCodeException(String maCheck) throws NotFoundProductException {
        if (!maCheck.matches(PRODUCT_REGEX)) {
            throw new NotFoundProductException("Mã sản phẩm ko đúng định dạng!!!Vui lòng nhập lại");
        }
        return true;
    }
}
