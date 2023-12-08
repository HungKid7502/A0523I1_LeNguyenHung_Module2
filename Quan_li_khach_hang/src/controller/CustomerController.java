package controller;

import model.Customer;
import service.impl.CustomerService;

import java.util.ArrayList;

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    public ArrayList<Customer> getAll() {
        return customerService.getAll();
    }

    public void add(Customer customer) {
        customerService.add(customer);
    }

    public void deleteById(int idDel) {
        customerService.deleteById(idDel);
    }

    public void edit(int idEdit, Customer customer) {
        customerService.edit(idEdit, customer);
    }
}
