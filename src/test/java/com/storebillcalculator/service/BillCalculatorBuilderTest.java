
                                                                                                                                                                                                                                                                                                                                                                                                                                                                        
package com.storebillcalculator.service;

import com.storebillcalculator.model.BillDetails;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

public class BillCalculatorBuilderTest {

 @Mock
 private BillDetails mockBillDetails;

 @InjectMocks
 private BillCalculatorBuilder billCalculatorBuilderUnderTest;

@Before
public void setUp() {

    initMocks(this);

}
                
    @Test
    public void testGenerateBill() throws Exception {
    // Setup
        
    // Run the test
     final BillDetails result =  billCalculatorBuilderUnderTest.generateBill(999,"employeeofstore","cloth");

        // Verify the results
        verify( mockBillDetails ).setDiscountPercentCtgApplicable("employeeofstore");
        verify( mockBillDetails ).setActualMrpPrice(999);
        verify( mockBillDetails ).setItemCategory("cloth");
        verify( mockBillDetails ).setEndBillAmntAfterDiscount(695.8);
    }
                                                                                
    @Test
    public void testGetActualAmount() throws Exception {
    // Setup
        final Map<String, Integer> discountMap = new HashMap<>();
        discountMap.put(BillGenerationConstant.EMPLOYEE_OF_STORE, 30);
    // Run the test
         final double result =  billCalculatorBuilderUnderTest.getActualAmount(discountMap,994,"employeeofstore");

        // Verify the results
          assertEquals( 695.8, result, 0.0001) ;
    }
                                                                }

