package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class MyCallable2 implements Callable<Integer> {
    private String name;
    public MyCallable2(String name) {
        this.name = name;
    }


    @Override
    public Integer call() throws Exception {
        int count=0;
        try {
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                count += s.replace(" ", "").length();
            }
            fr.close();
        }
        catch (IOException e) {
            System.out.println("Có lỗi.");
            e.printStackTrace();
        }
        return count;
    }
}
