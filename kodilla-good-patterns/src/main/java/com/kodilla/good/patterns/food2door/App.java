package com.kodilla.good.patterns.food2door;
public class App {

    public static void main(String args[]) throws NoShopException {

        Food2Door food2door = new Food2Door();
        food2door.addShop("ExtraFoodShop",new ExtraFoodShop());
        food2door.addShop("HealthyShop", new HealthyShop());

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        System.out.println(food2door.createOrder(orderRequest));
        food2door.addShop("GlutenFreeShop",new GlutenFreeShop());
        System.out.println(food2door.createOrder(orderRequest));

    }

}
