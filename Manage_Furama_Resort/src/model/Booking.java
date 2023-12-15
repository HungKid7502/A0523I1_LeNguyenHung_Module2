package model;

public class Booking {
    private int idBooking;
    private int idCustomer;
    private int idService;
    private String dateBooking;
    private String rentalStartDate;
    private String rentalEndDate;

    public Booking() {
    }

    public Booking(int idBooking, int idCustomer, int idService, String dateBooking, String rentalStartDate, String rentalEndDate) {
        this.idBooking = idBooking;
        this.idCustomer = idCustomer;
        this.idService = idService;
        this.dateBooking = dateBooking;
        this.rentalStartDate = rentalStartDate;
        this.rentalEndDate = rentalEndDate;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idBooking=" + idBooking +
                ", idCustomer=" + idCustomer +
                ", idService=" + idService +
                ", dateBooking='" + dateBooking + '\'' +
                ", rentalStartDate='" + rentalStartDate + '\'' +
                ", rentalEndDate='" + rentalEndDate + '\'' +
                '}';
    }
}
