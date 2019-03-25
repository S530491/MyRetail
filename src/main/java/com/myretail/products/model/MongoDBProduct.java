package com.myretail.products.model;

import org.springframework.data.mongodb.core.mapping.Document;

//collection name that will be stored in database
@Document("products")
public class MongoDBProduct {
    //added required fields along with getters and setters
    private String id;
    private CurrentPrice currentPrice;

    public MongoDBProduct() {
    }

    public MongoDBProduct(String id, CurrentPrice currentPrice) {
        this.id = id;
        this.currentPrice = currentPrice;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public CurrentPrice getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(CurrentPrice currentPrice) {
        this.currentPrice = currentPrice;
    }

    @Override
    public String toString() {
        return "MongoDBProduct{" +
                "id='" + id + '\'' +
                ", currentPrice=" + currentPrice +
                '}';
    }
}
