package controller;

import service.IBookingService;
import service.ICustomerService;
import service.IEmployeeService;
import service.IFacilityService;
import service.impl.BookingService;
import service.impl.CustomerService;
import service.impl.EmployeeService;
import service.impl.FacilityService;
import util.InputDataValidate;

public class FuramaController {
    private final int EMPLOYEE = 1;
    private final int CUSTOMER = 2;
    private final int FACILITY = 3;
    private final int BOOKING = 4;
    private final int PROMOTION = 5;

    private static IEmployeeService employeeService = new EmployeeService();
    private static ICustomerService customerService = new CustomerService();
    private static IFacilityService facilityService = new FacilityService();
    private static IBookingService bookingService = new BookingService();


    public void displayMainMenu() {
        boolean flag = true;
        do {
            System.out.println("Chương trình quản lí Furama Resort");
            Menu.menuMain();
            int choice = InputDataValidate.checkInputOption("Mời bạn nhập thông tin cần quản lí: ", 1, 6);
            switch (choice) {
                case EMPLOYEE: {
                    menuEmployeeManagement();
                    break;
                }
                case CUSTOMER: {
                    menuCustomerManagement();
                    break;
                }
                case FACILITY: {
                    menuFacilityManagement();
                    break;
                }
                case BOOKING: {
                    menuBookingManagement();
                    break;
                }
                case PROMOTION: {
                    menuPromtionManagement();
                    break;
                }
                default: {
                    flag = false;
                    System.exit(0);
                }
            }
        } while (flag);
    }

    public void menuEmployeeManagement() {
        boolean flag = true;
        System.out.println("Quản lí nhân viên");
        do {
            System.out.println("1. Hiển thị danh sách nhân viên" +
                    "\n2. Thêm mới nhân viên" +
                    "\n3. Chỉnh sửa nhân viên" +
                    "\n4. Trở lại menu chính");
            int newChoice = InputDataValidate.checkInputOption("Mời bạn nhập lựa chọn: ", 1, 4);
            switch (newChoice) {
                case 1: {
                    System.out.println("Chức năng hiển thị danh sách nhân viên");
                    employeeService.display();
                    break;
                }
                case 2: {
                    System.out.println("Chức năng thêm mới nhân viên");
                    employeeService.add();
                    break;
                }
                case 3: {
                    break;

                }
                case 4: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public void menuCustomerManagement() {
        boolean flag = true;
        System.out.println("Quản lí khách hàng");
        do {
            System.out.println("1. Hiển thị danh sách khách hàng" +
                    "\n2. Thêm mới khách hàng" +
                    "\n3. Chỉnh sửa khách hàng" +
                    "\n4. Trở lại menu chính");
            int newChoice = InputDataValidate.checkInputOption("Mời bạn nhập lựa chọn: ", 1, 4);
            switch (newChoice) {
                case 1: {
                    System.out.println("Chức năng hiển thị danh sách khách hàng");
                    customerService.display();
                    break;
                }
                case 2: {
                    System.out.println("Chức năng thêm mới khách hàng");
                    customerService.add();
                    break;
                }
                case 3: {

                }
                case 4: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public void menuFacilityManagement() {
        boolean flag = true;
        System.out.println("Quản lí cơ sở vật chất");
        do {
            System.out.println("1. Hiển thị danh sách cơ sở vật chất" +
                    "\n2. Thêm mới cơ sở vật chất" +
                    "\n3. Hiển thị danh sách cơ sở vật chất đang bảo trì" +
                    "\n4. Trở lại menu chính");
            int newChoice = InputDataValidate.checkInputOption("Mời bạn nhập lựa chọn:", 1, 4);
            switch (newChoice) {
                case 1: {
                    System.out.println("Chức năng hiển thị danh sách cơ sở vật chất");
                    facilityService.displayFacility();
                    break;
                }
                case 2: {
                    System.out.println("Chức năng thêm mới cơ sở vật chất");
                    facilityService.addFacility();
                    break;
                }
                case 3: {

                }
                case 4: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public void menuBookingManagement() {
        boolean flag = true;
        System.out.println("Booking Management");
        do {
            System.out.println("1. Display list bookings" +
                    "\n2. Add new booking" +
                    "\n3. Create new contracts" +
                    "\n4. Display list contracts" +
                    "\n5. Edit contracts" +
                    "\n6. Return main menu");
            int newChoice = InputDataValidate.checkInputOption("Please choose the management information: ", 1, 4);
            switch (newChoice) {
                case 1: {

                }
                case 2: {

                }
                case 3: {

                }
                case 4: {


                }
            }
        } while (flag);
    }


    public void menuPromtionManagement() {
        boolean flag = true;
        do {
            System.out.println("1. Display list customers use service" +
                    "\n2. Display list customers get voucher" +
                    "\n3. Return main menu");
            int newChoice = InputDataValidate.checkInputOption("Please choose the management information: ", 1, 4);
            switch (newChoice) {
                case 1: {

                }
                case 2: {

                }
                case 3: {

                }
                case 4: {


                }
            }
        } while (flag);
    }

}
