package com.kodilla.good.patterns.food2door;

import java.util.Map;
import java.util.stream.Collectors;

public class GlutenFreeShop implements Shop {
    public OrderDto process(OrderRequest orderRequest) {
        return new OrderDto("GLutenFreeShop", orderRequest.getProductsQty().entrySet().stream()
                .filter(e -> "GlutenFreeShop".equals(e.getKey().getProducer()))
                .filter(e -> e.getKey().getProductName().matches("GlutenFree.*"))
                .filter(e -> e.getValue() > 0)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));

    }
}
