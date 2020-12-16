package com.kodilla.good.patterns.food2door;

public class OrderDto {
    private String supplier;
    private Product product;
    private int orderQty;
    private boolean isOrdered;

    public OrderDto(String supplier, Product product, int orderQty, boolean isOrdered) {
        this.supplier = supplier;
        this.product = product;
        this.orderQty = orderQty;
        this.isOrdered = isOrdered;
    }

    public String getSupplier() {
        return supplier;
    }

    public Product getProduct() {
        return product;
    }

    public int getQty() {
        return orderQty;
    }

    public boolean isOrdered() {
        return isOrdered;
    }

    @Override
    public String toString() {
        return "{ \"order\":\n\t{ \"supplier: \"" +supplier+"\", \"product\": \""+ product.getProductName() + "\", \"qty\": \""+orderQty+"\", \"confirmed\": \"" + isOrdered + "\" }\n}";
    }
}

