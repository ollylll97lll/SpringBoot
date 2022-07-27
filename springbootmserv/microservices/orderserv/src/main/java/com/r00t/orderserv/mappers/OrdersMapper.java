package com.r00t.orderserv.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.r00t.orderserv.entities.Orders;
import com.r00t.orderserv.models.DTO.OrdersDTO;

@Mapper(componentModel = "spring")
public interface OrdersMapper {
    OrdersMapper INSTANCE = Mappers.getMapper(OrdersMapper.class);

    OrdersDTO order2DTO(Orders order);

    List<OrdersDTO> orders2DTOs(List<Orders> orders);

    @InheritInverseConfiguration
    Orders DTO2Order(OrdersDTO orderDTO);

    @InheritInverseConfiguration
    List<Orders> DTOs2Orders(List<OrdersDTO> ordersDTOs);
}
