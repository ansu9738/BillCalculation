package com.storebillcalculator.billcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@ComponentScan(basePackages = {"com.storebillcalculator.service"})
@SpringBootApplication
public class BillcalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillcalculatorApplication.class, args);
    }

}
