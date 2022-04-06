package Task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.concurrent.Callable;


public class MyCallable1 implements Callable<ArrayList<Record>> {

    @Override
    public ArrayList <Record> call() throws Exception {
        ArrayList <Record> records = new ArrayList<>();
        String line="";
        try {
            FileReader fr = new FileReader("C:\\Users\\Admin\\Desktop\\Task1\\input.txt");
            BufferedReader br = new BufferedReader(fr);
            while (true) {
                if (line == null) {
                    break;
                }
                line = br.readLine();
                String[] bits = line.split("\\|");
                records.add(new Record(bits[bits.length-3],bits[bits.length-2],bits[bits.length-1]));
            }
        } catch (Exception e) {
        }
        return records;
    }
}
