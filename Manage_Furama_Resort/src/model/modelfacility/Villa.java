package model.modelfacility;

public class Villa extends Facility{
    private String roomStandards;
    private double areaPool;
    private int numFloor;

    public Villa() {
    }

    public Villa(String idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String roomStandards, double areaPool, int numFloor) {
        super(idService, nameService, usableArea, price, maxNumPeople, retalType);
        this.roomStandards = roomStandards;
        this.areaPool = areaPool;
        this.numFloor = numFloor;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public double getAreaPool() {
        return areaPool;
    }

    public void setAreaPool(double areaPool) {
        this.areaPool = areaPool;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "roomStandards='" + roomStandards + '\'' +
                ", areaPool=" + areaPool +
                ", numFloor=" + numFloor +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.roomStandards + "," + this.areaPool + "," + this.numFloor;
    }
}
