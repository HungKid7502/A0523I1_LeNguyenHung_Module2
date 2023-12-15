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
    private final String NAME_EMPLOYEE_REGEX = "[A-Z][a-z]{1,}\\s[A-Z][a-z]{1,}\\s?([A-Z][a-z]{1,})?";
    private final String CMND_REGEX = "^\\d{9}(?:\\d{3})?$";
    private final String PHONE_NUMBER_REGEX = "([0])+([0-9]{9})";
    private final String EMAIL_REGEX = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";

    private IEmployeeRepository employeeRepository = new EmployeeRepository();

    @Override
    public void add() {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("Employee' s information");
        idEmployee = InputDataValidate.checkInputData("Please enter employee' id: ", ID_EMPLOYEE_REGEX, "Employee' id must be in the correct format NV-XXXX, XXXX must be the numbers 0-9");
        nameEmployee = InputDataValidate.checkInputData("Please enter employee' name: ", NAME_EMPLOYEE_REGEX, "Employee' name must capitalize the first letter of each word");
        cmnd = InputDataValidate.checkInputData("Please enter employee' s cmnd: ", CMND_REGEX, "Employee' s CMND must have 9 or 12 numbers");
        phoneNumber = InputDataValidate.checkInputData("Please enter employee' s phone number: ", PHONE_NUMBER_REGEX, "Employee' s phone number must start from 0 and must have 10 digits");
        email = InputDataValidate.checkInputData("Please enter employee' s email: ", EMAIL_REGEX, "Emploee' s email invalidate");
        gender = InputDataValidate.checkInputGender("Please enter employee' s gender: ");
        System.out.println("Please enter employee' s level");
        level = scanner.nextLine();
        System.out.println("Please enter employee' s position");
        position = scanner.nextLine();
        salary = InputDataValidate.checkInputSalary("Please enter employee' salary:", 0);
        Employee employee = new Employee(idEmployee, nameEmployee, "07-05-02", gender, cmnd, phoneNumber, email, level, position, salary);
        employeeRepository.add(employee);
    }


    @Override
    public void display() {
        List<Employee> employees = employeeRepository.getList();
        for (Employee s: employees) {
            System.out.println(employees);
        }
    }

    @Override
    public void editById() {

    }

}
