/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class BuoiHoc {
    private int soThuTu;
    private String lop;
    private String tenLop;
    private String ngayVaGio;
    private String phong;
    private String ngayLenLop;

    public BuoiHoc(int soThuTu, String lop, String tenLop, String ngayVaGio, String phong, String ngayLenLop) {
        this.soThuTu = soThuTu;
        this.lop = lop;
        this.tenLop = tenLop;
        this.ngayVaGio = ngayVaGio;
        this.phong = phong;
        this.ngayLenLop = ngayLenLop;
    }

    public int getSoThuTu() {
        return soThuTu;
    }

    public void setSoThuTu(int soThuTu) {
        this.soThuTu = soThuTu;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public String getTenLop() {
        return tenLop;
    }

    public void setTenLop(String tenLop) {
        this.tenLop = tenLop;
    }

    public String getNgayVaGio() {
        return ngayVaGio;
    }

    public void setNgayVaGio(String ngayVaGio) {
        this.ngayVaGio = ngayVaGio;
    }

    public String getPhong() {
        return phong;
    }

    public void setPhong(String phong) {
        this.phong = phong;
    }

    public String getNgayLenLop() {
        return ngayLenLop;
    }

    public void setNgayLenLop(String ngayLenLop) {
        this.ngayLenLop = ngayLenLop;
    }
    
    public String khuonTrongFile()
    {
       return String.format("%d;%s;%s;%s;%s;%s",
                            getSoThuTu(), getLop(), getTenLop(),
                            getNgayVaGio(),getPhong(), getNgayLenLop());
    }
    public static void inTieuDe(){
        System.out.println("\t\t\t\t\t\t\t\t\tTHOI KHOA BIEU");
        System.out.println(String.format("%-10s      %-15s          %-45s     %-50s     %-5s          %-60s",
                "So thu tu","Lop","Ten lop","Ngay va gio","Phong","Ngay len lop"));
    }
            
    @Override
    public String toString(){
        return String.format("%-5d           %-15s          %-45s     %-50s     %-5s          %-60s",
                soThuTu,lop,tenLop,ngayVaGio,phong,ngayLenLop);
    }
}
