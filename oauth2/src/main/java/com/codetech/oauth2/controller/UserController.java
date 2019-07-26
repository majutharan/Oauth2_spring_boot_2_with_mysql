package com.codetech.oauth2.controller;

import com.codetech.oauth2.model.UserModel;
import com.codetech.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

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
        Iterable<UserModel> users = userRepository.findAll();
        return ResponseEntity.ok(users);
    }

    @GetMapping(path = "/view-user")
    public @ResponseBody ResponseEntity<Optional> viewUser(@RequestParam("id") Long id) {
        return ResponseEntity.ok(userRepository.findById(id));
    }

    @GetMapping(path = "/logout")
    public @ResponseBody ResponseEntity<String> logout(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        authentication.setAuthenticated(false);
        new SecurityContextLogoutHandler().logout(request,response,authentication);
        SecurityContextHolder.clearContext();
        request.logout();
        request.getSession().invalidate();
        return ResponseEntity.ok("successfully logout");
    }
}
