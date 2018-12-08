package com.retail.store.run;

import com.retail.store.calculator.RetailStoreHandler;
import com.retail.store.common.NetPayable;

public class StoreRunner {

    public static void main(String[] args) {
        RetailStoreHandler handler = new RetailStoreHandler();
        NetPayable netPayable = handler.calculateDiscount();
        printNetPayableBillOnConsole(netPayable);
    }

    private static void printNetPayableBillOnConsole(NetPayable netPayable) {
        System.out.println("Total Bill = " + netPayable.getBill().getBillAmount().getTotalAmount().getValue());
        System.out.println("Total Discount = " + netPayable.getTotalDiscount().getValue());
        System.out.println("Total NetPayable = " + netPayable.getNetPayable().getValue());
    }
}
