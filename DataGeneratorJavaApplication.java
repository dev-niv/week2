package com.example.datagenerator;

import com.example.datagenerator.service.DataGeneratorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataGeneratorApplication {

    public static void main(String[] args) {

        SpringApplication.run(DataGeneratorApplication.class, args);

        DataGeneratorService service = new DataGeneratorService();
        service.generate();
    }
}
