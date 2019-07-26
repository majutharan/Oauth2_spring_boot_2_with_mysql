package com.codetech.oauth2.security;

import com.codetech.oauth2.dto.AuthResponse;
import com.codetech.oauth2.model.UserModel;
import com.codetech.oauth2.repository.UserRepository;
import com.codetech.oauth2.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by A Majutharan.
 * Date: 6/16/2019
 * Time: 10:16 PM
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username);
        AuthResponse authResponse = userService.userInfo(userModel.getId());
        String role = authResponse.getRole();
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority(role));
        SecureUser secureUser = new SecureUser(username, userModel.getPassword(), authorities);
        secureUser.setId(userModel.getId());
		secureUser.setAuthResponse(authResponse);
        return secureUser;
    }

    public UserModel currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) authentication.getPrincipal();
        return userRepository.findByUsername(username);
    }
}
