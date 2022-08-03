package com.example.DemoSpringBoot.entities;

import java.math.BigInteger;
import java.sql.Date;
import java.util.List;

import javax.annotation.Nullable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Orders {
    @Id
    @GeneratedValue
    @Column(name = "orderID", updatable = false, columnDefinition = "BIGSERIAL NOT NULL")
    private BigInteger ID;

    @Column
    private String userID;

    @OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL }, mappedBy = "orders")
    private List<OrderDetails> detailsList;

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

    @Column
    @Nullable
    private String comment;
}
