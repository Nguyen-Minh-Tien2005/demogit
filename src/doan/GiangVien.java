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
public class GiangVien extends TaiKhoan {
    private String tenGiangVien;
    private String mSGV;

    public GiangVien(String tenDangNhap, String matKhau) {
        super(tenDangNhap, matKhau);
    }

    
    public String getTenGiangVien() {
        return tenGiangVien;
    }
}




    
    
    
