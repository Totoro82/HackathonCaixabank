package com.hackathon.bankingapp.auth.infrastructure.controller;

import com.hackathon.bankingapp.auth.application.UserInfoUserService;
import com.hackathon.bankingapp.auth.infrastructure.dto.UserInfoRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.UserInfoResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/dashboard")
@Slf4j
@AllArgsConstructor
public class UserInfoPostController {
    private final UserInfoUserService userInfoUserService;

    //fetch user info
    @PostMapping("/user")
    public ResponseEntity<UserInfoResponseDTO> getUserInfo(@Valid @RequestBody UserInfoRequestDTO userInfoRequestDTO) {
        log.info("Get User Info {}", userInfoRequestDTO);
        UserInfoResponseDTO userInfo = userInfoUserService.fetchUserInfo(userInfoRequestDTO);
        return ResponseEntity.ok(userInfo);
    }
}
