package com.kodilla.good.patterns.food2door;

public class HealthyShop implements Shop {
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered=false;
        if (orderRequest.getQty()>10 && orderRequest.getProduct().getProductName().toUpperCase().contains("HLTH")) {
            isOrdered=true;
        }
        return new OrderDto(orderRequest.getSupplier(),orderRequest.getProduct(),orderRequest.getQty(),isOrdered);
    }
}
