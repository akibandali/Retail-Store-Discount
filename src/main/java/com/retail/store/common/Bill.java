package com.retail.store.common;

public class Bill {
    private long billNumber;
    private User user;
    private BillAmount billAmount;

    public long getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(long billNumber) {
        this.billNumber = billNumber;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BillAmount getBillAmount() {
        return billAmount;
    }

    public void setBillAmount(BillAmount billAmount) {
        this.billAmount = billAmount;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "billNumber=" + billNumber +
                ", user=" + user +
                ", billAmount=" + billAmount +
                '}';
    }
}
