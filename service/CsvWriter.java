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

boolean delta = Boolean.parseBoolean(
        System.getenv().getOrDefault("DELTA", "false")
);

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

    // Base deterministic values
    String risk = random.nextBoolean() ? "LOW" : "HIGH";
    String status = random.nextBoolean() ? "ACTIVE" : "SUSPENDED";
    int txnCount = random.nextInt(50);
    int totalValue = random.nextInt(500000);

    // DELTA MODE → mutate 30% of customers
    if (delta && random.nextInt(100) < 30) {
        risk = risk.equals("LOW") ? "HIGH" : "LOW";
        status = status.equals("ACTIVE") ? "SUSPENDED" : "ACTIVE";
        txnCount += 5;
        totalValue += 10000;
    }

    fenergo.add(new FenergoRecord(
            i,
            kyc,
            "Customer_" + i,
            random.nextBoolean() ? "Individual" : "Business",
            "IN",
            risk,
            snapshotDate
    ));

    gears.add(new GearsRecord(
            i,
            kyc,
            status,
            txnCount,
            totalValue,
            snapshotDate
    ));
}

        CsvWriter.writeFenergo(fenergo);
        CsvWriter.writeGears(gears);

        System.out.println("CSV generation completed.");
    }
}
