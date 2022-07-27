package com.r00t.usermserv.entities;

import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern.Flag;
import javax.validation.constraints.Size;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.r00t.usermserv.validations.PhoneNumberConstraint;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "BIGSERIAL NOT NULL", name = "userID")
    private BigInteger id;

    @Column
    @NotEmpty
    @Size(max = 8, message = "The length of first name must be between 1 and 8 characters.")
    private String firstName;

    @Column
    @NotEmpty
    @Size(max = 64, message = "The length of last name must be between 1 and 64 characters.")
    private String lastName;

    @Column
    @NotEmpty
    @Email(message = "The email address is invalid.", flags = { Flag.CASE_INSENSITIVE })
    @Size(max = 64, message = "The length of email not exceed 64 characters")
    private String email;

    @Column
    @PhoneNumberConstraint
    private String phone;

    @Column
    @NotEmpty
    private String password;

    @Column(updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @CreationTimestamp
    private Date createdDate;

    @Column
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    @UpdateTimestamp
    private Date updateDate;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;

    @Column(columnDefinition = "boolean default false")
    private boolean isValidated;

}
