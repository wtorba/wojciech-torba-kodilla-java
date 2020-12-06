package com.kodilla.good.patterns.challenges;

public class ProductOrderService {
    private InformationService informationService;
    private OrderingService orderingService;
    private StoreInventory storeInventory;

    public ProductOrderService(final InformationService informationService,
                               final OrderingService orderingService,
                               final StoreInventory storeInventory) {
        this.informationService=informationService;
        this.orderingService=orderingService;
        this.storeInventory=storeInventory;
    }

    public OrderDto process(final OrderRequest orderRequest) {
        boolean isOrdered = orderingService.order(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQty());

        if (isOrdered) {
            informationService.inform(orderRequest.getUser());
            storeInventory.createOrder(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQty());
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQty(), true);
        } else {
            return new OrderDto(orderRequest.getUser(), orderRequest.getProduct(), orderRequest.getQty(), false);
        }
    }


}
