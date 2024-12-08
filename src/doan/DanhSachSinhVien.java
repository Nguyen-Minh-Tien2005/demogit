/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class DanhSachSinhVien {
    protected String tenDangNhapCuaGiangVien;
    protected String matKhauCuaGiangVien;
    ArrayList<SinhVien> danhSachSinhVien = new ArrayList<SinhVien>();

    public DanhSachSinhVien(String tenDangNhapCuaGiangVien, String matKhauCuaGiangVien) {
        this.tenDangNhapCuaGiangVien = tenDangNhapCuaGiangVien;
        this.matKhauCuaGiangVien = matKhauCuaGiangVien;
    }

    public void nhapDanhSachSinhVienVaoArrayList() {
        File fileTaiKhoan = new File("TaiKhoangSinhVien.txt");
        try {
            FileReader fRTaiKhoan = new FileReader(fileTaiKhoan);
            BufferedReader bRTaiKhoang = new BufferedReader(fRTaiKhoan);
            String line;
            while ((line = bRTaiKhoang.readLine()) != null) {
                String[] arr = line.trim().split("[;]+");
                SinhVien sV = new SinhVien(arr[0], arr[1],arr[2],arr[3],arr[4]);
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
        System.out.println(String.format("%-30s %-30s %-30s %-30s","Ho va ten", "Ma so sinh vien", "Nganh", "Tai khoan"));
    }
    
    public void xuatDanhSachSV(){
        Scanner sc = new Scanner(System.in);
        DanhSachSinhVien.inTieuDe();
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();
        for(int i=0;i<danhSachSinhVien.size();i++){
            System.out.println(danhSachSinhVien.get(i));
        }
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        gV.xuatMenuCuaGianVien();
    }
    
    public void timThongTinSinhVien(){
        Scanner sc = new Scanner(System.in);
        nhapDanhSachSinhVienVaoArrayList();
    
        Scanner tenSinhVien = new Scanner(System.in);
        String mSSV;
        while(true){
            System.out.print("Vui long nhap ma so sinh vien de tim sinh vien: ");
            mSSV = sc.nextLine();
            if(!mSSV.equals(""))
                break;
            if(mSSV.equals("")){
                System.out.println("Co the ban dang muon thoat(y/n)");
                String yOrN = sc.nextLine();
                if(yOrN.equalsIgnoreCase("y")){
                    GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
                    gV.xuatMenuCuaGianVien();
                    return;
                }else if(yOrN.equalsIgnoreCase("n")){
                    System.out.println("Vui long nhap ky tu");
                    continue;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
        }
        inTieuDe();
        boolean ketQua = false;
        for (int i = 0; i < danhSachSinhVien.size(); i++) {
            SinhVien sinhVien = danhSachSinhVien.get(i);
            if (sinhVien.getmSSV().equals(mSSV)) {
                System.out.println(sinhVien);
                ketQua =true;
            }
        }
        if(ketQua==false)
            System.out.println("Khong tim thay sinh vien");
        while(true){
            System.out.println("Ban muon tiep tuc tim kiem(y,n):");
            String coNhapLai = sc.nextLine();
            if(coNhapLai.equalsIgnoreCase("y")){
                timThongTinSinhVien();
                return;
            }else if(coNhapLai.equalsIgnoreCase("n")){
                GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien,matKhauCuaGiangVien);
                gV.xuatMenuCuaGianVien();
                return;
            }else
                System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
        }
    }
    
        public void sapXepTangDanTheoHoTen(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getHoVaTen().compareTo(o2.getHoVaTen());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
        
    public void sapXepGiamDanTheoHoTen(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o2.getHoVaTen().compareTo(o1.getHoVaTen());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoMSSV(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getmSSV().compareTo(o2.getmSSV());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoMSSV(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o2.getmSSV().compareTo(o1.getmSSV());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoNganh(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getNganh().compareTo(o2.getNganh());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoNganh(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o2.getNganh().compareTo(o1.getNganh());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoTaiKhoan(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o1.getTenDangNhap().compareTo(o2.getTenDangNhap());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoTaiKhoan(){    
        danhSachSinhVien.clear();
        nhapDanhSachSinhVienVaoArrayList();

        Comparator sX = new Comparator<SinhVien>() {
          
            @Override
            public int compare(SinhVien o1, SinhVien o2) {
                return o2.getTenDangNhap().compareTo(o1.getTenDangNhap());
            }
        };
        Collections.sort(danhSachSinhVien,sX);
              try{
            File file = new File("TaiKhoangSinhVien.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (SinhVien sV : danhSachSinhVien) 
            {
                pR.println(String.format("%s;%s;%s;%s;%s",
                        sV.getTenDangNhap(),sV.getMatKhau(),sV.getHoVaTen(),sV.getmSSV(),sV.getNganh()));

            }
            
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Sap xep thanh cong");
        GiangVien gV = new GiangVien(tenDangNhapCuaGiangVien, matKhauCuaGiangVien);
        gV.xuatMenuCuaGianVien(); 
    }
}
