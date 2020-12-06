package com.kodilla.good.patterns.challenges;

public class AllegroInventory implements StoreInventory{
    @Override
    public void createOrder(User user, Product product, int qty) {
        System.out.println("Order has been created");
    }
}
