/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import doan.BuoiHoc;
import java.awt.BorderLayout;
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
public class GiangVien extends TaiKhoangCuaNguoiDung implements ThongTinNguoiDung{
    protected String tenGiangVien;

    public GiangVien(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
    }

    
    public String getTenGiangVien() {
        return tenGiangVien;
    }

    public void nhapThongTinGiangVienNeuChuaCo(){
        Scanner sc = new Scanner(System.in);
        try{
            String tenFile=getTenDangNhap()+";"+getMatKhau()+".txt";
            File f = new File(tenFile);
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pW = new PrintWriter(fw);
            fw.close();
            pW.close();
        }catch(Exception e){
            System.out.println("Khong the tao file");
            return;
        }
        
        try{
            File f = new File(getTenDangNhap()+";"+getMatKhau()+".txt");
            FileReader fR = new FileReader(f);
            BufferedReader bR =new BufferedReader(fR);
            String kyTu;
            if((kyTu=bR.readLine())==null){
                fR.close();
                bR.close();
                System.out.println("Nhap ten giang vien:");
                tenGiangVien = sc.nextLine();
                f = new File(getTenDangNhap()+";"+getMatKhau()+".txt");
                FileWriter fW = new FileWriter(f);
                PrintWriter pW = new PrintWriter(fW);
                pW.println(tenGiangVien);
                pW.println(tenDangNhap);
                fW.close();
                pW.close();
            }else
            {
                fR.close();
                bR.close();
            }
        }catch (Exception e) {
            System.out.println("Loi");
        }
    }
    
    
    @Override
    public void xuatThongTinCaNhan() {
        Scanner sc = new Scanner(System.in);
        try{
            File file = new File(tenDangNhap+";"+matKhau+".txt");
            FileReader fR = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            System.out.println("Ho va ten: "+bR.readLine());
            System.out.println("Tai khoang: "+bR.readLine());
            fR.close();
            bR.close();
        }catch(Exception e){
            System.out.println("Khong the mo file");
        }
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        xuatMenuCuaGianVien();
    }
    
    public void xuatMenuCuaGianVien(){
        nhapThongTinGiangVienNeuChuaCo();
        Scanner sc =new Scanner(System.in);
        System.out.println("4.Xem thong tin sinh vien"
                + "\n3. Them thong tin vao thoi khoa bieu"
                + "\n2. Xuat thoi khoa bieu"
                + "\n1. Xuat thong tin ca nhan"
                + "\n0. Thoat");
        int soCanThucHien;
        
        while(true){
            try{
                System.out.println("\nNhap lua chon cua ban:");
                soCanThucHien = Integer.parseInt(sc.nextLine());
                if(!(0>soCanThucHien || soCanThucHien>4)){
                    break;
                }
            }catch(Exception e){
                System.out.println("Vui long nhap so nguyen");
            }
        }
        ThoiKhoaBieu tKB = new ThoiKhoaBieu(tenDangNhap, matKhau);
        DanhSachSinhVien dSSV = new DanhSachSinhVien(tenDangNhap,matKhau);
        switch(soCanThucHien){
            case 4: dSSV.xuatDanhSachSV();break;
            case 3:tKB.themThongTinThoiKhoaBieu(); 
                    break;
            case 2:tKB.xuatDanhSachThongTinCuaThoiKhoaBieu(); break;
            case 1: xuatThongTinCaNhan(); break;
            case 0: xuatMenuCuaTaiKhoanCuaNguoiDung(); break;
        }
        
    }
}




    
    
    
