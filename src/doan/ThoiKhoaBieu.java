/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package doan;

import static doan.DanhSachSinhVien.inTieuDe;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
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
                String lop;
                while(true){
                System.out.println("Nhap lop ( vui long nhap it nhat la 9 ky tu nhieu nhat la 11 ky tu ):");
                lop = sc.nextLine();
                    if(9<=lop.length()&&lop.length()<=11){
                        break;
                    }else if(lop.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }else
                        System.out.println("Vui long nhap it nhat la 9 ky tu nhieu nhat la 11");
                }
                
                
                String tenLop;
                while(true){
                    System.out.println("Nhap ten lop:");
                    tenLop = sc.nextLine();
                    if(!tenLop.equals(""))
                        break;
                    if(tenLop.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
               
                
                String ngayVaGio;
                while(true){
                    System.out.println("Nhap ngay gio:");
                    ngayVaGio= sc.nextLine();
                    if(!ngayVaGio.equals(""))
                        break;
                    if(ngayVaGio.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
                
                
                String phong;
                while(true){
                    System.out.println("Nhap phong:");
                    phong= sc.nextLine();
                    if(!phong.equals(""))
                        break;
                    if(phong.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
                
                
                String ngayLenLop;
                while(true){
                    System.out.println("Nhap ngay len lop:");
                    ngayLenLop= sc.nextLine();
                    if(!ngayLenLop.equals(""))
                        break;
                    if(ngayLenLop.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
                File file = new File("ThoiKhoaBieu.txt");
                FileWriter fR = new FileWriter(file,true);
                PrintWriter bR = new PrintWriter(fR);
                bR.println(String.format("%s;%s;%s;%s;%s;%s",++soThuTu,lop,tenLop,ngayVaGio,phong,ngayLenLop));
                fR.close();
                bR.close();
               
                while(true){
                    System.out.println("Ban muon tiep tuc nhap them thong tin cho thoi khoa bieu(Y/N):");
                    String yOrN=sc.nextLine();
                    if(yOrN.equalsIgnoreCase("y")){
                        themThongTinThoiKhoaBieu();
                        break;
                    }else if(yOrN.equalsIgnoreCase("n")){
                        capNhatThongTinVaoArrayList();
                        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                        gV.xuatMenuCuaGianVien();
                    }else
                        System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                }
                
            
        }catch(Exception e){
            System.out.println("Khong the mo file de viet"); 
        }
    }
    
    public int  capNhatThongTinVaoArrayList(){
        int soTTLonNhat=0;
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
                soTTLonNhat=(soTTLonNhat<Integer.parseInt(arr[0]))?Integer.parseInt(arr[0]):soTTLonNhat;
            }
        fR.close();
        bR.close();
        }catch(Exception e){
            System.out.println("Khong tim thay file de viet");
        }
        return soTTLonNhat;
    }
    
    
    public void  xuatThoiKhoaBieu(){
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
    public boolean coLaSo(String mSSV){
        boolean kyTuSo=true;
        for(int i=0;i<mSSV.length();i++){
            if(Character.isLetter(mSSV.charAt(i))){
                kyTuSo=false;
            }
        }
            return kyTuSo;
    }
    public void suaThongTin() {
        tKB.clear();
        capNhatThongTinVaoArrayList();
        Scanner sc = new Scanner(System.in);
        String soTT;
        while(true){
            System.out.println("Nhap so thu tu de sua:");
            soTT = sc.nextLine();
                try{
                if(!soTT.equals("")){
                    if(coLaSo(soTT)){
                        Integer.parseInt(soTT);
                        break;
                    }else
                        System.out.println("Vui long nhap so nguyen");
                }
            }catch(Exception e){
                    System.out.println("Vui long nhap so nguyen");
            }
            if(soTT.equals("")){
                System.out.println("Co the ban dang muon thoat(y/n)");
                String yOrN = sc.nextLine();
                if(yOrN.equalsIgnoreCase("y")){
                    GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                    gV.xuatMenuCuaGianVien();
                    return;
                }else if(yOrN.equalsIgnoreCase("n")){
                    System.out.println("Vui long nhap ky tu");
                    continue;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
        }
        boolean found = false;
        for (int i = 0; i < tKB.size(); i++) 
        {
            if (tKB.get(i).getSoThuTu()==Integer.parseInt(soTT)) {
                found = true;
                String lopMoi;
                while(true){
                    System.out.println("Nhap lop moi ( vui long nhap it nhat la 9 ky tu nhieu nhat la 11 ky tu ):");
                    lopMoi = sc.nextLine();
                    if(9<=lopMoi.length()&&lopMoi.length()<=11){
                        break;
                    }else if(lopMoi.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }else
                        System.out.println("Vui long nhap it nhat la 9 ky tu nhieu nhat la 11");
                }


                String tenMonMoi;
                while(true){
                    System.out.println("Nhap ten lop moi:");
                    tenMonMoi= sc.nextLine();
                    if(!tenMonMoi.equals(""))
                        break;
                    if(tenMonMoi.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }


                String ngayVaGioMoi;
                while(true){
                    System.out.println("Nhap ngay gio moi:");
                    ngayVaGioMoi= sc.nextLine();
                    if(!ngayVaGioMoi.equals(""))
                        break;
                    if(ngayVaGioMoi.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }

                String phongMoi;
                while(true){
                    System.out.println("Nhap phong hoc moi:");
                    phongMoi = sc.nextLine();
                    if(!phongMoi.equals(""))
                        break;
                    if(phongMoi.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
                String ngayLenLopMoi;
                while(true){
                    System.out.println("Nhap ngay len lop moi:");
                    ngayLenLopMoi = sc.nextLine();
                    if(!phongMoi.equals(""))
                        break;
                    if(phongMoi.equals("")){
                        System.out.println("Co the ban dang muon thoat(y/n)");
                        String yOrN = sc.nextLine();
                        if(yOrN.equalsIgnoreCase("y")){
                            GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                            gV.xuatMenuCuaGianVien();
                            return;
                        }else if(yOrN.equalsIgnoreCase("n")){
                            System.out.println("Vui long nhap ky tu");
                            continue;
                        }else
                            System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
                    }
                }
                tKB.get(i).setLop(lopMoi);
                tKB.get(i).setTenLop(tenMonMoi);
                tKB.get(i).setNgayVaGio(ngayVaGioMoi);
                tKB.get(i).setPhong(phongMoi);
                tKB.get(i).setNgayLenLop(ngayLenLopMoi);
                break;
            }
        }

        if (!found) 
        {
            System.out.println("Khong tim thay lop hoc hoac mon hoc can sua.");
        } 
        else 
        {
            try{
                File file = new File("ThoiKhoaBieu.txt");
                FileWriter fR = new FileWriter(file);
                PrintWriter pR = new PrintWriter(fR);

                for (BuoiHoc buoiHoc : tKB) 
                {
                    pR.println(String.format("%d;%s;%s;%s;%s;%s",
                            buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                            buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

                }
                System.out.println("Sua thanh cong");
                fR.close();
                pR.close();
            } 
            catch (Exception e) 
            {
                System.out.println("Khong the ghi du lieu vao file.");
            }
        }
        System.out.println("Neu xem xong ban chi can nhan mot ki tu xong ban chi can an 1 ky tu xong an enter hoac chi can an enter");
        sc.nextLine();
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien();
    }
    
    public void timLop(){
        Scanner sc = new Scanner(System.in);
        tKB.clear();
        capNhatThongTinVaoArrayList();
    
        Scanner tenSinhVien = new Scanner(System.in);
        String lop;
        while(true){
            System.out.print("Vui long nhap lop de tim: ");
            lop = sc.nextLine();
            if(!lop.equals(""))
                break;
            if(lop.equals("")){
                System.out.println("Co the ban dang muon thoat(y/n)");
                String yOrN = sc.nextLine();
                if(yOrN.equalsIgnoreCase("y")){
                    if(tenDangNhap.endsWith("@sinhvien")){
                        SinhVien sV = new SinhVien(tenDangNhap, matKhau);
                        sV.xuatMenuCuaSinhVien();
                    }else if(tenDangNhap.endsWith("@giangvien")){
                        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                        gV.xuatMenuCuaGianVien();
                    }  
                    return;
                }else if(yOrN.equalsIgnoreCase("n")){
                    System.out.println("Vui long nhap ky tu");
                    continue;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
        }
        System.out.println("\t\t\t\t\t\t\t\t\tTHONG TIN TIM DUOC TRONG THOI KHOA BIEU");
        System.out.println(String.format("%-10s      %-10s          %-45s     %-50s     %-5s          %-60s",
                "So thu tu","Lop","Ten lop","Ngay va gio","Phong","Ngay len lop"));
        boolean ketQua = false;
        for (int i = 0; i < tKB.size(); i++) {
            BuoiHoc bH = tKB.get(i);
            if (bH.getLop().equals(lop)) {
                System.out.println(bH);
                ketQua =true;
            }
        }
        if(ketQua==false)
            System.out.println("Khong tim thay buoi hoc");
        while(true){
            System.out.println("Ban muon tiep tuc tim kiem(y,n):");
            String coNhapLai = sc.nextLine();
            if(coNhapLai.equalsIgnoreCase("y")){
                timLop();
                return;
            }else if(coNhapLai.equalsIgnoreCase("n")){
                if(tenDangNhap.endsWith("@sinhvien")){
                    SinhVien sV = new SinhVien(tenDangNhap, matKhau);
                    sV.xuatMenuCuaSinhVien();
                }else if(tenDangNhap.endsWith("@giangvien")){
                    GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                    gV.xuatMenuCuaGianVien();
                }  
                return;
            }else
                System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
        }
    }
    
    //@Overloanding
    public void xoa(){
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Ban chac chan muon xoa toan bo thoi khoa bieu(y,n):");
            String coNhapLai = sc.nextLine();
            if(coNhapLai.equalsIgnoreCase("y")){
                tKB.clear();
                capNhatThongTinVaoArrayList();
                if(tKB==null)
                    System.out.println("Khong co gi de xoa");
                else{
                    tKB.clear();
                }
            try{
                File file = new File("ThoiKhoaBieu.txt");
                FileWriter fR = new FileWriter(file);
                PrintWriter pR = new PrintWriter(fR);

                for (BuoiHoc buoiHoc : tKB) 
                {
                    pR.println(String.format("%d;%s;%s;%s;%s;%s",
                            buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                            buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

                }
                System.out.println("Xoa thanh cong");
                fR.close();
                pR.close();
            }catch(Exception e){
                    System.out.println("Khong the mo file");
            }
            return;
            }else if(coNhapLai.equalsIgnoreCase("n")){
                GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                gV.xuatMenuCuaGianVien();
                return;
            }else
                System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
        }
        
    }
    public boolean laSo(String mSSV){
        boolean kyTuSo=true;
        for(int i=0;i<mSSV.length();i++){
            if(Character.isLetter(mSSV.charAt(i))){
                kyTuSo=false;
            }
        }
            return kyTuSo;
    }
    //@Overloanding
    public void xoa(String viTri){
        tKB.clear();
        capNhatThongTinVaoArrayList();
        Scanner sc= new Scanner(System.in);
        String sTT;
        while(true){
            System.out.println("Nhap so thu thu cua thoi khoa bieu ma ban muon xoa hang do");;
            sTT = sc.nextLine();
            if(!sTT.equals("")){
                try{
                    if(laSo(sTT)){
                        Integer.parseInt(sTT);
                        break;
                    }else
                            System.out.println("Vui long nhap so");
                }catch(Exception e){
                    System.out.println("Vui long nhap so nguyen");
                }
            }
            if(sTT.equals("")){
                System.out.println("Co the ban dang muon thoat(y/n)");
                String yOrN = sc.nextLine();
                if(yOrN.equalsIgnoreCase("y")){
                    GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                    gV.xuatMenuCuaGianVien();
                    return;
                }else if(yOrN.equalsIgnoreCase("n")){
                    System.out.println("Vui long nhap ky tu");
                    continue;
                }else
                    System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
            }
        }
        boolean suaThanhCong=false;
        for (int i = 0; i < tKB.size(); i++) {
            BuoiHoc bH = tKB.get(i);
            if (bH.getSoThuTu()==Integer.parseInt(sTT)) {
                tKB.remove(i);
                suaThanhCong = true;
                break;
            }
        }
        if(suaThanhCong)
            System.out.println("Xoa thanh cong");
        else
            System.out.println("Khong tim thay so thu tu de xoa");
        try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

            }
            
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        while(true){
            System.out.println("Ban muon tiep tuc xoa(y,n):");
            String coNhapLai = sc.nextLine();
            if(coNhapLai.equalsIgnoreCase("y")){
                xoa("Vi tri cu the");
                return;
            }else if(coNhapLai.equalsIgnoreCase("n")){
                GiangVien gV = new GiangVien(tenDangNhap, matKhau);
                gV.xuatMenuCuaGianVien(); 
                return;
            }else
                System.out.println("Ban chi duoc nhap y neu la yes hoac n neu la no");
        }
    }
    public void sapXepTangDanTheoSST() 
    {    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                if(o1.getSoThuTu()>o2.getSoThuTu())
                    return 1;
                else if(o1.getSoThuTu()==o2.getSoThuTu())
                    return 0;
                else
                    return -1;
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
        public void sapXepGiamDanTheoSST() 
    {    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                if(o1.getSoThuTu()<o2.getSoThuTu())
                    return 1;
                else if(o1.getSoThuTu()==o2.getSoThuTu())
                    return 0;
                else
                    return -1;
            }
        };
        Collections.sort(tKB,sXTheoSTT);
        try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o1.getLop().compareTo(o2.getLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o2.getLop().compareTo(o1.getLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoTenLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o1.getTenLop().compareTo(o2.getTenLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoTenLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o2.getTenLop().compareTo(o1.getTenLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoNgayVaGio(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o1.getNgayVaGio().compareTo(o2.getNgayVaGio());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoNgayVaGio(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o2.getNgayVaGio().compareTo(o1.getNgayVaGio());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoPhong(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o1.getPhong().compareTo(o2.getPhong());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoPhong(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o2.getPhong().compareTo(o1.getPhong());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepTangDanTheoNgayLenLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o1.getNgayLenLop().compareTo(o2.getNgayLenLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void sapXepGiamDanTheoNgayLenLop(){    
        tKB.clear();
        capNhatThongTinVaoArrayList();

        Comparator sXTheoSTT = new Comparator<BuoiHoc>() {
          
            @Override
            public int compare(BuoiHoc o1, BuoiHoc o2) {
                return o2.getNgayLenLop().compareTo(o1.getNgayLenLop());
            }
        };
        Collections.sort(tKB,sXTheoSTT);
              try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);

            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        buoiHoc.getSoThuTu(), buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));

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
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien(); 
    }
    
    public void capNhatLaiSoThuTuT(){
        tKB.clear();
        capNhatThongTinVaoArrayList();
        try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);
            int i=0;
            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        i, buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));
                i++;
            }
            System.out.println("sua thanh cong");
            fR.close();
            pR.close();
            
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Cap nhat thanh cong");
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien();
    }
    
    public void capNhatLaiSoThuTuG(){
        tKB.clear();
        int i=capNhatThongTinVaoArrayList();
        try{
            File file = new File("ThoiKhoaBieu.txt");
            FileWriter fR = new FileWriter(file);
            PrintWriter pR = new PrintWriter(fR);
            
            for (BuoiHoc buoiHoc : tKB) 
            {
                pR.println(String.format("%d;%s;%s;%s;%s;%s",
                        i, buoiHoc.getLop(), buoiHoc.getTenLop(),
                        buoiHoc.getNgayVaGio(), buoiHoc.getPhong(), buoiHoc.getNgayLenLop()));
                i--;
            }
            
            fR.close();
            pR.close();
        } 
        catch (Exception e) 
        {
            System.out.println("Khong the ghi du lieu vao file.");
        }
        System.out.println("Cap nhat thanh cong");
        GiangVien gV = new GiangVien(tenDangNhap, matKhau);
        gV.xuatMenuCuaGianVien();
    }
}