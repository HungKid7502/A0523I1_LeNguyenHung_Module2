package controller;

import model.Customer;
import service.impl.CustomerService;

public class CustomerController {
    private CustomerService customerService = new CustomerService();

    public Customer[] getAll() {
        return customerService.getAll();
    }

    public void add(Customer customer) {
        customerService.add(customer);
    }

    public void edit(int idEdit, Customer customer) {
        customerService.edit(idEdit, customer);
    }
}
