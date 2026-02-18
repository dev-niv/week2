package com.example.datageneratorjava;

import com.example.datageneratorjava.service.CsvWriter;
import com.example.datageneratorjava.util.FakerUtil;

public class DataGeneratorJavaApplication {

    public static void main(String[] args) throws Exception {

        String size = args.length > 0 ? args[0] : "S";

        int rows;
        long seed = 12345L;

        switch(size.toUpperCase()) {
            case "M": rows = 100_000; break;
            case "L": rows = 1_000_000; break;
            default: rows = 10_000;
        }

        FakerUtil.init(seed);

        StringBuilder fenergo = new StringBuilder();
        StringBuilder gears = new StringBuilder();

        fenergo.append("kyc_unified_id,customer_name,customer_type,country_code,risk_rating,snapshot_date\n");
        gears.append("kyc_unified_id,account_status,transaction_count,total_value,snapshot_date\n");

        for(int i=1;i<=rows;i++) {

            String id = "KYC" + i;

            fenergo.append(id).append(",")
                    .append(FakerUtil.customerName()).append(",")
                    .append(FakerUtil.customerType()).append(",")
                    .append(FakerUtil.countryCode()).append(",")
                    .append(FakerUtil.riskRating()).append(",")
                    .append(FakerUtil.snapshotDate())
                    .append("\n");

            gears.append(id).append(",")
                    .append(FakerUtil.accountStatus()).append(",")
                    .append(FakerUtil.transactionCount()).append(",")
                    .append(FakerUtil.totalValue()).append(",")
                    .append(FakerUtil.snapshotDate())
                    .append("\n");
        }

        new java.io.File("/output").mkdirs();

        CsvWriter.write("/output/fenergo.csv", fenergo.toString());
        CsvWriter.write("/output/gears.csv", gears.toString());

        System.out.println("Generated " + rows + " rows");
    }
}
