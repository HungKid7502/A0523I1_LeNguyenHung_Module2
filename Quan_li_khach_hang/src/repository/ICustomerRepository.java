package repository;

import model.Customer;

import controller.CustomerController;

public interface ICustomerRepository {
    Customer[] getAll();

    void add(Customer customer);

    void edit(int idEdit, Customer customer);
}
