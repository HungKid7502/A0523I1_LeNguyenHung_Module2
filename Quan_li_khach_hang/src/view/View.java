package view;

import controller.CustomerController;
import model.Customer;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    private static Scanner scanner = new Scanner(System.in);
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int EDIT = 4;

    private static CustomerController customerController = new CustomerController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("Chọn chức năng quản lí: \n" +
                    "1. Hiển thị danh sách khách hàng\n" +
                    "2. Thêm khách hàng\n" +
                    "3. Xóa khách hàng\n" +
                    "4. Chỉnh sửa khách hàng\n" +
                    "5. Kết thúc chương trình\n" +
                    "Mời bạn chọn chức năng quản lí: ");
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case DISPLAY: {
                    ArrayList<Customer> customers = customerController.getAll();
                    displayCustomerList(customers);
                    break;
                }
                case ADD: {
                    inputDataCustomer();
                    System.out.println("Thêm mới thành công!!!");
                    break;
                }
                case DELETE: {
                    int idDel = DeleteById();
                    customerController.deleteById(idDel);
                    break;
                }
                case EDIT: {

                }
                default: {
                    System.out.println("Chương trình kết thúc!!!");
                    flag = false;
                }
            }
        } while (flag);
    }

    //    method thao tác được chọn từ người dùng
    public static void displayCustomerList(ArrayList<Customer> customers) {
        for (Customer o : customers) {
            System.out.println(o);
        }
    }

    public static void inputDataCustomer() {
        while (true) {
            System.out.println("Nhập id khách hàng: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("Nhập tên khách hàng: ");
            String name = scanner.nextLine();
            Customer customer = new Customer(id, name);
            customerController.add(customer);

            System.out.println("Bạn có muốn thêm khách hàng nào khác không? (Y||N)");
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) {
                continue;
            } else {
                break;
            }
        }
    }

    public static int DeleteById() {
        System.out.println("Nhập id khách hàng cần xóa: ");
        return Integer.parseInt(scanner.nextLine());
    }

    public static void inputCustomerEdit() {
        System.out.println("Nhập id khách hàng muốn sửa: ");
        int idEdit = Integer.parseInt(scanner.nextLine());
        System.out.println("||Đã xác nhận||");
        System.out.println("Nhập id khách hàng để sửa: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên khách hàng để sửa: ");
        String name = scanner.nextLine();
        Customer customer = new Customer(id, name);
        customerController.edit(idEdit, customer);
    }
}
