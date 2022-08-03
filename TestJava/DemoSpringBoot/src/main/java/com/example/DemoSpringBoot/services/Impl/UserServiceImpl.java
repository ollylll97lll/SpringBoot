package com.example.DemoSpringBoot.services.Impl;

import java.math.BigInteger;
import java.util.List;
import com.example.DemoSpringBoot.models.DTO.UserDTO;

public interface UserServiceImpl {
    UserDTO postUser(UserDTO user)throws Exception;
    List<UserDTO> getAllUsers() throws Exception;
    UserDTO getOneUser(BigInteger id) throws Exception;
    UserDTO editUser(UserDTO user, BigInteger id) throws Exception;
}
