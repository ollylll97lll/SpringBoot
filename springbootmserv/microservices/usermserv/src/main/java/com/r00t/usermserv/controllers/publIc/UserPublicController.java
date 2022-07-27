package com.r00t.usermserv.controllers.publIc;

import java.math.BigInteger;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.r00t.usermserv.models.DTO.UserDTO;
import com.r00t.usermserv.services.impls.UserServiceImpl;

@RestController
@RequestMapping("api/v1/public/users")
public class UserPublicController {
    @Autowired
    private UserServiceImpl uService;

    @GetMapping(value = "")
    public ResponseEntity getAllUsers() throws Exception {
        try {
            return new ResponseEntity<List<UserDTO>>(uService.getAllUsers(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("nuthing here bro", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity getOneByID(@PathVariable BigInteger id) throws Exception {
        try {
            return new ResponseEntity<UserDTO>(uService.getOneUser(id), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("found nuthing with that userID", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
