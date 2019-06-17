package com.codetech.oauth2.controller;

import com.codetech.oauth2.model.User;
import com.codetech.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by A Majutharan.
 * Date: 6/16/2019
 * Time: 12:29 PM
 */
@RestController
@RequestMapping(path = "/user-service")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping(path = "/get-all-users")
    public @ResponseBody
    ResponseEntity<Iterable> getAllUsers() {
        Iterable<User> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }
}
