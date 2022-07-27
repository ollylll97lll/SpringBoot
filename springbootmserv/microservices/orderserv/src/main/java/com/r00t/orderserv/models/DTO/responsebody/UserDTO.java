package com.r00t.orderserv.models.DTO.responsebody;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private BigInteger id;
    private String firstName, lastName, email, phone;
    private Date createdDate, updateDate;
    private boolean isDeleted, isValidated;
}
