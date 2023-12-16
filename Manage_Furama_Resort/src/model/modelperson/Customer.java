package model.modelperson;

public class Customer extends Person {
    private String typeCustomer;
//    Diamond, Platinum, Gold, Silver, Member
    private String address;

    public Customer() {
    }

    public Customer(String id, String name, String dateOfBirth, String gender, String CMND, String phoneNumber, String email, String typeCustomer, String address) {
        super(id, name, dateOfBirth, gender, CMND, phoneNumber, email);
        this.typeCustomer = typeCustomer;
        this.address = address;
    }

    public String getTypeCustomer() {
        return typeCustomer;
    }

    public void setTypeCustomer(String typeCustomer) {
        this.typeCustomer = typeCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "typeCustomer='" + typeCustomer + '\'' +
                ", address='" + address + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.getTypeCustomer() + "," + this.getAddress();
    }
}
