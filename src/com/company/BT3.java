package com.company;

import java.io.*;
import java.util.Scanner;

public class BT3 {
    public static void main(String[] args) {
        String txt;
        String line = "";
        Scanner ip = new Scanner(System.in);

        //Ghi file
        System.out.println("Nhập dữ liệu để ghi vào file text:");
        txt = ip.nextLine();
        try {
            FileWriter fw = new FileWriter("data.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.newLine();
            bw.write(txt);
            bw.close();
        } catch (Exception e) {
        }

        //Đọc file
        System.out.println("Dữ liệu trong file txt là:");
        try {
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                if (line == null) {
                    break;
                }
                line = br.readLine();
                System.out.println(line);
            }
        } catch (Exception e) {
        }

        //Đếm số ký tự trong file
        try {
            int count = 0;
            FileReader fr = new FileReader("data.txt");
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                count += s.replace(" ", "").length();
            }
            fr.close();
            System.out.println("Số ký tự trong file là:" + count);
        } catch (IOException e) {
            System.out.println("Có lỗi.");
            e.printStackTrace();
        }
    }
}
