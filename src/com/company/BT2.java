package com.company;

import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(System.in);
        String s;
        System.out.println("Nhập số điện thoại để check:");
        s= ip.nextLine();

        while (s.length()!=10 || s.charAt(0)!= '0') {
            System.out.println("Số điện thoại sai, mời nhập lại: ");
            s= ip.nextLine();
        }
        System.out.println("Số điện thoại đúng là :"+s);
    }
}
