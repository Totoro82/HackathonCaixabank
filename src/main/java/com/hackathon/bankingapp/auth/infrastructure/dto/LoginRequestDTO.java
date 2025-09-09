package com.hackathon.bankingapp.auth.infrastructure.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record LoginRequestDTO(
        @Email String identifier,
        @NotBlank String password
) {}
