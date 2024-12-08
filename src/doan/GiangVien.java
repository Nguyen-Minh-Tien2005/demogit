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
public class GiangVien extends TaiKhoan implements ThongTinNguoiDung{
    protected String tenGiangVien;

    public GiangVien(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
    }

    
    public String getTenGiangVien() {
        return tenGiangVien;
    }

  
    
    @Override
    public void xuatThongTinCaNhan() {
        Scanner sc = new Scanner(System.in);
        try{
            File file = new File("TaiKhoangGiangVien.txt");
            FileReader fR = new FileReader(file);
            BufferedReader bR = new BufferedReader(fR);
            String thongTinCuaGiangVien;
            
            while((thongTinCuaGiangVien=bR.readLine())!=null){
                String arr[]=thongTinCuaGiangVien.trim().split("[;]+");
                if(arr[0].equals(tenDangNhap)&& arr[1].equals(matKhau)){
                    System.out.println("Ten giang vien: "+arr[2]);
                    System.out.println("Tai khoang: "+arr[0]);
                    break;
                }
            }
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
        Scanner sc =new Scanner(System.in);
        System.out.println(
                  "\n31. Cap nhat lai so thu tu giam"
                + "\n30. Cap nhat lai so thu tu tang"
                + "\n29. Sap xep giam dan theo ngay len lop"
                + "\n28. Sap xep tang dan theo ngay len lop"
                + "\n27. Sap xep giam dan theo phong"
                + "\n26. Sap xep tang dan theo phong"
                + "\n25. Sap xep giam dan theo ngay va gio"
                + "\n24. Sap xep tang dan theo ngay va gio"
                + "\n23. Sap xep giam dan theo ten lop"
                + "\n22. Sap xep tang dan theo ten lop"
                + "\n21. Sap xep giam dan theo lop"
                + "\n20. Sap xep tang dan theo lop"
                + "\n19. Sap xep giam dan theo so thu tu"
                + "\n18. Sap xep tang dan theo so thu tu"
                + "\n17. Tim lop"
                + "\n16. Sua thoi khoa bieu"
                + "\n15. Xoa thoi khoa bieu tai vi tri cu the"
                + "\n14. Xoa toan bo thoi khoa bieu "
                + "\n13. Them thong tin vao thoi khoa bieu"
                + "\n12. Xuat thoi khoa bieu"
                + "\n11. Sap xep giam dan theo tai khoan"
                + "\n10. Sap xep tang dan theo tai khoan"
                + "\n9. Sap xep giam dan theo ho va ten"
                + "\n8. Sap xep tang dan theo ho va ten"
                + "\n7. Sap xep giam dan theo ma so sinh vien"
                + "\n6. Sap xep tang dan theo ma so sinh vien"
                + "\n5. Sap xep giam dan theo nganh"
                + "\n4. Sap xep tang dan theo nganh"
                + "\n3. Tim thong tin sinh vien theo ma so sinh vien"
                + "\n2. Xem thong tin sinh vien"
                + "\n1. Xuat thong tin ca nhan"
                + "\n0. Thoat");
        int soCanThucHien;
        
        while(true){
            try{
                System.out.println("\nNhap lua chon cua ban:");
                soCanThucHien = Integer.parseInt(sc.nextLine());
                if(!(0>soCanThucHien || soCanThucHien>31)){
                    break;
                }else
                    System.out.println("Vui long nhap trong pham vi ");
            }catch(Exception e){
                System.out.println("Vui long nhap so nguyen");
            }
        }
        ThoiKhoaBieu tKB = new ThoiKhoaBieu(tenDangNhap, matKhau);
        DanhSachSinhVien dSSV = new DanhSachSinhVien(tenDangNhap,matKhau);
        switch(soCanThucHien){
            case 31: tKB.capNhatLaiSoThuTuG();break;
            case 30: tKB.capNhatLaiSoThuTuT();break;
            case 29: tKB.sapXepGiamDanTheoNgayLenLop();break;
            case 28: tKB.sapXepTangDanTheoNgayLenLop();break;
            case 27: tKB.sapXepGiamDanTheoPhong();break;
            case 26: tKB.sapXepTangDanTheoPhong();break;
            case 25: tKB.sapXepGiamDanTheoNgayVaGio();break;
            case 24: tKB.sapXepTangDanTheoNgayVaGio();break;
            case 23: tKB.sapXepGiamDanTheoTenLop();break;
            case 22: tKB.sapXepTangDanTheoTenLop();break;
            case 21: tKB.sapXepGiamDanTheoLop();break;
            case 20: tKB.sapXepTangDanTheoLop();break;
            case 19: tKB.sapXepGiamDanTheoSST();break;
            case 18: tKB.sapXepTangDanTheoSST();break;
            case 17: tKB.timLop();break;
            case 16: tKB.suaThongTin();break;
            case 15: tKB.xoa("Vi tri");break;
            case 14: tKB.xoa();break;
            case 13: tKB.themThongTinThoiKhoaBieu();break;
            case 12: tKB.xuatThoiKhoaBieu();break;
            case 11: dSSV.sapXepGiamDanTheoTaiKhoan();break;
            case 10: dSSV.sapXepTangDanTheoTaiKhoan();break;
            case 9: dSSV.sapXepGiamDanTheoHoTen();break;
            case 8: dSSV.sapXepTangDanTheoHoTen();break;
            case 7: dSSV.sapXepGiamDanTheoMSSV();break;
            case 6: dSSV.sapXepTangDanTheoMSSV();break;
            case 5: dSSV.sapXepGiamDanTheoNganh();break;
            case 4: dSSV.sapXepTangDanTheoNganh();break;
            case 3: dSSV.timThongTinSinhVien();break;
            case 2: dSSV.xuatDanhSachSV();break;
            case 1: xuatThongTinCaNhan();break;
            case 0: xuatMenu();break;
        }
        
    }
}




    
    
    
