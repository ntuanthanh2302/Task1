package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

/**
 *
 * @author Admin
 */
public class MyRunnable implements Runnable {

    private String name;
    private String name2;

    public MyRunnable(String name,String name2) {
        this.name = name;
        this.name2 = name2;
    }

    @Override
    public void run() {
        try {
            int count=0;
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            String s;
            while ((s = br.readLine()) != null) {
                count += s.replace(" ", "").length();
            }
            fr.close();
            System.out.println("Số ký tự trong file "+name2+" là: " + count +" ký tự");
        } catch (IOException e) {
            System.out.println("Có lỗi.");
            e.printStackTrace();
        }
    }
}
