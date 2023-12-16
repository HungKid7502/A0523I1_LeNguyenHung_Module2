package repository.impl;

import model.modelperson.Customer;
import repository.ICustomerRepository;
import util.ReadAndWriteFile;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository<Customer> {
    private final String CUSTOMER_FILE_PATH = "D:\\C0723L1_LeNguyenHung_Module2\\Manage_Furama_Resort\\src\\data\\person\\customer.csv";
    @Override
    public List<Customer> getList() {
        List<String> stringList = ReadAndWriteFile.readFromFile(CUSTOMER_FILE_PATH);
        List<Customer> customerList = new ArrayList<>();
        String array[] = null;
        for (String s: stringList) {
            array = s.split(",");
            customerList.add(new Customer(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8]));
        }
        return customerList;
    }

    @Override
    public void add(Customer customer) {
        List<String> stringList = new ArrayList<>();
        stringList.add(customer.getInfoToCSV());
        ReadAndWriteFile.writeToFile(CUSTOMER_FILE_PATH, stringList, true);
    }
}
