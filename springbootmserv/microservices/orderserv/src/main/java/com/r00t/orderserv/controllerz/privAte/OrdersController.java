package com.r00t.orderserv.controllerz.privAte;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.orderserv.models.DTO.OrdersDTO;
import com.r00t.orderserv.models.DTO.requestbody.CreateOrderRequest;
import com.r00t.orderserv.services.serviceClasses.OrderService;

@RestController
@Transactional
@RequestMapping("api/v1/protected/orders")
public class OrdersController {

    @Autowired
    private OrderService oService;

    @PostMapping("")
    public ResponseEntity createOrder(@RequestBody CreateOrderRequest cRequest) throws Exception {
        return new ResponseEntity<OrdersDTO>(oService.createOrder(cRequest), HttpStatus.OK);
    }

}
