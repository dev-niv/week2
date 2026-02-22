package com.example.datagenerator.model;

import java.time.LocalDate;

public class GearsRecord {

    public int id;
    public String kycUnifiedId;
    public String accountStatus;
    public int transactionCount;
    public int totalValue;
    public LocalDate snapshotDate;

    public GearsRecord(int id, String kycUnifiedId,
                       String accountStatus, int transactionCount,
                       int totalValue, LocalDate snapshotDate) {

        this.id = id;
        this.kycUnifiedId = kycUnifiedId;
        this.accountStatus = accountStatus;
        this.transactionCount = transactionCount;
        this.totalValue = totalValue;
        this.snapshotDate = snapshotDate;
    }
}
