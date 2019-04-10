package Enity;

public class order_Demo {
    private String loaixe;
    private int gia;
    private double khoangcach;
    private String diemdi;
    private String diemden;

    public order_Demo(String loaixe, int gia, double khoangcach, String diemdi, String diemden) {
        this.loaixe = loaixe;
        this.gia = gia;
        this.khoangcach = khoangcach;
        this.diemdi = diemdi;
        this.diemden = diemden;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public double getKhoangcach() {
        return khoangcach;
    }

    public void setKhoangcach(double khoangcach) {
        this.khoangcach = khoangcach;
    }

    public String getDiemdi() {
        return diemdi;
    }

    public void setDiemdi(String diemdi) {
        this.diemdi = diemdi;
    }

    public String getDiemden() {
        return diemden;
    }

    public void setDiemden(String diemden) {
        this.diemden = diemden;
    }

}
