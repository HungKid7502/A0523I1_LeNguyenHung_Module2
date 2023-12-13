package view;

public class Menu {
    public static void showMenu() {
        String[] menu = {"\n1. Hiển thị danh sách học sinh",
                "2. Thêm học sinh",
                "3. Xóa học sinh" ,
                "4. Sửa học sinh",
                "5. Tìm kiếm học sinh",
                "6. Kết thúc chương trình",
                "Mời bạn chọn chức năng"};

        for (String s : menu) {
            System.out.println(s);
        }
    }
}
