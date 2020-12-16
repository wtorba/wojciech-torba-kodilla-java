package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.Product;

public class OrderRequest {
    private String supplier;
    private Product product;
    private int orderQty;

    public OrderRequest(String supplier, Product product, int orderQty) {
        this.supplier = supplier;
        this.product = product;
        this.orderQty = orderQty;
    }

    public String getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return orderQty;
    }
}
