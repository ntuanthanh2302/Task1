package com.company;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.Callable;

public class Test implements Callable<File> {

    public File file;

    public Test(File file) {
        super();
        this.file = file;
    }




    @Override
    public File call() throws Exception {
        return null;
    }
}
