package com.r00t.usermserv.mappers;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Component;

import com.r00t.usermserv.entities.Users;
import com.r00t.usermserv.models.DTO.UserDTO;

@Mapper(componentModel = "spring")
@Component
public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO user2DTO(Users user);

    List<UserDTO> users2DTOs(List<Users> users);

    @InheritInverseConfiguration
    Users DTO2User(UserDTO userDTO);

    @InheritInverseConfiguration
    List<Users> DTOs2Users(List<UserDTO> userDTOs);

}
