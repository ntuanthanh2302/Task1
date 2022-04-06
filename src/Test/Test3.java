package Test;

import java.util.Random;
import java.util.concurrent.Callable;

public class Test3 implements Callable<Integer> {

    private int num;
    private Random ran;

    public Test3(int num) {
        this.num = num;
        this.ran = new Random();
    }

    public Integer call() throws Exception {
       // Thread.sleep(ran.nextInt(10) * 1000);
        int result = num * num;
        System.out.println("Complete " + num);
        return result;
    }
}