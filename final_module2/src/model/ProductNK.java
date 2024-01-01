package model;

public class ProductNK extends Product {
    private double giaNhapKhau;
    private String tinhThanh;
    private double thue;

    public ProductNK() {
    }

    public ProductNK(double giaNhapKhau, String tinhThanh, double thue) {
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanh = tinhThanh;
        this.thue = thue;
    }

    public ProductNK(String ma, String ten, double gia, int soLuong, String nhaSanXuat, double giaNhapKhau, String tinhThanh, double thue) {
        super(ma, ten, gia, soLuong, nhaSanXuat);
        this.giaNhapKhau = giaNhapKhau;
        this.tinhThanh = tinhThanh;
        this.thue = thue;
    }

    public double getGiaNhapKhau() {
        return giaNhapKhau;
    }

    public void setGiaNhapKhau(double giaNhapKhau) {
        this.giaNhapKhau = giaNhapKhau;
    }

    public String getTinhThanh() {
        return tinhThanh;
    }

    public void setTinhThanh(String tinhThanh) {
        this.tinhThanh = tinhThanh;
    }

    public double getThue() {
        return thue;
    }

    public void setThue(double thue) {
        this.thue = thue;
    }

    @Override
    public String toString() {
        return "ProductNK{" +
                "giaNhapKhau=" + giaNhapKhau +
                ", tinhThanh='" + tinhThanh + '\'' +
                ", thue=" + thue +
                '}';
    }

    @Override
    public String getInfoToCSV() {
        return super.getInfoToCSV() + "," + this.getGiaNhapKhau() + "," + this.getTinhThanh() + "," + this.getThue();
    }
}
