package com.retail.store.common;

public class NetPayable {
    private Bill bill;
    private Money netPayable;
    private Money totalDiscount;
    public Bill getBill() {
        return bill;
    }

    public void setBill(Bill bill) {
        this.bill = bill;
    }

    public Money getNetPayable() {
        return netPayable;
    }

    public void setNetPayable(Money netPayable) {
        this.netPayable = netPayable;
    }

    public Money getTotalDiscount() {
        return totalDiscount;
    }

    public void setTotalDiscount(Money totalDiscount) {
        this.totalDiscount = totalDiscount;
    }

    @Override
    public String toString() {
        return "NetPayable{" +
                "bill=" + bill +
                ", netPayable=" + netPayable +
                ", totalDiscount=" + totalDiscount +
                '}';
    }
}
