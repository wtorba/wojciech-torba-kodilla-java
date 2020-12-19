package com.kodilla.good.patterns.food2door;

import java.util.Map;
import java.util.stream.Collectors;

public class OrderDto {
    private final String supplier;
    private final Map<Product, Integer> products;

    public OrderDto(String supplier, Map products) {
        this.supplier = supplier;
        this.products = products;
    }

    public String getSupplier() {
        return supplier;
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("{ \"supplier: \""+supplier+"\",\n\t\"ordered\": {");
        return sb.append(products.entrySet()
                                 .stream()
                                 .map(e -> new StringBuffer("\n\t\t\"product\": \"").append(e.getKey().getProductName())
                                                               .append("\", \"qty\": \"")
                                                               .append(e.getValue())
                                                               .append("\""))
                .collect(Collectors.joining("")))
                .append("\n\t}\n}")
                .toString();

//                .collect(Collector.of(StringBuilder::new, (ssB, e) -> ssB.append("\n\t\t\"product\": \"")
//                                .append(entry.getKey().getProductName())
//                                .append("\", \"qty\": \"")
//                                .append(entry.getValue())
//                                .append("\""))
//                                .collect(sb)
//                                .append(" \n\t}\n}")
//                                .toString();
    }
}

