package com.storebillcalculator.service;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * BillCalculator class is responsible for
 * generating the bill by calculating the actual
 * amount after removing the discounted amount
 * @author Ankit Jaiswal
 */
@Component
public class BillCalculatorBuilder {

    /**
     * This method creates a map of respective percentage values of the
     * discounts and then calls getActualAmount passing amount userstatus
     * and discount map to get the calculated discounted amount.
     * @param amount
     * @param userStatus
     * @param itemCategory
     * @return
     */
    public double generateBill(double amount, String userStatus, String itemCategory){
        Map<String, Integer> discountMap = new HashMap<>();
        double amountAfterDefaultDiscount = amount - BillGenerationConstant.DEFAULT_DISCOUNT;
        if(BillGenerationConstant.ITEMS_DEPT.equalsIgnoreCase(itemCategory)){
            BillGenerationConstant.IS_DISCOUNT_APPLICABLE = false;
        }
        if(BillGenerationConstant.EMPLOYEE_OF_STORE.equalsIgnoreCase(userStatus)){
            discountMap.put(BillGenerationConstant.EMPLOYEE_OF_STORE, 30);
        } else if (BillGenerationConstant.AFFILIATED_TO_THE_STORE.equalsIgnoreCase(userStatus)){
            discountMap.put(BillGenerationConstant.AFFILIATED_TO_THE_STORE, 10);
        } else if (BillGenerationConstant.CUSTOMER_FOR_OVER_TWO_YEARS.equalsIgnoreCase(userStatus)){
            discountMap.put(BillGenerationConstant.CUSTOMER_FOR_OVER_TWO_YEARS, 5);
        }

        double discountedAmountUserGets = getActualAmount(discountMap, amountAfterDefaultDiscount, userStatus);
        return discountedAmountUserGets;
    }

    /**
     * This method returns the calculated discounted amount based on
     * the userstatus and the percentage value passed.
     * @param discountMap
     * @param amountAfterDefaultDiscount
     * @param userStatus
     * @return
     */
    public double getActualAmount(Map<String, Integer> discountMap, double amountAfterDefaultDiscount, String userStatus) {
        double actualAmount = 0;
        if(BillGenerationConstant.IS_DISCOUNT_APPLICABLE) {
            int discountedPercentage = discountMap.get(userStatus);
            double discAmount = discountedPercentage * amountAfterDefaultDiscount / 100;
            actualAmount = amountAfterDefaultDiscount - discAmount;
        } else {
            actualAmount = amountAfterDefaultDiscount;
        }
        return actualAmount;
    }
}
