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
import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class ThoiKhoaBieu {
    protected String tenDangNhap;
    protected String matKhau;
    ArrayList<BuoiHoc> tKB = new ArrayList<BuoiHoc>();

    public ThoiKhoaBieu(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    
    public void themThongTinThoiKhoaBieu(){
        int soThuTu = capNhatThongTinVaoArrayList();
        Scanner sc= new Scanner(System.in);
        try{

            File file = new File("ThoiKhoaBieu.txt");
            if(file == null)
                return;
            FileWriter fR = new FileWriter(file,true);
            PrintWriter bR = new PrintWriter(fR);
            
            while(true){


                System.out.println("Nhap lop:");
                String lop = sc.nextLine();

                System.out.println("Nhap ten lop:");
                String tenLop = sc.nextLine();

                System.out.println("Nhap ngay gio:");
                String ngayVaGio= sc.nextLine();

                System.out.println("Nhap phong:");
                String phong= sc.nextLine();

                System.out.println("Nhap ngay len lop:");
                String ngayLenLop= sc.nextLine();
                
                bR.println(String.format("%s;%s;%s;%s;%s;%s",soThuTu++,lop,tenLop,ngayVaGio,phong,ngayLenLop));


                System.out.println("Ban muon tiep tuc nhap them thong tin cho thoi khoa bieu(Y/N):");
                String coDongY=sc.nextLine();
                if(coDongY.equalsIgnoreCase("N")){
                    fR.close();
                    bR.close();
                    capNhatThongTinVaoArrayList();
                    break;
                }
            }
        }catch(Exception e){
            System.out.println("Khong the mo file de viet"); 
        }
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien();
    }
    
    public int  capNhatThongTinVaoArrayList(){
        int soLuongPhanTu=0;
        try{
        File file = new File("ThoiKhoaBieu.txt");
        FileReader fR = new FileReader(file);
        BufferedReader bR = new BufferedReader(fR);
        String line;
            while((line = bR.readLine())!=null){
                if(line.trim().equals(""))
                    continue;
                String []arr = line.split("[;]+");
                tKB.add(new BuoiHoc(Integer.parseInt(arr[0]), arr[1], arr[2],arr[3],arr[4],arr[5]));
                soLuongPhanTu++;
            }
        fR.close();
        bR.close();
        }catch(Exception e){
            System.out.println("Khong tim thay file de viet");
        }
        return soLuongPhanTu;
    }
    public void  xuatDanhSachThongTinCuaThoiKhoaBieu(){
        Scanner sc = new Scanner(System.in);
        tKB.clear();
        capNhatThongTinVaoArrayList();
        BuoiHoc.intieuDe();
        for(int i=0;i<tKB.size();i++){
            System.out.println(tKB.get(i).toString());
        }
        System.out.println("Xuat thanh cong thoi khoa bieu");
        if(tenDangNhap.endsWith("@sinhvien")){
            SinhVien sV = new SinhVien(tenDangNhap, matKhau);
            System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
            sc.nextLine();
            sV.xuatMenuCuaSinhVien();
        }else if(tenDangNhap.endsWith("@giangvien")){
              GiangVien gV = new GiangVien(tenDangNhap, matKhau);
              System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
              sc.nextLine();
              gV.xuatMenuCuaGianVien();
        }
    }
}

