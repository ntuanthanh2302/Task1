package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BT4 {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\Admin\\Desktop\\Task1");

        File[] fileArray = file.listFiles(new TxtFileFilter());

        System.out.println("Các file txt có trong folder là:");
        for (File f : fileArray) {
            System.out.println("=============================");
            System.out.println(f.getAbsolutePath());
            try {
                int count = 0;
                FileReader fr = new FileReader(f);
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {
                    count += s.replace(" ", "").length();
                }
                fr.close();
                System.out.println("Số ký tự trong file "+f.getName()+" là: " + count +" ký tự");
            } catch (IOException e) {
                System.out.println("Có lỗi.");
                e.printStackTrace();
            }
        }
    }
}
