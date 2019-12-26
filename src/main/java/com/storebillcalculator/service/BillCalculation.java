package com.storebillcalculator.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillCalculation {

    @Autowired
    BillCalculatorBuilder billCalculatorBuilder;
    @GetMapping("/getDiscountedBill/{amount}/{status}")
    @ResponseBody
    public double  getGeneratedBill(@PathVariable("amount") double amount, @PathVariable("status") String status, @RequestParam String itemCategory) {
        double calculatedBill = billCalculatorBuilder.generateBill(amount, status, itemCategory);
        return calculatedBill;
    }
}
