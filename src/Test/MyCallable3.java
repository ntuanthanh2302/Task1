package Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.concurrent.Callable;

public class MyCallable3 implements Callable<Integer> {
    private String name;
    private String a;
    int count;
    public MyCallable3(String name,String a) {
        this.name = name;
        this.a=a;
    }

    @Override
    public Integer call()  {
        try {
            String line="";
            FileReader fr = new FileReader(name);
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                if (line == null) {
                    break;
                }
                line = br.readLine();
                int lastIndex = 0;
                while (lastIndex != -1) {
                    lastIndex = line.indexOf(a, lastIndex);

                    if (lastIndex != -1) {
                        count++;
                        lastIndex += a.length();
                    }
                }
            }
        } catch (Exception e) {
        }
        return count;
    }
}
