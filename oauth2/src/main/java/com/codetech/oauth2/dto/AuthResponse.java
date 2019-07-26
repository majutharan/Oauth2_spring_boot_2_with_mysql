package com.codetech.oauth2.dto;

import com.codetech.oauth2.model.UserModel;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * Created by A Majutharan.
 * Date: 7/3/2019
 * Time: 4:57 PM
 */
@Getter
@Setter
public class AuthResponse implements Serializable {
    private static final long serialVersionUID = 1L;
    private UserModel userModel;
    private String role;
}
