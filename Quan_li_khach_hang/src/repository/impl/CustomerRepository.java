package repository.impl;

import model.Customer;
import repository.ICustomerRepository;

public class CustomerRepository implements ICustomerRepository {
//    tạo một mảng giả để lưu dữ liệu
    private static Customer[] customerList = new Customer[3];
//    static {
//        customerList[0] = new Customer(1, "Hung1");
//        customerList[1] = new Customer(1, "Hung2");
//        customerList[2] = new Customer(1, "Hung3");
//    }

    @Override
    public Customer[] getAll() {
        return customerList;
    }

    @Override
    public void add(Customer customer) {
//        sau này sẽ ghi vào file
        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i] == null) {
                customerList[i] = customer;
                break;
            }
        }
    }

    @Override
    public void edit(int idEdit, Customer customer) {
        for (int i = 0; i < customerList.length; i++) {
            if (customerList[i].getId() == idEdit) {
                customerList[i] = customer;
                break;
            }
        }
    }
}
