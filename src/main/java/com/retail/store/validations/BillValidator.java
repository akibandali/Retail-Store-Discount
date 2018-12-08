package com.retail.store.validations;

import com.retail.store.common.Bill;
import com.retail.store.common.BillAmount;
import com.retail.store.common.User;
import com.retail.store.exceptions.InValidBillException;
import com.retail.store.exceptions.InValidUserException;

public class BillValidator {

    public static void validateBill(Bill bill) {
        validateAmount(bill.getBillAmount());
        validateUser(bill.getUser());
        validateCorrectAmount(bill);
    }


    private static void validateUser(User user) {
        if (user == null || user.getPeriod() == null) {
            throw new InValidUserException("Not Valid User");
        }

    }

    private static void validateAmount(BillAmount billAmount) {
        if (billAmount == null || billAmount.getTotalAmount() == null || billAmount.getTotalAmount().getUnit() == null) {
            throw new InValidBillException("Not Valid Total Bill Amount");
        }
        if (billAmount == null || billAmount.getGroceriesAmount() == null || billAmount.getGroceriesAmount().getUnit() == null) {
            throw new InValidBillException("Not Valid Grocery Bill Amount");
        }

    }
    private static void validateCorrectAmount(Bill bill) {

    if(bill.getBillAmount().getGroceriesAmount().getValue()>bill.getBillAmount().getTotalAmount().getValue())
        throw new InValidBillException("Grocery Amount can not be greater than Total Amount");

    }


}
