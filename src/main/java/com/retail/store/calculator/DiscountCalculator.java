package com.retail.store.calculator;

import com.retail.store.constant.Constants;
import com.retail.store.common.Bill;
import com.retail.store.common.BillAmount;
import com.retail.store.common.Money;
import com.retail.store.common.NetPayable;
import com.retail.store.validations.BillValidator;
import java.time.LocalDateTime;

public class DiscountCalculator {

    public NetPayable getNetPayable(Bill bill) {
        BillValidator.validateBill(bill);
        return getTotalDiscount(bill);
    }

    private NetPayable getTotalDiscount(Bill bill) {
        float percentageDiscount = 0;
        if (bill.getUser().isStoreEmployee()) {
            percentageDiscount = applyPercentageDiscount(bill.getBillAmount(), Constants.EMPLOYEE_DISCOUNT);

        } else if (bill.getUser().isAffiliate()) {
            percentageDiscount = applyPercentageDiscount(bill.getBillAmount(), Constants.AFFILIATE_DISCOUNT);

        } else if (isTwoYearsCustomer(bill.getUser().getPeriod())) {
            percentageDiscount = applyPercentageDiscount(bill.getBillAmount(), Constants.TWO_YEARS_DISCOUNT);
        }
        float perHundredDiscount = applyPerHundredDiscount(bill.getBillAmount().getTotalAmount(), Constants.PER_HUNDRED_DISCOUNT);

        float totalDiscount = percentageDiscount + perHundredDiscount;

        return prepareNetPayable(bill, totalDiscount);

    }

    private NetPayable prepareNetPayable(Bill bill, float totalDiscount) {
        String unit = bill.getBillAmount().getTotalAmount().getUnit();
        Money netPayableAmount = new Money();
        netPayableAmount.setUnit(unit);
        netPayableAmount.setValue(bill.getBillAmount().getTotalAmount().getValue() - totalDiscount);
        Money totalDiscountAmount = new Money();
        totalDiscountAmount.setUnit(unit);
        totalDiscountAmount.setValue(totalDiscount);
        NetPayable netPayable = new NetPayable();
        netPayable.setNetPayable(netPayableAmount);
        netPayable.setTotalDiscount(totalDiscountAmount);
        netPayable.setBill(bill);
        return netPayable;
    }

    private float applyPerHundredDiscount(Money totalAmount, int perHundredDiscount) {
        int hundreds=(int)totalAmount.getValue() / 100;
       return  hundreds* perHundredDiscount;

    }


    private static float applyPercentageDiscount(BillAmount billAmount, float discountPercentage) {
        float percentageDiscount = 0;
        if (billAmount != null && billAmount.getTotalAmount() != null) {
            float totalAmount = billAmount.getTotalAmount().getValue();
            float groceriesAmount = billAmount.getGroceriesAmount().getValue();
            float applicableAmount = totalAmount - groceriesAmount;
            percentageDiscount = applicableAmount * discountPercentage / 100;
        }
        return percentageDiscount;
    }

    private static boolean isTwoYearsCustomer(LocalDateTime period) {
        LocalDateTime currentDate = LocalDateTime.now();
        return period.plusYears(Constants.NUMBER_YEARS_FOR_DISCOUNT).isBefore(currentDate);

    }
}
