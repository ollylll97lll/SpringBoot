package com.r00t.orderserv.services.Impl;

import java.util.UUID;

import com.r00t.orderserv.models.DTO.OrderDetailsDTO;
import com.r00t.orderserv.models.DTO.responsebody.ItemDTO;

public interface DetailServiceImpl {
    OrderDetailsDTO createDetail(UUID orderID, ItemDTO itemDTO, int quantity) throws Exception;

    OrderDetailsDTO updateDetails(UUID detailID, String status) throws Exception;
}
