package com.r00t.usermserv.repositories;

import java.math.BigInteger;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.r00t.usermserv.entities.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, BigInteger> {
}
