package com.efass.user;

import lombok.Data;

import javax.validation.constraints.Size;

@Data
public class SignUpRequest {
    @Size(min = 4, message = "Username should have atleast 5 characters")
    private String username;


    //@JsonIgnore
    @Size(min = 2, message = "Password should have atleast 5 characters")

    private String password;
}
