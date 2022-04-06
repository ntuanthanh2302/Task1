package Task2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList <Record> records = new ArrayList<Record>();
        MyCallable1 mycallble1 =new MyCallable1();
        try {
            ArrayList<Record> rs = (ArrayList<Record>) mycallble1.call();
        } catch (Exception e) {
            e.printStackTrace();
        }




    }
}
