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
public class SinhVien extends TaiKhoan{
    private String hoVaTen;
    private String mSSV;
    private String nganh;

    

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
    
    public String toString() { 

        return String.format("%-30s %-30s %-30s %-30s", hoVaTen, mSSV, nganh, tenDangNhap);
    }
    
    
}