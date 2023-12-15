package repository.impl;

import model.modelperson.Employee;
import repository.IEmployeeRepository;
import util.ReadAndWriteFile;
import java.util.ArrayList;
import java.util.List;

public class EmployeeRepository implements IEmployeeRepository<Employee> {
    private final String EMPLOYEE_FILE_PATH= "D:\\C0723L1_LeNguyenHung_Module2\\Manage_Furama_Resort\\src\\data\\employee.csv";

    @Override
    public List<Employee> getList() {
        List<String> stringList = ReadAndWriteFile.readFromFile(EMPLOYEE_FILE_PATH);
        List<Employee> employeeList = new ArrayList<>();
        String[] array = null;
        for (String s: stringList) {
            array = s.split(";");
            employeeList.add(new Employee(array[0], array[1], array[2], array[3], array[4], array[5], array[6], array[7], array[8], Double.parseDouble(array[9])));
        }
        return employeeList;
    }

    @Override
    public void add(Employee employee) {
        List<String> stringList = new ArrayList<>();
        stringList.add(employee.getInfoToCSV());
        ReadAndWriteFile.writeToFile(EMPLOYEE_FILE_PATH, stringList, true);
    }
}
