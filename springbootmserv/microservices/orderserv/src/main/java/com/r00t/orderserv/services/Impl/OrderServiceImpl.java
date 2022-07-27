package com.r00t.orderserv.services.Impl;


import com.r00t.orderserv.models.DTO.OrdersDTO;
import com.r00t.orderserv.models.DTO.requestbody.CreateOrderRequest;

public interface OrderServiceImpl {

    OrdersDTO createOrder(CreateOrderRequest cRequest) throws Exception;

    OrdersDTO updateOrder(OrdersDTO order) throws Exception;

    
}
