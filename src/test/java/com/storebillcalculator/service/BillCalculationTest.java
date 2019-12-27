package com.storebillcalculator.service;

import com.storebillcalculator.model.BillDetails;
import org.junit.Before;
import org.junit.Test;

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

        // Configure BillCalculatorBuilder.generateBill(...).
        final BillDetails billDetails = new BillDetails();
        billDetails.setEndBillAmntAfterDiscount(0.0);
        billDetails.setActualMrpPrice(0.0);
        billDetails.setItemCategory("itemCategory");
        billDetails.setDiscountPercentCtgApplicable("discountPercentCtgApplicable");
        when(billCalculationUnderTest.billCalculatorBuilder.generateBill(0.0, "discountPercentageApplicable", "itemCategory")).thenReturn(billDetails);

        // Run the test
        final BillDetails result = billCalculationUnderTest.getGeneratedBill(0.0, "discountCategory", "itemCategory");

        // Verify the results
    }
}
