package com.retail.store.calculator;

import com.retail.store.common.Bill;
import com.retail.store.common.NetPayable;
import com.retail.store.dao.BillDetailsDao;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static com.retail.store.calculator.data.TestBillUtils.getTestBillDetails;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class RetailStoreRunnerTest {

    private Bill testBill;

    @Mock
    private BillDetailsDao billDetailsDao;

    @InjectMocks
    private RetailStoreHandler retailStoreRunner;

    @Before
    public void init() {
        testBill = getTestBillDetails();
    }

    @Test
    public void testRetailStoreRunner() {
        testBill = getTestBillDetails();
        doReturn(testBill).when(billDetailsDao).getBillDetails();
        NetPayable netPayable1Response = retailStoreRunner.calculateDiscount();
        assertEquals(netPayable1Response.getBill(), testBill);
    }

}