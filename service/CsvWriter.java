package com.example.datagenerator.service;

import com.example.datagenerator.model.FenergoRecord;
import com.example.datagenerator.model.GearsRecord;
import com.example.datagenerator.util.CsvWriter;

import java.time.LocalDate;
import java.util.*;

public class DataGeneratorService {

    public void generate() {

        String sizeEnv = System.getenv().getOrDefault("SIZE", "S");
        long seed = Long.parseLong(System.getenv().getOrDefault("SEED", "42"));
        String snap = System.getenv().getOrDefault("SNAPSHOT_DATE", "2026-02-01");

        int size;
        switch (sizeEnv) {
            case "M": size = 100_000; break;
            case "L": size = 1_000_000; break;
            default: size = 10_000;
        }

        Random random = new Random(seed);
        LocalDate snapshotDate = LocalDate.parse(snap);

        System.out.println("SIZE=" + sizeEnv);
        System.out.println("ROWS=" + size);
        System.out.println("SEED=" + seed);
        System.out.println("SNAPSHOT=" + snapshotDate);

        List<FenergoRecord> fenergo = new ArrayList<>();
        List<GearsRecord> gears = new ArrayList<>();

        for (int i = 1; i <= size; i++) {

            String kyc = String.format("KYC%06d", i);

            fenergo.add(new FenergoRecord(
                    i,
                    kyc,
                    "Customer_" + i,
                    random.nextBoolean() ? "Individual" : "Business",
                    "IN",
                    random.nextBoolean() ? "LOW" : "HIGH",
                    snapshotDate
            ));

            gears.add(new GearsRecord(
                    i,
                    kyc,
                    random.nextBoolean() ? "ACTIVE" : "SUSPENDED",
                    random.nextInt(50),
                    random.nextInt(500000),
                    snapshotDate
            ));
        }

        CsvWriter.writeFenergo(fenergo);
        CsvWriter.writeGears(gears);

        System.out.println("CSV generation completed.");
    }
}
