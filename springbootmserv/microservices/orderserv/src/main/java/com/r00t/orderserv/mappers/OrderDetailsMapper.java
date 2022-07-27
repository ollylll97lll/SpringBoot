package com.r00t.orderserv.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.r00t.orderserv.entities.OrderDetails;
import com.r00t.orderserv.models.DTO.OrderDetailsDTO;

@Mapper(componentModel = "spring")
public interface OrderDetailsMapper {
    OrderDetailsMapper INSTANCE = Mappers.getMapper(OrderDetailsMapper.class);

    OrderDetailsDTO detail2DTO(OrderDetails order);

    List<OrderDetailsDTO> details2DTOs(List<OrderDetails> orders);

    @InheritInverseConfiguration
    OrderDetails DTO2Detail(OrderDetailsDTO orderDTO);

    @InheritInverseConfiguration
    List<OrderDetails> DTOs2Details(List<OrderDetailsDTO> ordersDTOs);
}
