package com.retail.store.calculator.data;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.retail.store.calculator.DiscountCalculatorTest;
import com.retail.store.common.Bill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;

public class TestBillUtils {
    private static final Logger log = LoggerFactory.getLogger(DiscountCalculatorTest.class);

    public static Bill getTestBillDetails() {
        Bill bill = new Bill();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        try {
            bill = gson.fromJson(new FileReader("src/test/resources/Bill.json"), Bill.class);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
        }
        return bill;
    }

}
