package com.example.datagenerator.model;

import java.time.LocalDate;

public class FenergoRecord {

    public int id;
    public String kycUnifiedId;
    public String customerName;
    public String customerType;
    public String countryCode;
    public String riskRating;
    public LocalDate snapshotDate;

    public FenergoRecord(int id, String kycUnifiedId, String customerName,
                         String customerType, String countryCode,
                         String riskRating, LocalDate snapshotDate) {

        this.id = id;
        this.kycUnifiedId = kycUnifiedId;
        this.customerName = customerName;
        this.customerType = customerType;
        this.countryCode = countryCode;
        this.riskRating = riskRating;
        this.snapshotDate = snapshotDate;
    }
}
