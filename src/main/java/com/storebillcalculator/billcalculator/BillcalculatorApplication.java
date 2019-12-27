package com.storebillcalculator.billcalculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.storebillcalculator.*"})
@SpringBootApplication
public class BillcalculatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillcalculatorApplication.class, args);
    }

}
