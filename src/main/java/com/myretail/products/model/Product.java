package com.myretail.products.model;

public class Product {
    //added required fields along with getters and setters
    private String id;
    private  String name;
    private CurrentPrice current_price;

    public Product() {
    }

    public Product(String id, String name, CurrentPrice current_price) {
        this.id = id;
        this.name = name;
        this.current_price = current_price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CurrentPrice getCurrent_price() {
        return current_price;
    }

    public void setCurrent_price(CurrentPrice current_price) {
        this.current_price = current_price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", current_price=" + current_price +
                '}';
    }
}
