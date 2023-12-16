package service.impl;

import model.modelperson.Customer;
import repository.ICustomerRepository;
import repository.impl.CustomerRepository;
import service.ICustomerService;
import util.InputDataValidate;
import java.util.List;
import java.util.Scanner;

public class CustomerService implements ICustomerService {
    private final String ID_CUSTOMER_REGEX = "^[K][H]\\-\\d{4}$";
    private final String NAME_CUSTOMER_REGEX = "^([A-Z][a-z]{1,})((\\s[A-Z][a-z]{1,}){1,4})$";
    private final String CMND_REGEX = "^\\d{9}(?:\\d{3})?$";
    private final String PHONE_CUSTOMER_REGEX = "([0])+([0-9]{9})";
    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private ICustomerRepository customerRepository = new CustomerRepository();
    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String idCustomer;
        String nameCustomer;
        String dateOfBirthCustomer;
        String cmnd;
        String phoneNumber;
        String email;
        String gender;
        String typeCustomer;
        String address;
        while (true) {
            System.out.println("Customer' s information");
            idCustomer = InputDataValidate.checkInputDataRegex("Please enter customer' s id: ", ID_CUSTOMER_REGEX, "Customer' id must be in the correct format NV-YYYY, YYYY must be the numbers 0-9");
            nameCustomer = InputDataValidate.checkInputDataRegex("Please enter customer' s name: ", NAME_CUSTOMER_REGEX, "Customer' name must capitalize the first letter of each word");
            cmnd = InputDataValidate.checkInputDataRegex("Please enter customer' s cmnd: ", CMND_REGEX, "Customer' s CMND must have 9 or 12 numbers");
            phoneNumber = InputDataValidate.checkInputDataRegex("Please enter customer' s phone number: ", PHONE_CUSTOMER_REGEX, "Customer' s phone number must start from 0 and must have 10 digits");
            email = InputDataValidate.checkInputDataRegex("Please enter customer' s email: ", EMAIL_REGEX, "Customer' s email invalidate");
            gender = InputDataValidate.checkInputGender("Please enter customer' s gender: ");
            System.out.println("Please enter customer' s type: ");
            typeCustomer = scanner.nextLine();
            System.out.println("Please enter customer' s address: ");
            address = scanner.nextLine();
            Customer customer = new Customer(idCustomer, nameCustomer, "07-05-02-", cmnd, gender, phoneNumber, email, typeCustomer, address);
            customerRepository.add(customer);

            String mess = "Do you want to add a new customer? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }

    @Override
    public void display() {
        List<Customer> customers = customerRepository.getList();
        for (Customer s: customers) {
            System.out.println(s.getInfoToCSV());
        }
    }

    @Override
    public void editById() {

    }
}
