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
import java.util.Scanner;

/**
 *
 * @author NGUYEN MINH TIEN
 */
public class TaiKhoangCuaNguoiDung {
    protected String tenDangNhap;
    protected String matKhau;

    public TaiKhoangCuaNguoiDung() {
    }

    public TaiKhoangCuaNguoiDung(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    
    

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    
    public boolean laHocSinh(){
        return tenDangNhap.endsWith("@sinhvien");
    }
    
    boolean kTCoTrungMSSV(String mSSV){
        boolean coTrungMSSV=false;
        try{
                    File f = new File("TaiKhoangSinhvien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String thongTinSinhVienTrongFile;
                    while((thongTinSinhVienTrongFile=bR.readLine())!=null){
                        if(thongTinSinhVienTrongFile.trim().equals(""))
                            continue;
                        String []arrChuaTenDangNhapvaMatKhau=thongTinSinhVienTrongFile.trim().split("[;]+");
                        if(arrChuaTenDangNhapvaMatKhau[3].equals(mSSV)){
                            coTrungMSSV=true;
                            break;
                        }
                    }
                    fR.close();
                    bR.close();
                }catch(Exception e){
                    System.out.println("Khong the mo file de doc");
                }
        return coTrungMSSV;
    }
    
    public boolean coLaSo(String mSSV){
        boolean kyTuSo=true;
        for(int i=0;i<mSSV.length();i++){
            if(Character.isLetter(mSSV.charAt(i))){
                kyTuSo=false;
            }
        }
            return kyTuSo;
    }
    public void taoTaiKhoang() {
        Scanner sc = new Scanner(System.in);
        boolean laSinhVien;
        boolean laGiangVien; 
        while(true){
            boolean taiKhoangCoTonTai=false;
            System.out.println("Tao ten tai khoang phai co @sinhvien nieu la sinh vien/@giangvien nieu la giangvien");
            System.out.println("Tao ten tai khoang:");
            tenDangNhap = sc.nextLine();
            laSinhVien =tenDangNhap.endsWith("@sinhvien");
            laGiangVien =tenDangNhap.endsWith("@giangvien");

            if(laSinhVien){
                try{
                    File f = new File("TaiKhoangSinhVien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String tenDangNhapVaMatKhauTrongFile;
                    while((tenDangNhapVaMatKhauTrongFile=bR.readLine())!=null){
                        if(tenDangNhapVaMatKhauTrongFile.trim().equals(""))
                            continue;
                        String []arrChuaTenDangNhapvaMatKhau=tenDangNhapVaMatKhauTrongFile.trim().split("[;]+");
                        if(arrChuaTenDangNhapvaMatKhau[0].equals(tenDangNhap)){
                            taiKhoangCoTonTai=true;
                            break;
                        }
                    }
                    fR.close();
                    bR.close();
                    if(taiKhoangCoTonTai)
                        System.out.println("Tai khoang da ton tai. Vui long doi ten tai khoang khac");
                    else{
                        break;
                    }
                        
                }catch(Exception e){
                    System.out.println("Khong the mo file de doc");
                }
            }else if(laGiangVien){
                try{
                    File f = new File("TaiKhoangGiangVien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String thongTinGiangVienTrongFile;
                    while((thongTinGiangVienTrongFile=bR.readLine())!=null){
                        if(thongTinGiangVienTrongFile.trim().equals(""))
                            continue;
                        String []arrChuaTenDangNhapvaMatKhau=thongTinGiangVienTrongFile.trim().split("[;]+");
                        if(arrChuaTenDangNhapvaMatKhau[0].equals(tenDangNhap)){
                            taiKhoangCoTonTai=true;
                            break;
                        }
                    }
                    fR.close();
                    bR.close();
                    if(taiKhoangCoTonTai)
                        System.out.println("Tai khoang da ton tai. Vui long doi ten tai khoang khac");
                    else
                        break;
                }catch(Exception e){
                    System.out.println("Khong the mo file de doc");
                }
            }
                if(!(tenDangNhap.endsWith("@sinhvien")|| tenDangNhap.endsWith("@giangvien")))
                System.out.println("Ban tao tai khoang khong dung khuong");
        }


        
        if(laSinhVien){
            System.out.println("Tao mat khau:");
            matKhau = sc.nextLine();

            System.out.println("Nhap ten:");
            String ten = sc.nextLine();
            String mSSV;
            while(true){
                System.out.println("Nhap ma so sinh vien:");
                mSSV = sc.nextLine();
                if(!kTCoTrungMSSV(mSSV)){
                    if(coLaSo(mSSV))
                        break;
                    else
                        System.out.println("Vui long nhap so");
                }else
                    System.out.println("Ban nhap trung ma so sinh vien. Vui long nhap lai");
            }
            System.out.println("Nhap chuyen nghanh:");
            String chuyenNganh = sc.nextLine();
            
            try{
            File f = new File("TaiKhoangSinhVien.txt");
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pW = new PrintWriter(fw);
            pW.println(tenDangNhap+";"+matKhau+";"+ten+";"+mSSV+";"+chuyenNganh);
            System.out.println("Tao tai khoang thanh cong");
            pW.close();
            fw.close();
            } catch(Exception e){
                    System.out.println("Khong tim thay file de tao tai khoang");
            }
        }else if(laGiangVien){
            System.out.println("Nhap mat khau");
            matKhau = sc.nextLine();
            System.out.println("Nhap ten giang vien:");
            String tenGiangvien = sc.nextLine();
            try{
            File f = new File("TaiKhoangGiangVien.txt");
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pW = new PrintWriter(fw);
            pW.println(tenDangNhap+";"+matKhau+";"+tenGiangvien);
            System.out.println("Tao tai khoang thanh cong");
            pW.close();
            fw.close();
            } catch(Exception e){
                    System.out.println("Khong tim thay file de tao tai khoang");
            }
        }
        xuatMenuCuaTaiKhoanCuaNguoiDung();
}

    public void nhapTaiKhoang(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap ten Dang Nhap:");
        tenDangNhap=sc.nextLine();
        System.out.println("Nhap mat khau:");
        matKhau=sc.nextLine();
            boolean coTimThay= false;
            boolean laSinhVien =tenDangNhap.endsWith("@sinhvien");
            boolean laGiangVien =tenDangNhap.endsWith("@giangvien");
            if(laSinhVien){
                try{
                    File f = new File("TaiKhoangSinhVien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String tenDangNhapVaMatKhauTrongFile;
                    while((tenDangNhapVaMatKhauTrongFile = bR.readLine())!=null){
                        String arr[] = tenDangNhapVaMatKhauTrongFile.trim().split("[;]+");
                        coTimThay= tenDangNhap.equals(arr[0])&& matKhau.equals(arr[1]);
                        if(coTimThay){
                            break;
                        }
                    }
                    bR.close();
                    fR.close();
                    if(coTimThay){
                        System.out.println("Dang nhap thanh cong");
                    } 
                    else{
                        System.out.println("Ten dang nhap hoac mat khau sai");

                        System.out.println("Ban muon tiep tuc dang nhap lai:");
                        String coNhaplai = sc.nextLine();
                        if(coNhaplai.equalsIgnoreCase("y"))
                            nhapTaiKhoang();
                        else
                            xuatMenuCuaTaiKhoanCuaNguoiDung();
                    }
                }catch(Exception e){
                    System.out.println("Khong mo duoc file de doc");
                }
            }else if(laGiangVien){
                try{
                    File f = new File("TaiKhoangGiangVien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String tenDangNhapVaMatKhauTrongFile;
                    while((tenDangNhapVaMatKhauTrongFile = bR.readLine())!=null){
                        String arr[] = tenDangNhapVaMatKhauTrongFile.trim().split("[;]+");
                        coTimThay= tenDangNhap.equals(arr[0])&& matKhau.equals(arr[1]);
                        if(coTimThay){
                            break;
                        }
                    }
                    bR.close();
                    fR.close();
                    if(coTimThay){
                        System.out.println("Dang nhap thanh cong");
                    } 
                    
                }catch(Exception e){
                    System.out.println("Khong mo duoc file de doc");
                }
            }else{
                        System.out.println("Ten dang nhap hoac mat khau sai");

                        System.out.println("Ban muon tiep tuc dang nhap lai:");
                        String coNhaplai = sc.nextLine();
                        if(coNhaplai.equalsIgnoreCase("y"))
                            nhapTaiKhoang();
                        else
                            xuatMenuCuaTaiKhoanCuaNguoiDung();
                    }
            
        }
    public void phanQuyen(){
        if(tenDangNhap.endsWith("@sinhvien")){
            SinhVien sv = new SinhVien(tenDangNhap,matKhau);
            sv.xuatMenuCuaSinhVien();
        }else if(tenDangNhap.endsWith("@giangvien")){
            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
            gV.xuatMenuCuaGianVien();
        }
    }
    
    public void xuatMenuCuaTaiKhoanCuaNguoiDung(){
        Scanner sc =new Scanner(System.in);
        System.out.println("2. Tao tai khoang:"
                + "\n1. Dang nhap:"
                + "\n0. Dong");
        System.out.println("");
        int soCanThucHien;
        while(true){
            try{
                System.out.println("Nhap lua chon cua ban:");
                soCanThucHien = Integer.parseInt(sc.nextLine());
                if(!(0>soCanThucHien || soCanThucHien>3)){
                    break;
                }
                System.out.println("Ban phai nhap trong khoang do");
            }catch(Exception e){
                System.out.println("Vui long nhap so nguyen");
            }
        }
        switch(soCanThucHien)
        {
            case 2:taoTaiKhoang();
                    break;
            case 1:nhapTaiKhoang();
                    phanQuyen();
                    break;
            case 0:return;
        }
    }       
}


      
