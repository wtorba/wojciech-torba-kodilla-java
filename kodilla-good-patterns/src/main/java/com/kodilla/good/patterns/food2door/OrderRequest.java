package com.kodilla.good.patterns.food2door;

import java.util.HashMap;

public class OrderRequest {
    private final HashMap<Product, Integer> productsQty;

    public OrderRequest(HashMap productsQty) {
        this.productsQty = productsQty;
    }

    public HashMap<Product, Integer> getProductsQty() {
        return productsQty;
    }
}
