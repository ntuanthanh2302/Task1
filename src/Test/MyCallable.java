package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.Callable;

public class MyCallable implements Callable<Integer> {

    private String name;
    private String name2;;
    private int count1;
    public MyCallable(String name,String name2) {
        this.name = name;
        this.name2 = name2;
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
                count1+= count;
            }
            fr.close();
        }
        catch (IOException e) {
            System.out.println("Có lỗi.");
            e.printStackTrace();
        }
        return count1;
    }
}
