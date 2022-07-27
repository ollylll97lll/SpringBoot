package com.r00t.orderserv.models.DTO.responsebody;

import java.io.Serializable;
import java.math.BigInteger;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ItemDTO implements Serializable{
    private BigInteger quantity;
    private String itemID;

    public ItemDTO(BigInteger quantity, String itemID) {
        this.quantity = quantity;
        this.itemID = itemID;
    }
}
