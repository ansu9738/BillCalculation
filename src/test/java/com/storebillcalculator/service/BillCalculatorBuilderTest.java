package com.storebillcalculator.service;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class BillCalculatorBuilderTest {

    private BillCalculatorBuilder billCalculatorBuilderUnderTest;
    private static final Map<String, Integer> discountMap = new HashMap<>();
    static {
        discountMap.put(BillGenerationConstant.EMPLOYEE_OF_STORE, 30);
    }
    @Before
    public void setUp() {
        billCalculatorBuilderUnderTest = new BillCalculatorBuilder();
    }

    @Test
    public void testGenerateBill() {
        // Setup

        // Run the test
        final double result = billCalculatorBuilderUnderTest.generateBill(999, "employeeofstore", "itemCategory");

        // Verify the results
        assertEquals(695.8, result, 0.0001);
    }

    @Test
    public void testGenerateBillForGroceries() {
        // Setup

        // Run the test
        final double result = billCalculatorBuilderUnderTest.generateBill(999, "employeeofstore", "groceries");

        // Verify the results
        assertEquals(994, result, 0.0001);
    }

    @Test
    public void testGetActualAmount() {
        // Setup
        //final Map<String, Integer> discountMap = new HashMap<>();

        // Run the test
         final double result = billCalculatorBuilderUnderTest.getActualAmount(discountMap, 994, "employeeofstore");

        // Verify the results
        assertEquals(695.8, result, 0.0001);
    }

    @Test
    public void testGetActualAmountForGroceries() {
        // Setup
        //final Map<String, Integer> discountMap = new HashMap<>();

        // Run the test
        final double result = billCalculatorBuilderUnderTest.getActualAmount(discountMap, 994, "employeeofstore");

        // Verify the results
        assertEquals(695.8, result, 0.0001);
    }

}
