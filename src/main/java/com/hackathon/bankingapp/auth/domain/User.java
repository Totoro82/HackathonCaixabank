package com.hackathon.bankingapp.auth.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String name;
    private String email;
    private String password;
    private String address;
    private String phoneNumber;
    private String accountNumber;
    private String hashedPassword;
    private boolean isLogged;
}
