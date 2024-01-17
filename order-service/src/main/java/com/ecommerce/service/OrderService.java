package com.ecommerce.service;

import com.ecommerce.payload.OrderRequest;

public interface OrderService {
    public void placeOrder(OrderRequest orderRequest);
}
