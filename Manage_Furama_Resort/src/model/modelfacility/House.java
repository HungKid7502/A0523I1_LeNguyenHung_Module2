package model.modelfacility;

public class House extends Facility{
    private String roomStandards;
    private int numFloor;

    public House() {
    }

    public House(int idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String roomStandards, int numFloor) {
        super(idService, nameService, usableArea, price, maxNumPeople, retalType);
        this.roomStandards = roomStandards;
        this.numFloor = numFloor;
    }

    public String getRoomStandards() {
        return roomStandards;
    }

    public void setRoomStandards(String roomStandards) {
        this.roomStandards = roomStandards;
    }

    public int getNumFloor() {
        return numFloor;
    }

    public void setNumFloor(int numFloor) {
        this.numFloor = numFloor;
    }

    @Override
    public String toString() {
        return "House{" +
                "roomStandards='" + roomStandards + '\'' +
                ", numFloor=" + numFloor +
                '}';
    }
}
