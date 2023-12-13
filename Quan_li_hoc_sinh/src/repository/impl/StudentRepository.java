package repository.impl;

import model.Student;
import repository.IStudentRepository;
import util.ReadAndWriteFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentRepository implements IStudentRepository {
    private final String FILE_PATH = "D:\\C0723L1_LeNguyenHung_Module2\\Quan_li_hoc_sinh\\src\\data\\student.csv";
    private static Scanner scanner = new Scanner(System.in);
    private static List<Student> productList = new ArrayList<>();

    @Override
    public List<Student> getList() {
        List<String> stringList = ReadAndWriteFile.readFromFile(FILE_PATH);
        List<Student> students = new ArrayList<>();
        String[] array = null;
        for (String o : stringList) {
            array = o.split(";");
            students.add(new Student(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), array[3], array[4]));
        }
        return students;
    }

    @Override
    public void addStudent(Student product) {
        List<String> stringList = new ArrayList<>();
        stringList.add(product.getInfoToCSV());
        ReadAndWriteFile.writeToFile(FILE_PATH, stringList, true);
    }

    @Override
    public void editById(List<String> stringList) {
        ReadAndWriteFile.writeToFile(FILE_PATH, stringList, false);
    }

    @Override
    public void deleteById(List<String> stringList) {
        ReadAndWriteFile.writeToFile(FILE_PATH, stringList, false);
    }
}



