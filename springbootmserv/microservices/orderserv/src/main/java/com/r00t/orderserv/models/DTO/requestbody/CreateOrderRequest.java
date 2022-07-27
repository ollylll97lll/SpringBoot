package com.r00t.orderserv.models.DTO.requestbody;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderRequest{
    String ItemID;
    int quantity;
    int userID;
    String comment;
}