package com.kodilla.good.patterns.food2door;

import com.kodilla.good.patterns.food2door.Product;

public class GlutenFreeShop implements Shop{
    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered=false;
        if (orderRequest.getSupplier().equals("GlutenFree") && orderRequest.getProduct().getProductName().matches("GlutenFree.*")) {
            isOrdered=true;
        }
        return new OrderDto(orderRequest.getSupplier(),orderRequest.getProduct(), orderRequest.getQty(), isOrdered);
    }
}
