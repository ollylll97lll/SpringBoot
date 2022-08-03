package com.example.DemoSpringBoot.models.DTO;

import java.math.BigInteger;
import java.util.Date;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class UserDTO {
    private BigInteger id;
    private String firstName, lastName, email, phone;
    private Date createdDate, updateDate;
    private boolean isDeleted, isValidated;

}
