package service.impl;

import model.Student;
import repository.IProductRepository;
import repository.impl.ProductRepository;
import service.IProductService;
import util.Validation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductService implements IProductService {
  private IProductRepository productRepository = new ProductRepository();

  private Validation validation = new Validation();

  @Override
  public void display() {
    List<Student> students = productRepository.getList();
    System.out.println("| ++ Học sinh ++ | ++ Id ++ | ++ Tên ++ | ++ Điểm số ++ | ++ Năng lực ++  |");
    int stt = 0;
    for (Student o : students) {
      System.out.printf("| %-14s | %-8s | %-9s | %-13s | %-14s |\n",
        stt + 1, o.getId(), o.getName(), o.getMark(), o.getCapacity());
      stt++;
    }
  }

  @Override
  public void addStudent() {
    while (true) {
      Scanner scanner = new Scanner(System.in);
      System.out.println("-- Nhập thông tin học sinh --");
      int id;
      while (true) {
        id = validation.getInt("Mời nhập id học sinh: ", 1);
        if (checkId(id)) break;
//                gọi hàm checkId() để kiểm tả Id trùng lặp
        else continue;
      }
      String name = validation.getString("Mời bạn nhập tên học sinh: ");
      double mark = validation.getDouble("Mời bạn nhập điểm học sinh: ", 1, 10);
      System.out.println("Mời bạn nhập năng lực học sinh: ");
      String capacity = scanner.nextLine();
      Student product = new Student(id, name, mark, capacity);
      productRepository.addStudent(product);
      System.out.println("Thêm mới thành công!!!");
      String message = "Bạn có muốn thêm một học sinh nào khác không? (Y||N)";
      if (confirm(message)) continue;
      else return;
//          thêm học sinh vừa tạo vào list
    }
  }

  @Override
  public void editById(int idEdit) {
    List<Student> students = productRepository.getList();
    boolean flag = false;
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() == idEdit) {
        flag = true;
        System.out.println("Đã tìm thấy học sinh!!!");
        while (true) {
          productRepository.editById(i);
          System.out.println("Đã chỉnh sửa thành công!!!");
          String message = "Bạn có muốn sửa thêm thông tin nào không?";
          if (confirm(message)) continue;
          else return;
        }
      }
    }

    if (!flag) {
      System.out.println("Không tìm thấy học sinh tương ứng");
    }
  }

  @Override
  public void deleteById(int idDel) {
    List<Student> students = productRepository.getList();
    List<String> stringList = new ArrayList<>();
    for (int i = 0; i < students.size(); i++) {
      if (students.get(i).getId() != idDel) {
        stringList.add(students.get(i).getInfoToCSV());
      }
    }
    productRepository.deleteById(stringList);
    if (students.size() != stringList.size()) System.out.println("Đã xóa thành công!!!");
    else System.out.println("Không tìm thấy học sinh tương ứng!!!");
  }

  @Override
  public void findByName(String nameFind) {
    boolean flag = false;
    List<Student> products = productRepository.getList();
    for (Student o: products) {
      if (o.getName().contains(nameFind)) {
        flag = true;
        System.out.println("Đã tìm thấy học sinh!!!");
        break;
      }
    }

    if (!flag) System.out.println("Không tìm thấy học sinh tương ứng!!!");
  }

  public boolean checkId(int idCheck) {
    List<Student> products = productRepository.getList();
    for (Student o : products) {
      if (o.getId() == idCheck) {
        System.out.println("Id đã tồn tại!!!Vui lòng nhập lại");
        return false;
      }
    }
    return true;
  }
//    phương thức check Id trùng lặp

  public boolean confirm(String mess) {
    Scanner scanner = new Scanner(System.in);
    System.out.println(mess);
    String option = scanner.nextLine();
    if (option.equalsIgnoreCase("Y")) return true;
    else return false;
  }
//    phương thức lựa chọn yes or no
}
