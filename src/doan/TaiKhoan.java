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
public class TaiKhoan implements ThongTinNguoiDung{
    protected String tenDangNhap;
    protected String matKhau;

    public TaiKhoan() {
    }

    public TaiKhoan(String tenDangNhap, String matKhau) {
        this.tenDangNhap = tenDangNhap;
        this.matKhau = matKhau;
    }
    
    

    public String getTenDangNhap() {
        return tenDangNhap;
    }

    public String getMatKhau() {
        return matKhau;
    }
    
    
    public boolean laSinhVien(){
        return tenDangNhap.endsWith("@sinhvien");
    }
    
    boolean kTCoTrungMSSV(String mSSV){
        boolean coTrungMSSV=false;
        try{
                    File f = new File("TaiKhoanSinhvien.txt");
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
    
    boolean kTCoTrungMSGV(String mSGV){
        boolean coTrungMSSV=false;
        try{
                    File f = new File("TaiKhoanGiangVien.txt");
                    FileReader fR = new FileReader(f);
                    BufferedReader bR =new BufferedReader(fR);
                    String thongTinSinhVienTrongFile;
                    while((thongTinSinhVienTrongFile=bR.readLine())!=null){
                        if(thongTinSinhVienTrongFile.trim().equals(""))
                            continue;
                        String []arrChuaTenDangNhapvaMatKhau=thongTinSinhVienTrongFile.trim().split("[;]+");
                        if(arrChuaTenDangNhapvaMatKhau[3].equals(mSGV)){
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
    

    public void taoTaiKhoan() {
        Scanner sc = new Scanner(System.in);
        boolean laSinhVien;
        boolean laGiangVien; 
        while(true){
            boolean taiKhoangCoTonTai=false;
            
        while(true){
            System.out.println("Tao ten tai khoan phai co @sinhvien nieu la sinh vien/@giangvien nieu la giangvien");
            System.out.println("Tao ten tai khoan:");
            tenDangNhap = sc.nextLine();
            if(!tenDangNhap.equals(""))
                break;
            if(tenDangNhap.equals("")){
                System.out.println("Co the ban dang muon thoat(y/n)");
                String yOrN = sc.nextLine();
                if(yOrN.equalsIgnoreCase("y")){
                    xuatMenu();
                    return;
                }else if(yOrN.equalsIgnoreCase("n")){
                    System.out.println("Vui long nhap ky tu");
                    continue;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
        }
            laSinhVien =tenDangNhap.endsWith("@sinhvien");
            laGiangVien =tenDangNhap.endsWith("@giangvien");

            if(laSinhVien){
                try{
                    File f = new File("TaiKhoanSinhVien.txt");
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
                        System.out.println("Tai khoan da ton tai. Vui long doi ten tai khoan khac");
                    else{
                        break;
                    }
                        
                }catch(Exception e){
                    System.out.println("Khong the mo file de doc");
                }
            }else if(laGiangVien){
                try{
                    File f = new File("TaiKhoanGiangVien.txt");
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
                        System.out.println("Tai khoan da ton tai. Vui long doi ten tai khoang khac");
                    else
                        break;
                }catch(Exception e){
                    System.out.println("Khong the mo file de doc");
                }
            }
            if(!(tenDangNhap.endsWith("@sinhvien")|| tenDangNhap.endsWith("@giangvien")))
                System.out.println("Ban tao tai khoan khong dung khuong");
        }
        if(laSinhVien){
            while(true){
                System.out.println("Tao mat khau:");
                matKhau = sc.nextLine();
                if(!matKhau.equals(""))
                    break;
                if(matKhau.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            String ten;
            while(true){
                System.out.println("Nhap ten:");
                ten= sc.nextLine();
                if(!ten.equals(""))
                    break;
                if(ten.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            String mSSV;
            while(true){
                System.out.println("Nhap ma so sinh vien:");
                mSSV = sc.nextLine();
                if(!mSSV.equals("")){
                    try{
                    if(!kTCoTrungMSSV(mSSV)){
                        Integer.parseInt(mSSV);
                        break;
                    }else
                        System.out.println("Ban nhap trung ma so sinh vien. Vui long nhap lai");
                    }catch(Exception e){
                        System.out.println("Vui long nhap so nguyen");
                    }
                }
                if(mSSV.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            String chuyenNganh;
            while(true){
                System.out.println("Nhap chuyen nghanh:");
                chuyenNganh = sc.nextLine();
                if(!ten.equals(""))
                    break;
                if(ten.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            try{
                File f = new File("TaiKhoanSinhVien.txt");
                FileWriter fw = new FileWriter(f,true);
                PrintWriter pW = new PrintWriter(fw);
                pW.println(tenDangNhap+";"+matKhau+";"+ten+";"+mSSV+";"+chuyenNganh);
                System.out.println("Tao tai khoan thanh cong");
                pW.close();
                fw.close();
            } catch(Exception e){
                    System.out.println("Khong tim thay file de tao tai khoan");
            }
        }else if(laGiangVien){
            
            while(true){
                System.out.println("Nhap mat khau");
                matKhau = sc.nextLine();
                if(!matKhau.equals(""))
                    break;
                if(matKhau.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            String tenGiangvien;
            while(true){
                System.out.println("Nhap ten giang vien:");
                tenGiangvien = sc.nextLine();
                if(!matKhau.equals(""))
                    break;
                if(matKhau.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            String mSGV;
            while(true){
                System.out.println("Nhap ma so giang vien:");
                mSGV = sc.nextLine();
                if(!mSGV.equals("")){
                    try{
                    if(!kTCoTrungMSGV(mSGV)){
                            Integer.parseInt(mSGV);
                            break;
                        }else
                            System.out.println("Vui long nhap so");
                    }catch(Exception e){
                        System.out.println("Vui long nhap so nguyen");
                    }
                }
                if(mSGV.equals("")){
                    System.out.println("Co the ban dang muon thoat(y/n)");
                    String yOrN = sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        xuatMenu();
                        return;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        System.out.println("Vui long nhap ky tu");
                        continue;
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
            }
            
            try{
            File f = new File("TaiKhoanGiangVien.txt");
            FileWriter fw = new FileWriter(f,true);
            PrintWriter pW = new PrintWriter(fw);
            pW.println(tenDangNhap+";"+matKhau+";"+tenGiangvien+";"+mSGV);
            System.out.println("Tao tai khoan thanh cong");
            pW.close();
            fw.close();
            } catch(Exception e){
                    System.out.println("Khong tim thay file de tao tai khoan");
            }
        }
        xuatMenu();
    }

    public void nhapTaiKhoan(){
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Nhap ten dang nhap:");
        tenDangNhap=sc.nextLine();
        System.out.println("Nhap mat khau:");
        matKhau=sc.nextLine();
            boolean coTimThay= false;
            boolean laSinhVien =tenDangNhap.endsWith("@sinhvien");
            boolean laGiangVien =tenDangNhap.endsWith("@giangvien");
            if(laSinhVien){
                try{
                    File f = new File("TaiKhoanSinhVien.txt");
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
                        return;
                    }
                }catch(Exception e){
                    System.out.println("Khong mo duoc file de doc");
                }
            }else if(laGiangVien){
                try{
                    File f = new File("TaiKhoanGiangVien.txt");
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
                        return;
                    } 
                    
                }catch(Exception e){
                    System.out.println("Khong mo duoc file de doc");
                }
            }
            System.out.println("Ten dang nhap hoac mat khau sai.");    
            while(true){
                System.out.println("Ban muon tiep tuc dang nhap lai(y,n):");
                String coNhapLai = sc.nextLine();
                if(coNhapLai.equalsIgnoreCase("y")){
                    nhapTaiKhoan();
                    return;
                }else if(coNhapLai.equalsIgnoreCase("n")){
                    xuatMenu();
                    return;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
}
    
    public void xuatMenu(){
        Scanner sc =new Scanner(System.in);
        System.out.println("2. Tao tai khoan:"
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
                System.out.println("Ban phai nhap trong khoan do");
            }catch(Exception e){
                System.out.println("Vui long nhap so nguyen");
            }
        }
        switch(soCanThucHien)
        {
            case 2:taoTaiKhoan();
                    break;
            case 1:nhapTaiKhoan();
                    Menu m = new Menu(tenDangNhap, matKhau);
                    m.xuatMenuCuaGVHoacSinhVien();
                    break;
            case 0:return;
        }
    }       

    @Override
    public void xuatThongTinCaNhan(){
        Scanner sc = new Scanner(System.in);
        if(tenDangNhap.endsWith("@sinhvien")){
            try{
            File f = new File("TaiKhoanSinhVien.txt");
            FileReader fR = new FileReader(f);
            BufferedReader bR =new BufferedReader(fR);
            String thongTinTrongFile;
            while((thongTinTrongFile = bR.readLine())!=null){
                String []arr=thongTinTrongFile.trim().split("[;]+");
                if(arr[0].equals(tenDangNhap)&& arr[1].equals(matKhau)){
                    System.out.println("Ho va ten: "+arr[2]);
                    System.out.println("Ma so sinh vien: "+arr[3]);
                    System.out.println("Chuyen nganh: "+arr[4]);
                    System.out.println("Tai khoan: "+arr[0]);
                    break;
                }
            } 
            fR.close();
            bR.close();
            }catch(Exception e){
                    System.out.println("Khong the mo file TaiKhoanSinhVien.txt de doc");
            }
        }else if(tenDangNhap.endsWith("@giangvien")){
            try{
            File file = new File("TaiKhoanGiangVien.txt");
            FileReader fR = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            String thongTinCuaGiangVien;
            
            while((thongTinCuaGiangVien=bR.readLine())!=null){
                String arr[]=thongTinCuaGiangVien.trim().split("[;]+");
                if(arr[0].equals(tenDangNhap)&& arr[1].equals(matKhau)){
                    System.out.println("Ten giang vien: "+arr[2]);
                    System.out.println("Ma so giang vien: "+arr[3]);
                    System.out.println("Tai khoan: "+arr[0]);
                    break;
                }
            }
            fR.close();
            bR.close();
            }catch(Exception e){
                System.out.println("Khong the mo file");
            }
        }
           
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        
        if(tenDangNhap.endsWith("@sinhvien")){
            Menu m = new Menu(tenDangNhap, matKhau);
            m.xuatMenuCuaGVHoacSinhVien();
            return;
        }else if(tenDangNhap.endsWith("@giangvien")){
            Menu m = new Menu(tenDangNhap, matKhau);
            m.xuatMenuCuaGVHoacSinhVien();
            return;
        }
    }
}