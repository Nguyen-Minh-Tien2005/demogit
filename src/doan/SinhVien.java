/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class SinhVien extends TaiKhoan implements ThongTinNguoiDung{
    private String hoVaTen;
    private String mSSV;
    private String nganh;
    ArrayList<BuoiHoc> tKB = new ArrayList<BuoiHoc>();

    

    public SinhVien( String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
       
    }

    public SinhVien( String tenDangNhap, String matKhau,String hoVaTen, String mSSV, String nganh) {
        super(tenDangNhap, matKhau);
        this.hoVaTen = hoVaTen;
        this.mSSV = mSSV;
        this.nganh = nganh;
    }
    
   

    public String getHoVaTen() {
        return hoVaTen;
    }

    public String getmSSV() {
        return mSSV;
    }

    public String getNganh() {
        return nganh;
    }

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    @Override
    public void xuatThongTinCaNhan(){
        
        
        Scanner sc = new Scanner(System.in);
        try{
            File f = new File("TaiKhoangSinhVien.txt");
            FileReader fR = new FileReader(f);
            BufferedReader bR =new BufferedReader(fR);
            String thongTinTrongFile;
            while((thongTinTrongFile = bR.readLine())!=null){
                String []arr=thongTinTrongFile.trim().split("[;]+");
                if(arr[0].equals(tenDangNhap)&& arr[1].equals(matKhau)){
                    System.out.println("Ho va ten: "+arr[2]);
                    System.out.println("Ma so sinh vien: "+arr[3]);
                    System.out.println("Chuyen nganh: "+arr[4]);
                    System.out.println("Tai khoang: "+arr[0]);
                    break;
                }
            } 
            fR.close();
            bR.close();
        }catch(Exception e){
                System.out.println("Khong the mo file TaiKhoangSinhVien.txt de doc");
        }
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        xuatMenuCuaSinhVien();
    }
    
    public void xuatMenuCuaSinhVien(){
        Scanner sc =new Scanner(System.in);
        System.out.println(
                  "\n3. Tim lop"
                + "\n2. Xuat thoi khoa bieu"
                + "\n1. Xuat thong tin ca nhan"
                + "\n0. Thoat");
        int soCanThucHien;
        
        while(true){
            try{
                System.out.println("\nNhap lua chon cua ban:");
                soCanThucHien = Integer.parseInt(sc.nextLine());
                if(!(0>soCanThucHien || soCanThucHien>3)){
                    break;
                }else
                    System.out.println("Vui long nhap trong pham vi");
            }catch(Exception e){
                System.out.println("Vui long nhap so nguyen");
            }
        }
        ThoiKhoaBieu tKB = new ThoiKhoaBieu(tenDangNhap, matKhau);
        switch(soCanThucHien){
            case 3: tKB.timLop();break;
            case 2: tKB.xuatThoiKhoaBieu(); break;
            case 1: xuatThongTinCaNhan(); break;
            case 0: xuatMenu(); break;
        }
    }
    
    public String toString() { 

        return String.format("%-30s %-30s %-30s %-30s", hoVaTen, mSSV, nganh, tenDangNhap);
    }
    
    
}