package com.kodilla.good.patterns.food2door;

public interface Shop {
    OrderDto process(final OrderRequest orderRequest);  // lista produktow i ilosci, w shopach rozwinac process (z pliku, z listy, z powietrza)
}
