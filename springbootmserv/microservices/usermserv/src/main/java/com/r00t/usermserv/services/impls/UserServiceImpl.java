package com.r00t.usermserv.services.impls;

import java.math.BigInteger;
import java.util.List;

import com.r00t.usermserv.models.DTO.UserDTO;

public interface UserServiceImpl {
    UserDTO postUser(UserDTO user) throws Exception;

    List<UserDTO> getAllUsers() throws Exception;

    UserDTO getOneUser(BigInteger id) throws Exception;

    UserDTO editUser(UserDTO user, BigInteger id) throws Exception;
}
