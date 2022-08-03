package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class OrderDetails {
    @Id
    @GeneratedValue
    @Column(name = "detailsID", columnDefinition = "BIGSERIAL NOT NULL", updatable = false)
    private BigInteger id;

    @ManyToOne(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
    @JoinColumn(name = "orderID", updatable = false)
    private Orders orders;

    @Column
    private String itemID;

    @Column
    private Integer quantity;

    @Column
    private String status;

    @CreatedDate
    @Column(updatable = false)
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date createdAt;

    @Column
    @UpdateTimestamp
    @ColumnDefault(value = "CURRENT_TIMESTAMP")
    private Date updatedAt;

    @Column(columnDefinition = "boolean default false")
    private boolean isDeleted;
}
