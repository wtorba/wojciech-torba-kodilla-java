package com.kodilla.good.patterns.food2door;


public class OrderRequestRetriever {

    public OrderRequest retrieve() {
        String supplier="GlutenFreeShop";
        Product product = new Product("GlutenFreePotatoes", "EAN");
        int orderQty = 100;
        return new OrderRequest(supplier, product, orderQty);
    }
}
