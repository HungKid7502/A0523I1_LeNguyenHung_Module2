package service.impl;

import model.modelperson.Employee;
import repository.IEmployeeRepository;
import repository.impl.EmployeeRepository;
import service.IEmployeeService;
import util.InputDataValidate;
import java.util.List;
import java.util.Scanner;

public class EmployeeService implements IEmployeeService {
    private final String ID_EMPLOYEE_REGEX = "^[N][V]\\-\\d{4}$";
    private final String NAME_EMPLOYEE_REGEX = "^([A-Z][a-z]{1,})((\\s[A-Z][a-z]{1,}){1,4})$";
    private final String CMND_REGEX = "^\\d{9}(?:\\d{3})?$";
    private final String PHONE_NUMBER_REGEX = "([0])+([0-9]{9})";
    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void add() {
        Scanner scanner = new Scanner(System.in);
        String idEmployee;
        String nameEmployee;
        String dateOfBirthEmployee;
        String cmnd;
        String phoneNumber;
        String email;
        String gender;
        String level;
        String position;
        double salary;
        while (true) {
            System.out.println("Thông tin của nhân viên");
            idEmployee = InputDataValidate.checkInputDataRegex("Mời bạn nhập id nhân viên: ", ID_EMPLOYEE_REGEX, "Xin lỗi!!!Mã nhân viên phải đúng định dạng NV-XXXX, XXXX là số 0-9");
            nameEmployee = InputDataValidate.checkInputDataRegex("Mời bạn nhập tên nhân viên: ", NAME_EMPLOYEE_REGEX, "Xin lỗi!!!Tên nhân viên phải bắt đầu bằng chữ cái in hoa");
            dateOfBirthEmployee = scanner.nextLine();
            cmnd = InputDataValidate.checkInputDataRegex("Mời bạn nhập cmnd nhân viên: ", CMND_REGEX, "Xin lỗi!!!Chứng minh nhân dân phải gồm 9 số hoặc 12 số");
            phoneNumber = InputDataValidate.checkInputDataRegex("Mời bạn nhập số điện thoại nhân viên: ", PHONE_NUMBER_REGEX, "Xin lỗi!!!Số điện thoại phải bắt đầu từ số 0 và phải gồm 10 số");
            email = InputDataValidate.checkInputDataRegex("Mời bạn nhập email nhân viên: ", EMAIL_REGEX, "Xin lỗi!!!Email không đúng định dạng");
            gender = InputDataValidate.checkInputGender("Mời bạn nhập giới tính nhân viên: ");
            level = InputDataValidate.checkInputNull("Mời bạn nhập trình độ nhân viên: ", "trình độ");
            position = InputDataValidate.checkInputNull("Mời bạn nhập vị trí nhân viên: ", "vị trí");
            while (true) {
                salary = InputDataValidate.checkInputDouble("Mời bạn nhập lương nhân viên: ", "Tiền lương");
                if (salary <= 0) {
                    System.out.println("Tiền lương không thể nhỏ hơn 0!!!");
                    continue;
                }
                break;
            }
            Employee employee = new Employee(idEmployee, nameEmployee, dateOfBirthEmployee, gender, cmnd, phoneNumber, email, level, position, salary);
            employeeRepository.add(employee);

            String mess = "Bạn có muốn thêm mới nhân viên nào khác không? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }


    @Override
    public void display() {
        List<Employee> employees = employeeRepository.getList();
        for (Employee employee: employees) {
            System.out.println(employee.getInfoToCSV());
        }
    }

    @Override
    public void editById() {

    }
}
