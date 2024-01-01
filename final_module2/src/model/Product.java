package model;

public abstract class Product {
    private static int idTang = 1;
    private int id;
    private String ma;
    private String ten;
    private double gia;
    private int soLuong;
    private String nhaSanXuat;

    public Product() {
    }

    public Product(String ma, String ten, double gia, int soLuong, String nhaSanXuat) {
        this.id = idTang;
        this.ma = ma;
        this.ten = ten;
        this.gia = gia;
        this.soLuong = soLuong;
        this.nhaSanXuat = nhaSanXuat;
        idTang++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public double getGia() {
        return gia;
    }

    public void setGia(double gia) {
        this.gia = gia;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public void setNhaSanXuat(String nhaSanXuat) {
        this.nhaSanXuat = nhaSanXuat;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", ma='" + ma + '\'' +
                ", ten='" + ten + '\'' +
                ", gia=" + gia +
                ", soLuong=" + soLuong +
                ", nhaSanXuat='" + nhaSanXuat + '\'' +
                '}';
    }

    public String getInfoToCSV() {
        return this.getId() + "," + this.getMa() + "," + this.getTen() + "," + this.getGia() + "," + this.getSoLuong() + "," + this.nhaSanXuat;
    }
}
