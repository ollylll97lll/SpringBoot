package com.r00t.orderserv.models.DTO;

import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.r00t.orderserv.entities.OrderDetails;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrdersDTO {
    private UUID ID;
    private String comment;
    private BigInteger userID;
    private List<OrderDetails> detailsList;
    private String status;
    private Date createdAt, updatedAt;
}
