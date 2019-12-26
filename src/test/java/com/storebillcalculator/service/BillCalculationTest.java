package com.storebillcalculator.service;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BillCalculationTest {

    private BillCalculation billCalculationUnderTest;

    @Before
    public void setUp() {
        billCalculationUnderTest = new BillCalculation();
        billCalculationUnderTest.billCalculatorBuilder = mock(BillCalculatorBuilder.class);
    }

    @Test
    public void testGetGeneratedBill() {
        // Setup
        when(billCalculationUnderTest.billCalculatorBuilder.generateBill(0.0, "userStatus", "itemCategory")).thenReturn(0.0);

        // Run the test
        final double result = billCalculationUnderTest.getGeneratedBill(0.0, "status", "itemCategory");

        // Verify the results
        assertEquals(0.0, result, 0.0001);
    }
}
