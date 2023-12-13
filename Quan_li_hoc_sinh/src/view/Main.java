package view;

import controller.StudentController;
import util.CheckInputData;
import java.util.Scanner;

public class Main {
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int EDIT = 4;
    private static final int FIND = 5;

    private static Main main = new Main();

    private static StudentController studentController = new StudentController();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("\nChương trình quản lí học sinh");
            Menu.showMenu();
            int choice = CheckInputData.checkInputOption("Mời bạn chọn chức năng quản lí: ", 1, 6);
            switch (choice) {
                case DISPLAY: {
                    System.out.println("-----Danh sách học sinh-----");
                    studentController.display();
                    break;
                }
                case ADD: {
                    System.out.println("-----Chức năng thêm học sinh-----");
                    studentController.addStudent();
                    break;
                }
                case EDIT: {
                    System.out.println("-----Chức năng chỉnh sửa học sinh-----");
                    int idEdit = main.editById();
                    studentController.editById(idEdit);
                    break;
                }
                case DELETE: {
                    System.out.println("-----Chức năng xóa học sinh-----");
                    int idDel = main.deleteById();
                    studentController.deleteById(idDel);
                    break;
                }
                case FIND: {
                    System.out.println("-----Chức năng tìm kiếm học sinh-----");
                    String nameFind = main.findByName();
                    studentController.findByName(nameFind);
                }
                default: {
                    flag = false;
                    System.exit(0);
                }
            }
        } while (flag);
    }

    public int editById() {
        return CheckInputData.checkInputId("Nhập id học sinh cần sửa: ", 1);
    }

    public int deleteById() {
        return CheckInputData.checkInputId("Nhập id học sinh cần xóa: ", 1);
    }

    public String findByName() {
        return CheckInputData.checkInputName("Nhập tên học sinh cần tìm kiếm: ");
    }
}
