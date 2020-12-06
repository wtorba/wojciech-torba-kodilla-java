package com.kodilla.good.patterns.challenges;

public class OrderRequest {
    private User user;
    private Product product;
    private int qty;

    public OrderRequest(User user, Product product, int qty) {
        this.user = user;
        this.product = product;
        this.qty = qty;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return qty;
    }
}
