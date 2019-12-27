package com.storebillcalculator.service;

import com.storebillcalculator.model.BillDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class BillCalculation {

    @Autowired
    BillCalculatorBuilder billCalculatorBuilder;
    @GetMapping("/getDiscountedBill/{amount}/{discountCategory}")
    @ResponseBody
    public BillDetails getGeneratedBill(@PathVariable("amount") double amount, @PathVariable("discountCategory") String discountCategory, @RequestParam String itemCategory) {

        return billCalculatorBuilder.generateBill(amount, discountCategory, itemCategory);
    }
}
