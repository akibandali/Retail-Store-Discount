package com.retail.store.calculator;

import com.retail.store.common.Bill;
import com.retail.store.common.NetPayable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import static com.retail.store.calculator.data.TestBillUtils.getTestBillDetails;
import static org.junit.Assert.assertEquals;


@RunWith(MockitoJUnitRunner.class)
public class DiscountCalculatorTest {
    private Bill testBill;
    private  DiscountCalculator discountCalculator;

    @Before
    public void init() {
        testBill = getTestBillDetails();
        discountCalculator= new DiscountCalculator();

    }

    @Test
    public void testisStoreEmployee() {
        testBill = getTestBillDetails();
        NetPayable netPayable = discountCalculator.getNetPayable(testBill);
        assertEquals(netPayable.getNetPayable().getValue(),650,0.0);
    }

    @Test
    public void testisAffiliate() {
        testBill = getTestBillDetails();
        testBill.getUser().setAffiliate(true);
        testBill.getUser().setStoreEmployee(false);
        NetPayable netPayable = discountCalculator.getNetPayable(testBill);
        assertEquals(netPayable.getNetPayable().getValue(),850,0.0);
    }
    @Test
    public void testisMoreThenTwoYears() {
        testBill = getTestBillDetails();
        testBill.getUser().setAffiliate(false);
        testBill.getUser().setStoreEmployee(false);
        NetPayable netPayable = discountCalculator.getNetPayable(testBill);
        assertEquals(netPayable.getNetPayable().getValue(),900,0.0);
    }

    @Test
    public void testisStoreEmployeeWithGoceries() {
        testBill = getTestBillDetails();
        testBill.getBillAmount().getGroceriesAmount().setValue(200);
        NetPayable netPayable = discountCalculator.getNetPayable(testBill);
        assertEquals(netPayable.getNetPayable().getValue(),710.0,0.0);
    }
    @Test
    public void testisStoreEmployeeWithZeroBillAmount() {
        testBill = getTestBillDetails();
        testBill.getBillAmount().getTotalAmount().setValue(0);
        NetPayable netPayable = discountCalculator.getNetPayable(testBill);
        assertEquals(netPayable.getNetPayable().getValue(),0,0.0);
    }


}
