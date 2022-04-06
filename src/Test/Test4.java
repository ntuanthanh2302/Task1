package Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;
import java.util.stream.Stream;

public class Test4 {
    public static void main(String[] args) {
        //Tạo 1 ThreadPool
        ExecutorService executorService = Executors.newCachedThreadPool();
        Callable<Integer> callable;
        List<Future<Integer>> listFuture = new ArrayList<>();
        List<Future<Integer>> listFuture1 = new ArrayList<>();
        Future<Integer> future;
        Future<Integer> future1;
        Scanner ip = new Scanner(System.in);
        String a;
        System.out.print("Nhập chữ cần check:");
        a = ip.nextLine();
        try (Stream<Path> walk = Files.walk(Paths.get("C:\\Users\\Admin\\Desktop\\Task1"))) {
            List<String> result = walk.map(Path::toString).filter(f -> f.endsWith(".txt")).toList();

            //Đếm số ký tự trong mỗi file txt
            for (String s : result) {
                MyRunnable2 myrunnable = new MyRunnable2(s);
                executorService.execute(myrunnable);
            }

            //Tính tổng số ký tự trong folder
            for (String s : result) {
                callable = new MyCallable2(s);
                future = executorService.submit(callable);
                listFuture.add(future);
            }

            //Đếm số lần xuất hiện của 1 chuỗi nhập từ bàn phím
            for (String s : result) {
                callable = new MyCallable3(s, a);
                future1 = executorService.submit(callable);
                listFuture1.add(future1);
            }

            executorService.shutdown();
            int sum=0;
            for(Future<Integer> f :listFuture){
                try {
                    sum += f.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Tổng số ký tự trong folder là: "+sum+" ký tự");

            int count=0;
            for(Future<Integer> f :listFuture1){
                try {
                    count += f.get();
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Số lần xuất hiện của từ "+"\""+a+"\""+" trong folder là: "+count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
