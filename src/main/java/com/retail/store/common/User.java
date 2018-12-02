package com.retail.store.common;

import java.time.LocalDateTime;

public class User {

    private long id;
    private String name;
    private boolean isStoreEmployee;
    private boolean isAffiliate;
    private LocalDateTime period;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getStoreEmployee() {
        return isStoreEmployee;
    }

    public void setStoreEmployee(Boolean storeEmployee) {
        isStoreEmployee = storeEmployee;
    }

    public Boolean getAffiliate() {
        return isAffiliate;
    }

    public void setAffiliate(Boolean affiliate) {
        isAffiliate = affiliate;
    }

    public LocalDateTime getPeriod() {
        return period;
    }

    public void setPeriod(LocalDateTime period) {
        this.period = period;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isStoreEmployee=" + isStoreEmployee +
                ", isAffiliate=" + isAffiliate +
                ", period=" + period +
                '}';
    }
}
