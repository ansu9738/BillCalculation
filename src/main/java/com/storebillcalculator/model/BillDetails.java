package com.storebillcalculator.model;

import org.springframework.stereotype.Component;

@Component
public class BillDetails {

    private double endBillAmntAfterDiscount;
    private double actualMrpPrice;
    private String discountPercentCtgApplicable;
    private String itemCategory;

    public double getEndBillAmntAfterDiscount() {
        return endBillAmntAfterDiscount;
    }

    public void setEndBillAmntAfterDiscount(double endBillAmntAfterDiscount) {
        this.endBillAmntAfterDiscount = endBillAmntAfterDiscount;
    }

    public double getActualMrpPrice() {
        return actualMrpPrice;
    }

    public void setActualMrpPrice(double actualMrpPrice) {
        this.actualMrpPrice = actualMrpPrice;
    }



    public String getItemCategory() {
        return itemCategory;
    }

    public void setItemCategory(String itemCategory) {
        this.itemCategory = itemCategory;
    }

    public String getDiscountPercentCtgApplicable() {
        return discountPercentCtgApplicable;
    }

    public void setDiscountPercentCtgApplicable(String discountPercentCtgApplicable) {
        this.discountPercentCtgApplicable = discountPercentCtgApplicable;
    }
}
