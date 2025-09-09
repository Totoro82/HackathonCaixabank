package com.hackathon.bankingapp.auth.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record RegistrationRequestDTO(
       @NotBlank String name,
       @NotBlank String password,
       @Email String email,
       @NotBlank String address,
       @NotBlank String phoneNumber) {}
