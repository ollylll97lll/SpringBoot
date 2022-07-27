package com.r00t.orderserv.models.DTO;

import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderDetailsDTO {
    private UUID ID;
    private String itemID, status;
    private Integer quantity;
    private Date createdAt, updatedAt;

}
