package com.kodilla.good.patterns.challenges;

public class WebOrderService implements OrderingService{
    @Override
    public boolean order(User user, Product product, int qty) {
        System.out.println("WebOrderService allowed to order");
        return true;
    }
}
