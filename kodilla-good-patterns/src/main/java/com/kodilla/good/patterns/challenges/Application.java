package com.kodilla.good.patterns.challenges;

public class Application {
    public static void main(String args[]) {
        OrderRequestRetriever orderRequestRetriever = new OrderRequestRetriever();
        OrderRequest orderRequest = orderRequestRetriever.retrieve();

        ProductOrderService productOrderService = new ProductOrderService(
                new MailingService(), new WebOrderService(), new AllegroInventory());
        productOrderService.process(orderRequest);
    }
}
