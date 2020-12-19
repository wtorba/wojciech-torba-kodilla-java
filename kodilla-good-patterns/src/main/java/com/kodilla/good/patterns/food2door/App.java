package com.kodilla.good.patterns.food2door;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.HashSet;
import java.util.stream.Collectors;

public class App {
    private static final Logger LOGGER = LoggerFactory.getLogger(App.class);

    public static void main(String[] args) {

        Food2Door food2door = new Food2Door();
        food2door.addShop("ExtraFoodShop",new ExtraFoodShop());
        food2door.addShop("HealthyShop", new HealthyShop());
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        try {
            HashSet<OrderDto> orderDtoSet= (HashSet<OrderDto>) food2door.createOrder(orderRequest);
            LOGGER.info("Order information: {}",orderDtoSet.stream().map(OrderDto::toString).collect(Collectors.joining("\n")));
        } catch (NoShopException e) {
            LOGGER.warn("There is no such shop registered: {}",e);
        }
        food2door.addShop("GlutenFreeShop",new GlutenFreeShop());
        try {
            HashSet<OrderDto> orderDtoSet= (HashSet<OrderDto>) food2door.createOrder(orderRequest);
            LOGGER.info("Order information: \n{}",orderDtoSet.stream().map(OrderDto::toString).collect(Collectors.joining("\n")));

        } catch (NoShopException e) {
            LOGGER.warn("There is no such shop registered: {}","X");
        }
    }

}
