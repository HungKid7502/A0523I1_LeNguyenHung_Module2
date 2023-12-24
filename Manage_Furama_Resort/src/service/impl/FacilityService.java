package service.impl;

import model.modelfacility.Facility;
import model.modelfacility.House;
import model.modelfacility.Room;
import model.modelfacility.Villa;
import repository.IFacilityRepository;
import repository.impl.FacilityRepository;
import service.IFacilityService;
import util.InputDataValidate;

import java.util.*;

public class FacilityService implements IFacilityService {
    private final String ID_VILLA_REGEX = "^([S][V][V][L])\\-\\d{4}$";
    private final String ID_HOUSE_REGEX = "^([S][V][H][O])\\-\\d{4}$";
    private final String ID_ROOM_REGEX = "^([S][V][R][O])\\-\\d{4}$";
    private final String NAME_SERVICE_REGEX = "^[A-Z][a-z]+$";

    private final IFacilityRepository facilityRepository = new FacilityRepository();

    @Override
    public void displayFacility() {
//        Map<Facility, Integer> facilityItegerMap = facilityRepository.getList();
        List<Facility> facilities = facilityRepository.getList();
//        for (Map.Entry<Facility, Integer> entryFacility : facilityItegerMap.entrySet()) {
//            System.out.println("Facility: " + entryFacility.getKey() + ". Số lần sử dụng: " + entryFacility.getValue());
//        }
        for (Facility facility: facilities) {
            System.out.println(facility.getInfoToCSV());
        }
    }

    @Override
    public void addFacility() {
        boolean flag = true;
        do {
            System.out.println("1. Thêm mới villa" +
                    "\n2. Thêm mới house" +
                    "\n3. Thêm mới room" +
                    "\n4. Back to menu");
            int choice = InputDataValidate.checkInputOption("Mời bạn nhập lựa chọn: ", 1, 4);
            switch (choice) {
                case 1: {
                    addNewVilla();
                    break;
                }
                case 2: {
                    addNewHouse();
                    break;

                }
                case 3: {
                    addNewRoom();
                    break;

                }
                default: {
                    flag = false;
                }
            }
        } while (flag);
    }

