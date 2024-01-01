package model;

public class ProductXK extends Product {
    private double giaXuatKhau;
    private String quocGia;

    public ProductXK() {
    }

    public ProductXK(double giaXuatKhau, String quocGia) {
        this.giaXuatKhau = giaXuatKhau;
        this.quocGia = quocGia;
    }

    public ProductXK(String ma, String ten, double gia, int soLuong, String nhaSanXuat, double giaXuatKhau, String quocGia) {
        super(ma, ten, gia, soLuong, nhaSanXuat);
        this.giaXuatKhau = giaXuatKhau;
        this.quocGia = quocGia;
    }

    public double getGiaXuatKhau() {
        return giaXuatKhau;
    }

    public void setGiaXuatKhau(double giaXuatKhau) {
        this.giaXuatKhau = giaXuatKhau;
    }

    public String getQuocGia() {
        return quocGia;
    }

    public void setQuocGia(String quocGia) {
        this.quocGia = quocGia;
    }

    @Override
    public String toString() {
        return "ProductXK{" +
                "giaXuatKhau=" + giaXuatKhau +
                ", quocGia='" + quocGia + '\'' +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.giaXuatKhau + "," + this.getQuocGia();
    }
}
