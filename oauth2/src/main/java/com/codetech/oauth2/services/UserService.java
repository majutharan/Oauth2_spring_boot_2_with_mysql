package com.codetech.oauth2.services;

import com.codetech.oauth2.dto.AuthResponse;
import com.codetech.oauth2.model.UserModel;
import com.codetech.oauth2.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by A Majutharan.
 * Date: 7/3/2019
 * Time: 5:01 PM
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public AuthResponse userInfo(Long userId) {
        UserModel userModel = userRepository.getOne(userId);
        UserModel minUserInfo = new UserModel();
        minUserInfo.setId(userModel.getId());
        minUserInfo.setName(userModel.getName());
        minUserInfo.setUsername(userModel.getUsername());
        AuthResponse authResponse = new AuthResponse();
        authResponse.setUserModel(minUserInfo);
        authResponse.setRole("USER");
        return authResponse;
    }
}
