package com.myretail.products.model;

public class CurrentPrice {
    //added required fields along with getters and setters
    private String value;
    private String currency_code;

    public CurrentPrice() {
    }

    public CurrentPrice(String value, String currency_code) {
        this.value = value;
        this.currency_code = currency_code;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setCurrency_code(String currency_code) {
        this.currency_code = currency_code;
    }

    public String getValue() {
        return value;
    }

    public String getCurrency_code() {
        return currency_code;
    }

    @Override
    public String toString() {
        return "CurrentPrice{" +
                "value='" + value + '\'' +
                ", currency_code='" + currency_code + '\'' +
                '}';
    }
}
