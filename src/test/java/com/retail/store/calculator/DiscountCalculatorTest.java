package com.retail.store.calculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.retail.store.common.Bill;
import com.retail.store.common.NetPayable;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

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
        System.out.println(netPayable);
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





    private static Bill getTestBillDetails() {
        Bill bill = new Bill();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        try {
            bill = gson.fromJson(new FileReader("src/test/resources/Bill.json"), Bill.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bill;
    }

}
