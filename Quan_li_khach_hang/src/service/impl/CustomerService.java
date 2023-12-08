package service.impl;

import model.Customer;
import repository.impl.CustomerRepository;
import service.ICustomerService;

import java.util.ArrayList;

public class CustomerService implements ICustomerService {
    private CustomerRepository customerRepository = new CustomerRepository();

    @Override
    public ArrayList<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public void add(Customer customer) {
        customerRepository.add(customer);
    }

    public void deleteById(int idDel) {
        customerRepository.deleteById(idDel);
    }

    @Override
    public void edit(int idEdit, Customer customer) {
        customerRepository.edit(idEdit, customer);
    }
}
