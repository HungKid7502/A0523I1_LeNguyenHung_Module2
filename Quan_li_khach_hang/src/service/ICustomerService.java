package service;

import model.Customer;

import java.util.ArrayList;

public interface ICustomerService {
    ArrayList<Customer> getAll();

    void add(Customer customer);

    void deleteById(int idDel);

    void edit(int idEdit, Customer customer);
}
