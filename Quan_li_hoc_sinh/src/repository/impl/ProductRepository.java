package repository.impl;

import model.Student;
import repository.IProductRepository;
import util.ReadAndWriteFile;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductRepository implements IProductRepository {
  private final String FILE_PATH = "D:\\C0723L1_LeNguyenHung_Module2\\Quan_li_hoc_sinh\\src\\data\\data.csv";

  private ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
  private static Scanner scanner = new Scanner(System.in);
  private static List<Student> productList = new ArrayList<>();

  @Override
  public List<Student> getList() {
    List<String> stringList = readAndWriteFile.readFromFile(FILE_PATH);
    List<Student> students = new ArrayList<>();
    String[] array = null;
    for (String o: stringList) {
      array = o.split(";");
      students.add(new Student(Integer.parseInt(array[0]), array[1], Double.parseDouble(array[2]), array[3]));
    }
    return students;
  }

  @Override
  public void addStudent(Student product) {
    List<String> stringList = new ArrayList<>();
    stringList.add(product.getInfoToCSV());
    readAndWriteFile.writeToFile(FILE_PATH, stringList, true);
  }

  @Override
  public void editById(int index) {
    System.out.println("1. Sửa tên học sinh" +
      "\n2. Sửa điểm học sinh" +
      "\n3. Sửa năng lực học sinh" +
      "\nMời bạn chọn thông tin cần sửa: ");
    int option = Integer.parseInt(scanner.nextLine());
    switch (option) {
      case 1: {
        System.out.println("Tên mới: ");
        productList.get(index).setName(scanner.nextLine());
        break;
      }
      case 2: {
        System.out.println("Điểm mới: ");
        productList.get(index).setMark(Double.parseDouble(scanner.nextLine()));
        break;
      }
      case 3: {
        System.out.println("Năng lực mới: ");
        productList.get(index).setCapacity(scanner.nextLine());
        break;
      }
    }
  }

  @Override
  public void deleteById(List<String> stringList) {
    readAndWriteFile.writeToFile(FILE_PATH, stringList, false);
  }
}



