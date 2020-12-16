package com.kodilla.good.patterns.food2door;
public class App {

    public static void main(String args[]) throws NoShopException {

        Food2Door food2door = new Food2Door();
        food2door.addShop("ExtraFoodShop",new ExtraFoodShop());
        food2door.addShop("HealthyShop", new HealthyShop());

        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();
        try {
            System.out.println(food2door.createOrder(orderRequest));
        } catch (NoShopException e) {
            System.out.println("There is no such shop registered: "+orderRequest.getSupplier());
        }
        food2door.addShop("GlutenFreeShop",new GlutenFreeShop());
        try {
            System.out.println(food2door.createOrder(orderRequest));
        } catch (NoShopException e) {
            System.out.println("There is no such shop registered: "+orderRequest.getSupplier());
        }
    }

}
