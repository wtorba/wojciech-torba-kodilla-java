package com.kodilla.good.patterns.food2door;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ExtraFoodShop implements Shop {
    private static final Set <Product> products = new HashSet<>();
    private static final String SHOPNAME ="ExtraFoodShop";

    public static boolean checkProduct(Product product) {
        products.add(new Product("Prod1", "ExtraFoodShop"));
        products.add(new Product("Prod2", "ExtraFoodShop"));
        products.add(new Product("Prod3", "ExtraFoodShop"));
        return products.contains(product);
    }

    public OrderDto process(OrderRequest orderRequest) {
        return new OrderDto(SHOPNAME, orderRequest.getProductsQty()
                .entrySet()
                .stream()
                .filter(x -> checkProduct(x.getKey()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
}
