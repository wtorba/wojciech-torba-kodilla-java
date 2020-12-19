package com.kodilla.good.patterns.food2door;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Food2Door {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);
    private final Map<String, Shop> shops = new HashMap<>();

    public void addShop(String shopName, Shop shop) {
        shops.put(shopName, shop);
        LOGGER.info("Shop {} added.",shopName);
    }

    public Shop getShop(String supplier) {
        return shops.get(supplier);
    }

    public Set<OrderDto> createOrder(OrderRequest orderRequest) throws NoShopException {

            HashMap<String, HashMap<Product, Integer>> splittedOrders = new HashMap<>();

            for(Map.Entry<Product, Integer>productQty : orderRequest.getProductsQty().entrySet()) {
                if (!splittedOrders.containsKey(productQty.getKey().getProducer())) {
                    splittedOrders.put(productQty.getKey().getProducer(), new HashMap<>());
                }
                splittedOrders.get(productQty.getKey().getProducer()).put(productQty.getKey(), productQty.getValue());
            }
        try {
            return splittedOrders.entrySet()
                              .stream()
                              .map(e -> getShop(e.getKey()).process(new OrderRequest(e.getValue())))
                              .collect(Collectors.toSet());
        } catch (NullPointerException e) {
            throw new NoShopException();
        }
    }
}
