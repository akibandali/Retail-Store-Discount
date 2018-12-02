package com.retail.store.common;

public class BillAmount {
    private Money totalAmount;
    private Money groceriesAmount;

    public Money getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Money totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Money getGroceriesAmount() {
        return groceriesAmount;
    }

    public void setGroceriesAmount(Money groceriesAmount) {
        this.groceriesAmount = groceriesAmount;
    }

    @Override
    public String toString() {
        return "BillAmount{" +
                "totalAmount=" + totalAmount +
                ", groceriesAmount=" + groceriesAmount +
                '}';
    }
}
