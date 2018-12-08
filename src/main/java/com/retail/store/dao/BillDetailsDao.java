package com.retail.store.dao;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.retail.store.constant.Constants;
import com.retail.store.common.Bill;
import com.retail.store.exceptions.InValidBillException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;


public class BillDetailsDao {

    private static final Logger log = LoggerFactory.getLogger(BillDetailsDao.class);

    public Bill getBillDetails() {
        Bill bill = new Bill();
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDateTime.class, (JsonDeserializer<LocalDateTime>) (json, type, jsonDeserializationContext) ->
                ZonedDateTime.parse(json.getAsJsonPrimitive().getAsString()).toLocalDateTime()).create();
        try {
            bill = gson.fromJson(new FileReader(Constants.BILL_FILE_NAME), Bill.class);
        } catch (FileNotFoundException e) {
            log.error(e.getMessage());
            throw new InValidBillException("Bill file not found on current directory with the name Bill.json");


        }
        return bill;
    }

}
