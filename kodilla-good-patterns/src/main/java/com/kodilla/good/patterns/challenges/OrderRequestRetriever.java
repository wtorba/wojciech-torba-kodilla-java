package com.kodilla.good.patterns.challenges;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        User user = new User("Jan", "Kowalski");
        Product product = new Product("Produkt", "EAN");
        int qty = 1;
        return new OrderRequest(user, product, qty);
    }
}
