package com.company;

import java.util.Scanner;

import static java.lang.System.in;

public class BT1 {
    public static void main(String[] args) {
        Scanner ip = new Scanner(in);
        int n;
        System.out.println("Nhập n:");
        n= Integer.parseInt(ip.nextLine());
        System.out.println("Các số từ 0 đến n là:");
        for (int i = 0; i < n; i++) {
            System.out.print(i+" ");
        }

        System.out.println("\nCác số chia hết cho 3 từ 0 đến n theo thứ tự giảm dần:");
        for (int j = n; j >0 ; j--) {
            if (j%3==0) {
                System.out.print(j+" ");
            }
        }
    }
}
