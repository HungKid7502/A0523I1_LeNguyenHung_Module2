package model;

public class Student {
  private int id;
  private String name;
  private double mark;
  private String email;

  private String dateOfBirth;

  public Student() {
  }

  public Student(int id, String name, double mark, String email, String dateOfBirth) {
    this.id = id;
    this.name = name;
    this.mark = mark;
    this.email = email;
    this.dateOfBirth = dateOfBirth;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public double getMark() {
    return mark;
  }

  public void setMark(double mark) {
    this.mark = mark;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(String dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", mark=" + mark +
            ", email='" + email + '\'' +
            ", dateOfBirth='" + dateOfBirth + '\'' +
            '}';
  }

  public String getInfoToCSV() {
    return this.id + ";" + this.name + ";" + this.mark + ";" + this.email + ";" + this.dateOfBirth;
  }
}
