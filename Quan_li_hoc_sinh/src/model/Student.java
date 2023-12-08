package model;

public class Student {
  private int id;
  private String name;
  private double mark;
  private String capacity;

  public Student() {
  }

  public Student(int id, String name, double mark, String capacity) {
    this.id = id;
    this.name = name;
    this.mark = mark;
    this.capacity = capacity;
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

  public String getCapacity() {
    return capacity;
  }

  public void setCapacity(String capacity) {
    this.capacity = capacity;
  }

  @Override
  public String toString() {
    return "Product{" +
      "id=" + id +
      ", name='" + name + '\'' +
      ", mark=" + mark +
      ", capacity='" + capacity + '\'' +
      '}';
  }

  public String getInfoToCSV() {
    return this.id + ";" + this.name + ";" + this.mark + ";" + this.capacity;
  }
}
