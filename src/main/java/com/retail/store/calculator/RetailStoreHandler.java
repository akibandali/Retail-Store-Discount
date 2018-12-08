package com.retail.store.calculator;

import com.retail.store.common.Bill;
import com.retail.store.common.NetPayable;
import com.retail.store.dao.BillDetailsDao;

public class RetailStoreHandler {
    private BillDetailsDao billDetailsDao = new BillDetailsDao();

    public NetPayable calculateDiscount() {

        DiscountCalculator calculator = new DiscountCalculator();
        Bill bill = billDetailsDao.getBillDetails();
        return calculator.getNetPayable(bill);
    }


}