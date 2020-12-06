package com.kodilla.good.patterns.challenges;

public class OrderDto {
    private User user;
    private Product product;
    private int qty;
    private boolean isOrdered;

    public OrderDto(User user, Product product, int qty, boolean isOrdered) {
        this.user = user;
        this.product = product;
        this.qty = qty;
        this.isOrdered = isOrdered;
    }

    public User getUser() {
        return user;
    }

    public Product getProduct() {
        return product;
    }

    public boolean isOrdered() {
        return isOrdered;
    }
}
