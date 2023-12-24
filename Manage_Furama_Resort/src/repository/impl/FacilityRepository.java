package repository.impl;

import model.modelfacility.Facility;
import model.modelfacility.House;
import model.modelfacility.Room;
import model.modelfacility.Villa;
import repository.IFacilityRepository;
import util.ReadAndWriteFile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class FacilityRepository implements IFacilityRepository<Facility> {
    static Map<Facility, Integer> facilityIntegerMap = new LinkedHashMap<>();
    private final String FACILITY_FILE_PATH = "D:\\C0723L1_LeNguyenHung_Module2\\Manage_Furama_Resort\\src\\data\\facility.csv";
    @Override
    public void add(Facility facility) {
        List<String> stringList = new ArrayList<>();
        stringList.add(facility.getInfoToCSV());
        ReadAndWriteFile.writeToFile(FACILITY_FILE_PATH, stringList, false);
    }

    @Override
    public List<Facility> getList() {
        List<String> stringList = ReadAndWriteFile.readFromFile(FACILITY_FILE_PATH);
        List<Facility> facilityList = new ArrayList<>();
        String[] array = null;
        for (String s: stringList) {
            array = s.split(",");
            if (array[0].contains("SVVL")) {
//                public Villa(String idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String roomStandards, double areaPool, int numFloor) {
                Facility facility = new Villa(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Double.parseDouble(array[7]), Integer.parseInt(array[8]));
                facilityList.add(facility);
            } else if (array[0].contains("SVHO")) {
//                String idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String roomStandards, int numFloor
                Facility facility = new House(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6], Integer.parseInt(array[7]));
                facilityList.add(facility);
            } else {
//                String idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String freeService
                Facility facility = new Room(array[0], array[1], Double.parseDouble(array[2]), Double.parseDouble(array[3]), Integer.parseInt(array[4]), array[5], array[6]);
                facilityList.add(facility);
            }
        }
        return facilityList;
    }
}
