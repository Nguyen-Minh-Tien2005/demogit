/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class DanhSachSinhVien {
    protected String tenDangNhapCuaGiangVienTruyCap;
    protected String matKhauCuaGiangVienTruyCap;
    ArrayList<SinhVien> danhSachSinhVien = new ArrayList<SinhVien>();

    public DanhSachSinhVien(String tenDangNhapCuaGiangVienTruyCap, String matKhauCuaGiangVienTruyCap) {
        this.tenDangNhapCuaGiangVienTruyCap = tenDangNhapCuaGiangVienTruyCap;
        this.matKhauCuaGiangVienTruyCap = matKhauCuaGiangVienTruyCap;
    }

    
    public void nhapDanhSachSinhVienVaoArrayList() {
    File fileTaiKhoan = new File("TaiKhoangSinhVien.txt");
    try {
        FileReader fRTaiKhoan = new FileReader(fileTaiKhoan);
        BufferedReader bRTaiKhoang = new BufferedReader(fRTaiKhoan);
        String line;
        while ((line = bRTaiKhoang.readLine()) != null) {
            String[] arr = line.trim().split("[;]+");
            SinhVien sV = new SinhVien(arr[0], arr[1]);
            String soSanh = sV.toString();
            if (soSanh.equals("FileK")) {
                continue;
            }
            danhSachSinhVien.add(sV);
        }
        fRTaiKhoan.close();
        bRTaiKhoang.close();
    } catch (Exception e) {
        System.out.println("Loi");
    }
}
    public static void inTieuDe(){
        System.out.println("\t\t\t\t\t\tTHONG TIN CUA SINH VIEN");
        System.out.println(String.format("%-30s %-30s %-30s %-30s","Ho va ten", "Ma so sinh vien", "Nganh", "Tai khoang"));
    }
    public void xuatDanhSachSV(){
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien.inTieuDe();
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();
        for(int i=0;i<danhSachSinhVien.size();i++){
            System.out.println(danhSachSinhVien.get(i));
        }
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVienTruyCap, matKhauCuaGiangVienTruyCap);
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        gV.xuatMenuCuaGianVien();
    }
}
