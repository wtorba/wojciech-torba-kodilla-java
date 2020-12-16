package com.kodilla.good.patterns.food2door;

public class Product {
    private String productName;

    public Product(String productName, String productEan) {
        this.productName = productName;
    }

    public String getProductName() {
        return productName;
    }
}
