package model.modelperson;

public class Employee extends Person {
    private String level;
    //    Trung cấp, cao đẳng, đại học, sau đại học
    private String position;
    //    Lễ tân, phục vụ, chuyên viên, giám sát, quản lý, giám đốc
    private double salary;

    public Employee() {
    }

    public Employee(String id, String name, String dateOfBirth, String gender, String cmnd, String phoneNumber, String email, String level, String position, double salary) {
        super(id, name, dateOfBirth, gender, cmnd, phoneNumber, email);
        this.level = level;
        this.position = position;
        this.salary = salary;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "level=" + level +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                '}';
    }

    public String getInfoToCSV() {
        return this.getId() + ";" + this.getName() + ";" + this.getDateOfBirth() + ";" + this.getGender() + ";" + this.getCMND() + this.getPhoneNumber()
                + ";" + this.getEmail() + ";" + this.getLevel() + ";" + this.getPosition() + ";" + this.getSalary();
    }
}
