package controller;

public class Menu {
    public static void menuMain() {
        String[] menu = {"1. Quản lí nhân viên", "2. Quản lí khách hàng", "3. Quản lí cơ sở vật chất", "4. Quản lí booking", "5. Quản lí khuyến mãi", "6. Kết thúc chương trình"};
        for (String s : menu) {
            System.out.println(s);
        }
    }
}
