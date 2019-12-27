package com.storebillcalculator.service;

import com.storebillcalculator.model.BillDetails;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private BillDetails billDetails;


    /**
     * This method creates a map of respective percentage values of the
     * discounts and then calls getActualAmount passing amount userstatus
     * and discount map to get the calculated discounted amount.
     * @param amount
     * @param userStatus
     * @param itemCategory
     * @return
     */
    public BillDetails generateBill(double amount, String discountPercentageApplicable, String itemCategory){
        Map<String, Integer> discountMap = new HashMap<>();
        double amountAfterDefaultDiscount = amount - BillGenerationConstant.DEFAULT_DISCOUNT;
        if(BillGenerationConstant.EMPLOYEE_OF_STORE.equalsIgnoreCase(discountPercentageApplicable)){
            discountMap.put(BillGenerationConstant.EMPLOYEE_OF_STORE, 30);
        } else if (BillGenerationConstant.AFFILIATED_TO_THE_STORE.equalsIgnoreCase(discountPercentageApplicable)){
            discountMap.put(BillGenerationConstant.AFFILIATED_TO_THE_STORE, 10);
        } else if (BillGenerationConstant.CUSTOMER_FOR_OVER_TWO_YEARS.equalsIgnoreCase(discountPercentageApplicable)){
            discountMap.put(BillGenerationConstant.CUSTOMER_FOR_OVER_TWO_YEARS, 5);
        }
        if(BillGenerationConstant.ITEMS_DEPT.equalsIgnoreCase(itemCategory)){
            BillGenerationConstant.IS_DISCOUNT_APPLICABLE = false;
            billDetails.setDiscountPercentCtgApplicable("");
        }else {
            billDetails.setDiscountPercentCtgApplicable(discountPercentageApplicable);
        }
        double endBillAmntAfterDiscount = getActualAmount(discountMap, amountAfterDefaultDiscount, discountPercentageApplicable);
        billDetails.setActualMrpPrice(amount);
        billDetails.setItemCategory(itemCategory);
        billDetails.setEndBillAmntAfterDiscount(endBillAmntAfterDiscount);

        return billDetails;
    }

    /**
     * This method returns the calculated discounted amount based on
     * the userstatus and the percentage value passed.
     * @param discountMap
     * @param amountAfterDefaultDiscount
     * @param userStatus
     * @return
     */
    public  double getActualAmount(Map<String, Integer> discountMap, double amountAfterDefaultDiscount, String discountPercentageApplicable) {
        double actualAmount = 0;
        if(BillGenerationConstant.IS_DISCOUNT_APPLICABLE) {
            int discountedPercentage = discountMap.get(discountPercentageApplicable);
            double discAmount = discountedPercentage * amountAfterDefaultDiscount / 100;
            actualAmount = amountAfterDefaultDiscount - discAmount;
        } else {
            actualAmount = amountAfterDefaultDiscount;
            BillGenerationConstant.IS_DISCOUNT_APPLICABLE = true;
        }
        return actualAmount;
    }
}
