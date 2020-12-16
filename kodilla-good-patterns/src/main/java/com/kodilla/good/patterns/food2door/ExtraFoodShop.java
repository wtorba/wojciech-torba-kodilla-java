package com.kodilla.good.patterns.food2door;

import java.util.HashSet;
import java.util.Set;

public class ExtraFoodShop implements Shop {
    private static Set <Product> products = new HashSet<>();

    public static boolean checkProduct(Product product) {
        products.add(new Product("Prod1","EAN1"));
        products.add(new Product("Prod2", "EAN2"));
        products.add(new Product("Prod3", "EAN3"));
        return products.contains(product);
    }

    public OrderDto process(OrderRequest orderRequest) {
        return new OrderDto(orderRequest.getSupplier(), orderRequest.getProduct(), orderRequest.getQty(), ExtraFoodShop.checkProduct(orderRequest.getProduct()));
    }
}
