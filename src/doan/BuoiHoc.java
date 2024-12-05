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
    
    public static void intieuDe(){
        System.out.println("\t\t\t\t\t\t\t\t\tTHOI KHOA BIEU");
        System.out.println(String.format("%-10s      %-10s          %-45s     %-50s     %-5s          %-60s",
                "So thu tu","Lop","Ten lop","Ngay va gio","Phong","Ngay len lop"));
    }
            
    @Override
    public String toString(){
        return String.format("%-5d           %-10s          %-45s     %-50s     %-5s          %-60s",
                soThuTu,lop,tenLop,ngayVaGio,phong,ngayLenLop);
    }
}
