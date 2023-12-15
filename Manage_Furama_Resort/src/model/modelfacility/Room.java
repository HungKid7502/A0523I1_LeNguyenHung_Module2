package model.modelfacility;

public class Room extends Facility{
    private String freeService;

    public Room() {
    }

    public Room(int idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType, String freeService) {
        super(idService, nameService, usableArea, price, maxNumPeople, retalType);
        this.freeService = freeService;
    }

    public String getFreeService() {
        return freeService;
    }

    public void setFreeService(String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString() {
        return "Room{" +
                "freeService='" + freeService + '\'' +
                '}';
    }
}
