package com.retail.store.common;

public class Money {
    private float value;
    private String unit;


    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Money{" +
                "value=" + value +
                ", unit='" + unit + '\'' +
                '}';
    }

}
