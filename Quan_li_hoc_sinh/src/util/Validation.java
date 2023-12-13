package util;

import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import java.util.List;
import java.util.Scanner;

public class Validation {
    private static IStudentRepository studentRepository = new StudentRepository();

    public static boolean checkTheSameId(int idCheck) {
        List<Student> products = studentRepository.getList();
        for (Student o : products) {
            if (o.getId() == idCheck) {
                System.out.println("Id đã tồn tại!!!Vui lòng nhập lại");
                return false;
            }
        }
        return true;
    }
//    phương thức check Id trùng lặp

    public static boolean confirm(String mess) {
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(mess);
            String option = scanner.nextLine();
            if (option.equalsIgnoreCase("Y")) return true;
            else if (option.equalsIgnoreCase("N")) return false;
            else {
                System.out.println("Vui lòng nhập Y hoặc N!!!");
            }
        }
    }
}
