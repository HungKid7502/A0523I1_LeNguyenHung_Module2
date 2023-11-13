package service;

import model.Customer;

public interface ICustomerService {
    Customer[] getAll();
    void add(Customer customer);
    void edit(int idEdit, Customer customer);
}
