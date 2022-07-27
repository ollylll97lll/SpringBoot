package com.r00t.usermserv.controllers.privat3;

import java.math.BigInteger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.usermserv.models.DTO.UserDTO;
import com.r00t.usermserv.services.impls.UserServiceImpl;

@RestController
@RequestMapping(value = "api/v1/protected/users")
@Transactional
public class UserController {
    @Autowired
    private UserServiceImpl uService;

    @PostMapping(value = "")
    public UserDTO postUser(@Valid @RequestBody UserDTO user) throws Exception {
        return uService.postUser(user);
    }

    @PutMapping(value = "/{id}")
    public UserDTO editUser(@Valid @RequestBody UserDTO user, @PathVariable BigInteger id) throws Exception {
        return uService.editUser(user, id);
    }
}
