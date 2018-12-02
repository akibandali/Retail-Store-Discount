package com.retail.store.calculator;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.retail.store.common.Bill;
import com.retail.store.common.NetPayable;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class RetailStoreRunner {
    public static void main(String[] args) {

        Bill bill = getBillDetails();
        DiscountCalculator calculator = new DiscountCalculator();
        NetPayable netPayable=calculator.getNetPayable(bill);
        System.out.println("Total Bill = " + netPayable.getBill().getBillAmount().getTotalAmount().getValue());
        System.out.println("Total Disount = " + netPayable.getTotalDiscount().getValue());
        System.out.println("Total NetPayable = " + netPayable.getNetPayable().getValue());

    }


    private static Bill getBillDetails() {
       Bill bill = new Bill();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();

        try {
            bill= gson.fromJson(new FileReader("./Bill.json"), Bill.class);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return bill;
    }

}
