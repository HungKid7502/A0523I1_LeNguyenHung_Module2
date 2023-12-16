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
            int choice = InputDataValidate.checkInputOption("Please choose the management information: ", 1, 6);
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
                }
                case PROMOTION: {
                    menuPromtionManagement();
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
        System.out.println("Employee Management");
        do {
            System.out.println("1. Display list employees" +
                    "\n2. Add new employee" +
                    "\n3. Edit employee" +
                    "\n4. Return main menu");
            int newChoice = InputDataValidate.checkInputOption("Please choose the management function: ", 1, 4);
            switch (newChoice) {
                case 1: {
                    employeeService.display();
                    break;
                }
                case 2: {
                    employeeService.add();
                    break;
                }
                case 3: {
                    break;

                }
                case 4: {
                    break;
                }
            }
        } while (flag);
    }

    public void menuCustomerManagement() {
        boolean flag = true;
        System.out.println("Customer Management");
        do {
            System.out.println("1. Display list customers" +
                    "\n2. Add new customer" +
                    "\n3. Edit customer" +
                    "\n4. Return main menu");
            int newChoice = InputDataValidate.checkInputOption("Please choose the management information: ", 1, 4);
            switch (newChoice) {
                case 1: {
                    customerService.display();
                    break;
                }
                case 2: {
                    customerService.add();
                }
                case 3: {

                }
                case 4: {


                }
            }
        } while (flag);
    }

    public void menuFacilityManagement() {
        boolean flag = true;
        System.out.println("Facility Management");
        do {
            System.out.println("1. Display list facilities" +
                    "\n2. Add new facility" +
                    "\n3. Display list facility maintenance" +
                    "\n4. Return main menu");
            int newChoice = InputDataValidate.checkInputOption("Mời bạn chọc chức năng quản lí:", 1, 4);
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
            int newChoice = InputDataValidate.checkInputOption("Mời bạn chọc chức năng quản lí:", 1, 4);
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
            int newChoice = InputDataValidate.checkInputOption("Mời bạn chọc chức năng quản lí:", 1, 4);
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