    public void addNewVilla() {
        String idService;
        String nameService;
        double usableArea;
        double price;
        int maxNumPeople;
        String retalType;
        String roomStandards;
        double areaPool;
        int numFloor;
        while (true) {
            System.out.println("Information of the villa");
            idService = InputDataValidate.checkInputDataRegex("Mời bạn nhập mã dịch vụ: ", ID_VILLA_REGEX, "Xin lỗi!!!Mã nhân viên phải đúng định dạng SVXX, YYYY là số 0-9, XX phải là \'VL\'!!!");
            nameService = InputDataValidate.checkInputDataRegex("Mời bạn nhập tên dịch vụ: ", NAME_SERVICE_REGEX, "Xin lỗi!!!Tên dịch vụ phải bắt đầu bằng kí tự in hoa, các kí tự khác thì bình thường !!!");
            while (true) {
                usableArea = InputDataValidate.checkInputDouble("Mời bạn nhập diện tích sử dụng:", "Diện tích sử dụng");
                if (usableArea <= 30) {
                    System.out.println("Xin lỗi!!!Diện tích sử dụng phải từ 30m2 trở lên");
                    continue;
                }
                break;
            }
            while (true) {
                areaPool = InputDataValidate.checkInputDouble("Mời bạn nhập diện tích hồ bơi:", "Diện tích hồ bơi");
                if (areaPool <= 30) {
                    System.out.println("Xin lỗi!!!Diện tích hồ bơi phải từ 30m2 trở lên");
                    continue;
                }
                break;
            }
            price = InputDataValidate.checkInputDouble("Mời bạn nhập giá tiền: ", 0, "Price");
            maxNumPeople = InputDataValidate.checkInputInt("Mời bạn nhập số lượng người tối đa: ", 1, 20, "Number of people must be from 1 to <20!!!");
            roomStandards = InputDataValidate.checkInputDataRegex("Please enter room standards: ", NAME_SERVICE_REGEX, "The room standards must have the first letter capitalized, the next characters are normal!!!");
            retalType = InputDataValidate.checkInputDataRegex("Please enter retal type: ", NAME_SERVICE_REGEX, "The retal type must have the first letter capitalized, the next characters are normal!!!");
            numFloor = InputDataValidate.checkInputInt("Please enter number of floors: ", 0, 3, "Number of floors must be from 1 to 3!!!");
            Villa villa = new Villa(idService, nameService, usableArea, price, maxNumPeople, retalType, roomStandards, areaPool, numFloor);
            facilityRepository.add(villa);
            System.out.println("Thêm mới villa thành công!!!");

            String mess = "Bạn có muốn thêm mới villa khác không? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }

    public void addNewHouse() {
        String idService;
        String nameService;
        double usableArea;
        double price;
        int maxNumPeople;
        String retalType;
        String roomStandards;
        int numFloor;
        while (true) {
            System.out.println("Information of the house");
            idService = InputDataValidate.checkInputDataRegex("Please enter service id: ", ID_HOUSE_REGEX, "Service id HOUSE must be in the correct format SVXX-YYYY, YYYY is numbers 0-9, XX must be \'HO\'!!!");
            nameService = InputDataValidate.checkInputDataRegex("Please enter service name: ", NAME_SERVICE_REGEX, "The service name must have the first letter capitalized, the next characters are normal!!!");
            usableArea = InputDataValidate.checkInputDouble("Please enter usable area: ", 30, "Usable area");
            price = InputDataValidate.checkInputDouble("Pleae enter price: ", 0, "Price");
            maxNumPeople = InputDataValidate.checkInputInt("Please enter maximum number of peoples: ", 1, 20, "Number of people must be from 1 to <20!!!");
            roomStandards = InputDataValidate.checkInputDataRegex("Please enter room standards: ", NAME_SERVICE_REGEX, "The room standards must have the first letter capitalized, the next characters are normal!!!");
            retalType = InputDataValidate.checkInputDataRegex("Please enter retal type: ", NAME_SERVICE_REGEX, "The retal type must have the first letter capitalized, the next characters are normal!!!");
            numFloor = InputDataValidate.checkInputInt("Please enter number of floors: ", 0, 3, "Number of floors must be from 1 to 3!!!");
            House house = new House(idService, nameService, usableArea, price, maxNumPeople, retalType, roomStandards, numFloor);
            facilityRepository.add(house);
            System.out.println("Thêm mới house thành công!!!");

            String mess = "Bạn có muốn thêm mới house khác không? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }

    public void addNewRoom() {
        String idService;
        String nameService;
        double usableArea;
        double price;
        int maxNumPeople;
        String retalType;
        String freeService;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            idService = InputDataValidate.checkInputDataRegex("Please enter service id: ", ID_ROOM_REGEX, "Service id HOUSE must be in the correct format SVXX-YYYY, YYYY is numbers 0-9, XX must be \'HO\'!!!");
            nameService = InputDataValidate.checkInputDataRegex("Please enter service name: ", NAME_SERVICE_REGEX, "The service name must have the first letter capitalized, the next characters are normal!!!");
            usableArea = InputDataValidate.checkInputDouble("Please enter usable area: ", 30, "Usable area");
            price = InputDataValidate.checkInputDouble("Pleae enter price: ", 0, "Price");
            maxNumPeople = InputDataValidate.checkInputInt("Please enter maximum number of peoples: ", 1, 20, "Number of people must be from 1 to <20!!!");
            retalType = InputDataValidate.checkInputDataRegex("Please enter retal type: ", NAME_SERVICE_REGEX, "The retal type must have the first letter capitalized, the next characters are normal!!!");
            System.out.println("Please enter free service included: ");
            freeService = scanner.nextLine();
            Room room = new Room(idService, nameService, usableArea, price, maxNumPeople, retalType, freeService);
            facilityRepository.add(room);
            System.out.println("Thêm mới room thành công!!!");

            String mess = "Bạn có muốn thêm mới room khác không? (Y||N)";
            if (InputDataValidate.confirm(mess)) continue;
            else break;
        }
    }
}
