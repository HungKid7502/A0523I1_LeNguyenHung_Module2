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
            System.out.println("Thông tin của khách hàng");
            idCustomer = InputDataValidate.checkInputDataRegex("Mời bạn nhập mã khách hàng: ", ID_CUSTOMER_REGEX, "Xin lỗi!!!Mã nhân viên phải đúng định dạng NV-YYYY, YYYY là số 0-9");
            nameCustomer = InputDataValidate.checkInputDataRegex("Mời bạn nhập mã khách hàng: ", NAME_CUSTOMER_REGEX, "Xin lỗi!!!Tên nhân viên phải bắt đầu bằng chữ cái in hoa");
            dateOfBirthCustomer = scanner.nextLine();
            cmnd = InputDataValidate.checkInputDataRegex("Mời bạn nhập cmnd khách hàng: ", CMND_REGEX, "Xin lỗi!!!Chứng minh nhân dân phải gồm 9 số hoặc 12 số");
            phoneNumber = InputDataValidate.checkInputDataRegex("Mời bạn nhập số điện thoại khách hàng: ", PHONE_CUSTOMER_REGEX, "Xin lỗi!!!Số điện thoại phải bắt đầu từ số 0 và phải gồm 10 số");
            email = InputDataValidate.checkInputDataRegex("Mời bạn nhập số email khách hàngl: ", EMAIL_REGEX, "Xin lỗi!!!Email không đúng định dạng");
            gender = InputDataValidate.checkInputGender("Please enter customer' s gender: ");
            typeCustomer = InputDataValidate.checkInputNull("Mời bạn nhập kiểu khách hàng: ", "Kiểu khách hàng");
            address = InputDataValidate.checkInputNull("Mời bạn nhập địa chỉ khách hàng: ", "Địa chỉ");
            Customer customer = new Customer(idCustomer, nameCustomer, dateOfBirthCustomer, cmnd, gender, phoneNumber, email, typeCustomer, address);
            customerRepository.add(customer);

            String mess = "Bạn có muốn thêm mới nhân viên nào khác không? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }

    @Override
    public void display() {
        List<Customer> customers = customerRepository.getList();
        for (Customer customer: customers) {
            System.out.println(customer.getInfoToCSV());
        }
    }

    @Override
    public void editById() {

    }
}
