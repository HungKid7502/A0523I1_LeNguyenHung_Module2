package repository;

import model.Customer;

import controller.CustomerController;

import java.util.ArrayList;

public interface ICustomerRepository {
    ArrayList<Customer> getAll();

    void add(Customer customer);

    void deleteById(int idDel);

    void edit(int idEdit, Customer customer);
}
