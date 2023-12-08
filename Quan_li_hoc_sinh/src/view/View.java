package view;

import controller.ProductController;
import util.Validation;
import java.util.Scanner;

public class View {
  private static final int DISPLAY = 1;
  private static final int ADD = 2;
  private static final int DELETE = 3;
  private static final int EDIT = 4;
  private static final int FIND = 5;

  private static View view = new View();

  private static Scanner scanner = new Scanner(System.in);

  private static ProductController productController = new ProductController();

  private static Validation validation = new Validation();

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    boolean flag = true;
    do {
      System.out.println("\nChương trình quản lí học sinh");
      System.out.println("\n1. Hiển thị danh sách học sinh" +
        "\n2. Thêm học sinh" +
        "\n3. Xóa học sinh" +
        "\n4. Sửa học sinh" +
        "\n5. Tìm kiếm học sinh" +
        "\n6. Kết thúc chương trình" +
        "\nMời bạn chọn chức năng: ");
      int choice = Integer.parseInt(scanner.nextLine());
      switch (choice) {
        case DISPLAY: {
          System.out.println("-----Danh sách học sinh-----");
          productController.display();
          break;
        }
        case ADD: {
          System.out.println("-----Chức năng thêm học sinh-----");
          productController.addStudent();
          break;
        }
        case EDIT: {
          System.out.println("-----Chức năng chỉnh sửa học sinh-----");
          int idEdit = view.editById();
          productController.editById(idEdit);
          break;
        }
        case DELETE: {
          System.out.println("-----Chức năng xóa học sinh-----");
          int idDel = view.deleteById();
          productController.deleteById(idDel);
          break;
        }
        case FIND: {
          System.out.println("-----Chức năng tìm kiếm học sinh-----");
          String nameFind = view.findByName();
          productController.findByName(nameFind);
        }
        default: {
          flag = false;
          System.exit(0);
        }
      }
    } while (flag);
  }

  public int editById() {
    return validation.getInt("Nhập id học sinh cần sửa: ", 1);
  }

  public int deleteById() {
    return validation.getInt("Nhập id học sinh cần xóa: ", 1);
  }

  public String findByName() {
    return validation.getString("Nhập tên học sinh cần tìm kiếm: ");
  }
}
