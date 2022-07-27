package com.r00t.orderserv.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.r00t.orderserv.entities.Orders;

@Repository
public interface OrdersRepository extends JpaRepository<Orders, UUID> {

}
