package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

import java.util.ArrayList;

public class CustomerRepository implements ICustomerRepository {
//    tạo một mảng giả để lưu dữ liệu
    private static ArrayList<Customer> customerList = new ArrayList<>();
//    static {
//        customerList[0] = new Customer(1, "Hung1");
//        customerList[1] = new Customer(1, "Hung2");
//        customerList[2] = new Customer(1, "Hung3");
//    }

    @Override
    public ArrayList<Customer> getAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
//        sau này sẽ ghi vào file
        customerList.add(customer);
    }

    public void deleteById(int idDel) {
        boolean flag = false;
        for (int i = 0; i < customerList.size(); i++) {
            if (customerList.get(i).getId() == idDel ) {
                flag = true;
                customerList.remove(i);
                System.out.println("Đã xóa thành công!!!");
                break;
            }
        }

        if (!flag) {
            System.out.println("Không tim thấy khách hàng tương ứng!!!");
        }
    }

    @Override
    public void edit(int idEdit, Customer customer) {

    }

//    @Override
//    public void edit(int idEdit, Customer customer) {
//        for (int i = 0; i < customerList.size(); i++) {
//            if (customerList.get(i).getId() == idEdit) {
//                customerList[i] = customer;
//                break;
//            }
//        }
//    }
}
