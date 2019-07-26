package com.codetech.oauth2.repository;

import com.codetech.oauth2.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * Created by A Majutharan.
 * Date: 6/16/2019
 * Time: 12:28 PM
 */
@Repository
public interface UserRepository extends JpaRepository<UserModel, Long> {
    UserModel findByUsername(String username);
//    UserModel findById(Long id);
//    Optional<UserModel> findById(Long id);
    UserModel findUserModelById(Long id);
}
