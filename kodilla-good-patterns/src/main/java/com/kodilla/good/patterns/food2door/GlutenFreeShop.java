package com.kodilla.good.patterns.food2door;

public class GlutenFreeShop implements Shop{
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered=false;
        if (orderRequest.getSupplier().equals("GlutenFreeShop") && orderRequest.getProduct().getProductName().matches("GlutenFree.*")) {
            isOrdered=true;
        }
        return new OrderDto(orderRequest.getSupplier(),orderRequest.getProduct(), orderRequest.getQty(), isOrdered);
    }
}
