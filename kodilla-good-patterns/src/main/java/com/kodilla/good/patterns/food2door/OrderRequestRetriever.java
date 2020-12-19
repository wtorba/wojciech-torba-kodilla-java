package com.kodilla.good.patterns.food2door;


import java.util.HashMap;
import java.util.Map;

public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        Map<Product, Integer> productsQty = new HashMap<>();
        productsQty.put(new Product("GlutenFreePotatoes", "GlutenFreeShop"), 5);
        productsQty.put(new Product("GlutenFreeFlour", "GlutenFreeShop"), 7);
        productsQty.put(new Product("HLTH sugar", "HealthyShop"), 9);
        productsQty.put(new Product("Prod1", "ExtraFoodShop"), 17);
        productsQty.put(new Product("HLTH salt", "HealthyShop"), 11);
        productsQty.put(new Product("HLTH pepper", "HealthyShop"), 13);
        productsQty.put(new Product("HLTH camomile", "HealthyShop"), 15);
        return new OrderRequest((HashMap) productsQty);
    }
}
