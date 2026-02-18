package com.example.datageneratorjava.service;

import java.io.FileWriter;

public class CsvWriter {

    public static void write(String path, String data) throws Exception {
        FileWriter fw = new FileWriter(path);
        fw.write(data);
        fw.close();
    }
}
