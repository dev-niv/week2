package com.example.datageneratorjava.util;

import com.github.javafaker.Faker;
import java.time.LocalDate;
import java.util.Random;

public class FakerUtil {

    static Faker faker;

    public static void init(long seed) {
        faker = new Faker(new Random(seed));
    }

    public static String customerName() {
        return faker.company().name();
    }

    public static String customerType() {
        return faker.bool().bool() ? "INDIVIDUAL" : "CORPORATE";
    }

    public static String countryCode() {
        String[] c = {"IN","US","UK","FR"};
        return c[faker.random().nextInt(4)];
    }

    public static String riskRating() {
        String[] r = {"HIGH","MEDIUM","LOW"};
        return r[faker.random().nextInt(3)];
    }

    public static String accountStatus() {
        return faker.bool().bool() ? "ACTIVE" : "INACTIVE";
    }

    public static int transactionCount() {
        return faker.number().numberBetween(10, 5000);
    }

    public static double totalValue() {
        return faker.number().randomDouble(2, 1000, 500000);
    }

    public static String snapshotDate() {
        return LocalDate.now().toString();
    }
}
