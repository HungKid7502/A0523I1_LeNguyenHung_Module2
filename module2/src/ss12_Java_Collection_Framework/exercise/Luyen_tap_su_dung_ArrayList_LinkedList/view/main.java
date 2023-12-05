package ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.view;

import java.util.Scanner;
import ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.controller.ProductManager;
import ss12_Java_Collection_Framework.exercise.Luyen_tap_su_dung_ArrayList_LinkedList.controller.Validation;

public class main {
    private static final int DISPLAY = 1;
    private static final int ADD = 2;
    private static final int DELETE = 3;
    private static final int EDIT = 4;
    private static final int FIND = 5;
    private static final int SORT = 6;

    private static ProductManager productManager = new ProductManager();
    private static Validation vl = new Validation();

//    private static String menu[] = {"Hiển thị danh sách sản phẩm", "Thêm sản phẩm", "Sửa sản phẩm", "Xóa sản phẩm",
//            "Tìm kiếm sản phẩm", "Sắp xếp sản phẩm"};

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        do {
            System.out.println("\nChương trình quản lí sản phẩm");
            System.out.println("\n1. Hiển thị danh sách sản phẩm" +
                    "\n2. Thêm sản phẩm" +
                    "\n3. Xóa sản phẩm" +
                    "\n4. Sửa sản phẩm" +
                    "\n5. Tìm kiếm sản phẩm" +
                    "\n6. Sắp xếp sản phẩm" +
                    "\n7. Kết thúc chương trình" +
                    "\nMời bạn chọn chức năng: ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case DISPLAY: {
                System.out.println("-----Danh sách sản phẩm-----");
                productManager.display();
                break;
            }
            case ADD: {
                System.out.println("-----Thêm sản phẩm-----");
                productManager.addProduct();
                break;
            }
            case EDIT: {
                System.out.println("-----Sửa sản phẩm-----");
                int idEdit = getIdEdit();
                productManager.editById(idEdit);
                break;
            }
            case DELETE: {
                System.out.println("-----Xóa sản phẩm-----");
                int idDel = getIdDelete();
                productManager.deleteById(idDel);
                break;
            }
            case FIND: {
                System.out.println("-----Tìm kiếm sản phẩm-----");
                String nameFind = getNameFind();
                productManager.findByName(nameFind);
                break;
            }
            case SORT: {

            }
            default: {
                flag = false;
                System.exit(0);
            }
        }
    } while(flag);
}

    public static int getIdEdit() {
        return vl.getInt("Mời nhập id sản phẩm cần sửa: ", 1);
    }

    public static int getIdDelete() {
        return vl.getInt("Mời nhập id sản phẩm cần xóa: ", 1);
    }

    public static String getNameFind() {
        return vl.getString("Mời nhập tên sản phẩm cần xóa: ");
    }
}


