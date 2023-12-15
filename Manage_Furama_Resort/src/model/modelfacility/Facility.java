package model.modelfacility;

public abstract class Facility {
    private int idService;
    private String nameService;
    private double usableArea;
    private double price;
    private int maxNumPeople;
    private String retalType;

    public Facility() {
    }

    public Facility(int idService, String nameService, double usableArea, double price, int maxNumPeople, String retalType) {
        this.idService = idService;
        this.nameService = nameService;
        this.usableArea = usableArea;
        this.price = price;
        this.maxNumPeople = maxNumPeople;
        this.retalType = retalType;
    }

    public int getIdService() {
        return idService;
    }

    public void setIdService(int idService) {
        this.idService = idService;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public double getUsableArea() {
        return usableArea;
    }

    public void setUsableArea(double usableArea) {
        this.usableArea = usableArea;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getMaxNumPeople() {
        return maxNumPeople;
    }

    public void setMaxNumPeople(int maxNumPeople) {
        this.maxNumPeople = maxNumPeople;
    }

    public String getRetalType() {
        return retalType;
    }

    public void setRetalType(String retalType) {
        this.retalType = retalType;
    }

    @Override
    public String toString() {
        return "Facility{" +
                "idService=" + idService +
                ", nameService='" + nameService + '\'' +
                ", usableArea=" + usableArea +
                ", price=" + price +
                ", maxNumPeople=" + maxNumPeople +
                ", retalType='" + retalType + '\'' +
                '}';
    }
}
