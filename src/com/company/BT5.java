package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class BT5 {
    private void fetchChild(File file) {
        if (file.getAbsolutePath().endsWith(".txt")) {
            try {
                int count = 0;
                FileReader fr = new FileReader(file);
                BufferedReader br = new BufferedReader(fr);
                String s;
                while ((s = br.readLine()) != null) {
                    count += s.replace(" ", "").length();
                }
                fr.close();
                System.out.println("Số ký tự trong file "+file.getName()+" là: " + count +" ký tự");
            } catch (IOException e) {
                System.out.println("Có lỗi.");
                e.printStackTrace();
            }
        }
        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                    this.fetchChild(child);
            }
        }
    }

    public static void main(String[] args) {
        BT5 example = new BT5();

        File dir = new File("C:\\Users\\Admin\\Desktop");

        example.fetchChild(dir);
    }
}
