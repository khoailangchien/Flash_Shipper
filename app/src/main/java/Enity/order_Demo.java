package Enity;

public class order_Demo {
    private String loaixe;
    private String dichvu;
    private int phiship;
    private int phithuho;
    private String loaihang;
    private int kichthuoc1;
    private int kichthuoc2;
    private int cannang;
    private boolean quaylai;
    private boolean giaotantay;
    private boolean hotrotaixe;
    private int status;
    private String note;
    private String diemdi;
    private String diemden;
    private double khoangcach;

    public order_Demo(String loaixe, String dichvu, int phiship, int phithuho, String loaihang, int kichthuoc1, int kichthuoc2, int cannang, boolean quaylai, boolean giaotantay, boolean hotrotaixe, int status, String note, String diemdi, String diemden, double khoangcach) {
        this.loaixe = loaixe;
        this.dichvu = dichvu;
        this.phiship = phiship;
        this.phithuho = phithuho;
        this.loaihang = loaihang;
        this.kichthuoc1 = kichthuoc1;
        this.kichthuoc2 = kichthuoc2;
        this.cannang = cannang;
        this.quaylai = quaylai;
        this.giaotantay = giaotantay;
        this.hotrotaixe = hotrotaixe;
        this.status = status;
        this.note = note;
        this.diemdi = diemdi;
        this.diemden = diemden;
        this.khoangcach = khoangcach;
    }

    public String getLoaixe() {
        return loaixe;
    }

    public void setLoaixe(String loaixe) {
        this.loaixe = loaixe;
    }

    public String getDichvu() {
        return dichvu;
    }

    public void setDichvu(String dichvu) {
        this.dichvu = dichvu;
    }

    public int getPhithuho() {
        return phithuho;
    }

    public void setPhithuho(int phithuho) {
        this.phithuho = phithuho;
    }

    public String getLoaihang() {
        return loaihang;
    }

    public void setLoaihang(String loaihang) {
        this.loaihang = loaihang;
    }

    public int getKichthuoc1() {
        return kichthuoc1;
    }

    public void setKichthuoc1(int kichthuoc1) {
        this.kichthuoc1 = kichthuoc1;
    }

    public int getKichthuoc2() {
        return kichthuoc2;
    }

    public void setKichthuoc2(int kichthuoc2) {
        this.kichthuoc2 = kichthuoc2;
    }

    public int getCannang() {
        return cannang;
    }

    public void setCannang(int cannang) {
        this.cannang = cannang;
    }

    public boolean isQuaylai() {
        return quaylai;
    }

    public void setQuaylai(boolean quaylai) {
        this.quaylai = quaylai;
    }

    public boolean isGiaotantay() {
        return giaotantay;
    }

    public void setGiaotantay(boolean giaotantay) {
        this.giaotantay = giaotantay;
    }

    public boolean isHotrotaixe() {
        return hotrotaixe;
    }

    public void setHotrotaixe(boolean hotrotaixe) {
        this.hotrotaixe = hotrotaixe;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getPhiship() {
        return phiship;
    }

    public void setPhiship(int phiship) {
        this.phiship = phiship;
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

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
