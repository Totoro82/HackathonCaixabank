package com.hackathon.bankingapp.auth.infrastructure.dto;

public record UserInfoResponseDTO(
   String name,
   String email,
   String phoneNumber,
   String address,
   String accountNumber,
   String hashedPassword
) {}
