package com.kodilla.good.patterns.challenges;

public class Product {
    private String productName;
    private String productEan;

    public Product(String productName, String productEan) {
        this.productName = productName;
        this.productEan = productEan;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductEan() {
        return productEan;
    }
}
