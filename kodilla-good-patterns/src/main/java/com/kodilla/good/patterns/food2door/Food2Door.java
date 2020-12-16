package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;

public class Food2Door {
    private Map<String, Shop> shops = new HashMap<>();

    public void addShop(String shopName, Shop shop) {
        shops.put(shopName, shop);
    }

    public Shop getShop(String supplier) {
        return shops.get(supplier);
    }

    public OrderDto createOrder(OrderRequest orderRequest) throws NoShopException {
        try {
            return this.getShop(orderRequest.getSupplier()).process(orderRequest);
        } catch (NullPointerException e) {
            throw new NoShopException();
            //return null;
        }
    }

}
