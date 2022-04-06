package Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 *
 * @author Admin
 */
public class Test2 {


    private void fetchChild(File file) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<Integer>> listFuture = new ArrayList<>();
        Future<Integer> future;
        Callable<Integer> callable;
        int sum =0;
        if (file.getAbsolutePath().endsWith(".txt")) {
            //System.out.println(file.getName());
            MyRunnable myrunnable = new MyRunnable(file.getAbsolutePath(),file.getName());
            //MyCallable myCallable = new MyCallable(file.getAbsolutePath(),file.getName());
            callable= new MyCallable(file.getAbsolutePath(),file.getName());
            executorService.execute(myrunnable);
            future = executorService.submit(callable);
            listFuture.add(future);

            executorService.shutdown();
        }

        if (file.isDirectory()) {
            File[] children = file.listFiles();
            for (File child : children) {
                this.fetchChild(child);
            }
        }
    }



    public static void main(String[] args) {
        Test2 e = new Test2();

        File dir = new File("C:\\Users\\Admin\\Desktop\\Task1");

        e.fetchChild(dir);

    }
}