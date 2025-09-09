package com.hackathon.bankingapp.auth.infrastructure.controller;

import com.hackathon.bankingapp.auth.application.LoginUserService;
import com.hackathon.bankingapp.auth.infrastructure.dto.LoginRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.LoginResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping("/users")
@Slf4j
public class LoginPostController {
    private final LoginUserService loginUserService;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> loginUser(@Valid @RequestBody LoginRequestDTO loginRequestDTO) {
        log.info("Login request: {}", loginRequestDTO);
        LoginResponseDTO loggedInUser = loginUserService.loginUser(loginRequestDTO);
        return ResponseEntity.ok(loggedInUser);
    }
}
