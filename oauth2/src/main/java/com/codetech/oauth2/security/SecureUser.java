package com.codetech.oauth2.security;


import lombok.Getter;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * Created by A Majutharan.
 * Date: 6/16/2019
 * Time: 10:04 PM
 */
@Getter
@Setter
public class SecureUser extends User {
    private int id;

    public SecureUser(String username, String password, Collection<? extends GrantedAuthority> authorities) {
        super(username, password, authorities);
        // TODO Auto-generated constructor stub
    }
}
