package com.r00t.usermserv.models.responsebody;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreateOrderRequest {
    String ItemID;
    int quantity;
}