package service.impl;

import model.Student;
import repository.IStudentRepository;
import repository.impl.StudentRepository;
import service.IStudentService;
import util.CheckInputData;
import util.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentService implements IStudentService {
    private IStudentRepository studentRepository = new StudentRepository();

    @Override
    public void display() {
        List<Student> students = studentRepository.getList();
//        System.out.println("| ++ Học sinh ++ | ++ Id ++ | ++ Tên ++ | ++ Điểm số ++ | +++++++++++ Email +++++++++++ | ++ Năng lực ++ |");
//        int stt = 0;
        for (Student s : students) {
//            System.out.printf("| %-14s | %-8s | %-9s | %-13s | %-4s | %-10s |\n",
//                    stt + 1, o.getId(), o.getName(), o.getMark(), o.getEmail(), o.getCapacity());
//            stt++;
            System.out.println(s.getInfoToCSV());
        }
    }

    @Override
    public void addStudent() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("-- Nhập thông tin học sinh --");
            int id;
            while (true) {
                id = CheckInputData.checkInputId("Mời nhập id học sinh: ", 1);
                if (Validation.checkTheSameId(id)) break;
//                gọi phương thức checkTheSameId() để kiểm tả Id trùng lặp
            }
            String name = CheckInputData.checkInputName("Mời bạn nhập tên học sinh: ");
            double mark = CheckInputData.checkInputMark("Mời bạn nhập điểm học sinh: ", 1, 10);
            String email = CheckInputData.checkInputEmail("Mời bạn nhập email học sinh: ");
            String dateOfBirth = CheckInputData.checkInputDateOfBirth("Mời bạn nhập ngày sinh học sinh: ");
            Student product = new Student(id, name, mark, email, dateOfBirth);
            studentRepository.addStudent(product);
            System.out.println("Thêm mới thành công!!!");
            String message = "Bạn có muốn thêm một học sinh nào khác không? (Y||N)";
            if (Validation.confirm(message)) continue;
            else return;
//          thêm học sinh vừa tạo vào list
        }
    }

    @Override
    public void editById(int idEdit) {
        Scanner scanner = new Scanner(System.in);
        List<Student> students = studentRepository.getList();
        List<String> stringList = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() == idEdit) {
                flag = true;
                System.out.println("Đã tìm thấy học sinh!!!");
                while (true) {
                    System.out.println("1. Sửa tên học sinh" +
                            "\n2. Sửa điểm học sinh" +
                            "\n3. Sửa email học sinh" +
                            "\n4. Sửa ngày sinh học sinh");
                    int option = CheckInputData.checkInputOption("Mời bạn thông tin cần sửa: ", 1, 5);
                    switch (option) {
                        case 1: {
                            students.get(i).setName(CheckInputData.checkInputName("Mời bạn nhập tên mới: "));
                            break;
                        }
                        case 2: {
                            students.get(i).setMark(CheckInputData.checkInputMark("Mời bạn nhập điểm mới: ", 1, 10));
                            break;
                        }
                        case 3: {
                            students.get(i).setEmail(CheckInputData.checkInputEmail("Mời bạn nhập email mới: "));
                            break;
                        }
                        case 4: {
                            System.out.println("Mời bạn nhập ngày sinh mới :");
                            students.get(i).setDateOfBirth(scanner.nextLine());
                            break;
                        }
                    }
                    System.out.println("Đã sửa thông tin thành công!!!");
                    String message = "Bạn có muốn sửa thêm thông tin nào không?(Y||N)";
                    if (Validation.confirm(message)) continue;
                    else break;
                }
            }
        }

        for (Student s : students) {
            stringList.add(s.getInfoToCSV());
        }
        studentRepository.editById(stringList);

        if (!flag) System.out.println("Không tìm thấy học sinh tương ứng!!!");
    }

    @Override
    public void deleteById(int idDel) {
        List<Student> students = studentRepository.getList();
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getId() != idDel) {
                stringList.add(students.get(i).getInfoToCSV());
            }
        }
        studentRepository.deleteById(stringList);
        if (students.size() != stringList.size()) System.out.println("Đã xóa thành công!!!");
        else System.out.println("Không tìm thấy học sinh tương ứng!!!");
    }

    @Override
    public void findByName(String nameFind) {
        boolean flag = false;
        List<Student> products = studentRepository.getList();
        for (Student s : products) {
            if (s.getName().contains(nameFind)) {
                flag = true;
                System.out.println("Đã tìm thấy học sinh!!!");
                break;
            }
        }

        if (!flag) System.out.println("Không tìm thấy học sinh tương ứng!!!");
    }
}
