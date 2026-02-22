package com.example.datagenerator.util;

import com.example.datagenerator.model.FenergoRecord;
import com.example.datagenerator.model.GearsRecord;

import java.io.*;
import java.util.List;

public class CsvWriter {

    public static void writeFenergo(List<FenergoRecord> records) {

        try {
            new File("output").mkdir();

            BufferedWriter bw = new BufferedWriter(new FileWriter("output/fenergo.csv"));

            bw.write("id,kyc_unified_id,customer_name,customer_type,country_code,risk_rating,snapshot_date\n");

            for (FenergoRecord r : records) {
                bw.write(r.id + "," + r.kycUnifiedId + "," + r.customerName + "," +
                        r.customerType + "," + r.countryCode + "," +
                        r.riskRating + "," + r.snapshotDate + "\n");
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void writeGears(List<GearsRecord> records) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("output/gears.csv"));

            bw.write("id,kyc_unified_id,account_status,transaction_count,total_value,snapshot_date\n");

            for (GearsRecord r : records) {
                bw.write(r.id + "," + r.kycUnifiedId + "," + r.accountStatus + "," +
                        r.transactionCount + "," + r.totalValue + "," +
                        r.snapshotDate + "\n");
            }

            bw.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
