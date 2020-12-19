package com.kodilla.good.patterns.food2door;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class HealthyShop implements Shop {

    private static final String HEALTHYSHOPNAME = "HealthyShop";
    private final Set<String> HealthyShopProducts = new HashSet<>();

    public void readHLTHProducts() throws FileReaderException {
        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("HealthyShopProducts.txt").getFile());

        try (Stream<String> fileLines = Files.lines(Paths.get(file.getPath()))) {
            fileLines.forEach(l -> HealthyShopProducts.add(l));
        } catch (IOException e) {
            throw new FileReaderException();
        }
    }

    public OrderDto process(OrderRequest orderRequest) {
        boolean isOrdered=false;

        try {
             readHLTHProducts();
        } catch (FileReaderException e) {
            System.out.println("HLTH internal error: check products list file.");
        }

            return new OrderDto(HEALTHYSHOPNAME, orderRequest.getProductsQty().entrySet().stream()
                    .filter(e -> HealthyShopProducts.contains(e.getKey().getProductName()))
                    .filter(e -> HEALTHYSHOPNAME.equals(e.getKey().getProducer()))
                    .filter(e -> e.getValue() > 0)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue)));
    }
}
