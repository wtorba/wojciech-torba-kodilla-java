package com.kodilla.good.patterns.food2door;

public class Product {
    private String productName;
    private String producer;

    public Product(String productName, String producer) {
        this.productName = productName;
        this.producer = producer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;

        Product product = (Product) o;

        if (!productName.equals(product.productName)) return false;
        return producer.equals(product.producer);
    }

    @Override
    public int hashCode() {
        int result = productName.hashCode();
        result = 31 * result + producer.hashCode();
        return result;
    }

    public String getProductName() {
        return productName;
    }

    public String getProducer() {
        return producer;
    }
}

