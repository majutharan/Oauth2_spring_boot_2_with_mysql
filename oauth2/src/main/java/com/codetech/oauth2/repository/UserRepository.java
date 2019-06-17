package com.codetech.oauth2.repository;

import com.codetech.oauth2.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by A Majutharan.
 * Date: 6/16/2019
 * Time: 12:28 PM
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
