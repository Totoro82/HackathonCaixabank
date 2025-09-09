package com.hackathon.bankingapp.auth.infrastructure.controller;

import com.hackathon.bankingapp.auth.application.RegistrationUserService;
import com.hackathon.bankingapp.auth.infrastructure.dto.RegistrationRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.RegistrationResponseDTO;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
@Slf4j
@AllArgsConstructor
public class RegistrationPostController {
    private final RegistrationUserService registrationUserService;

    //registro
    @PostMapping("/register")
    public ResponseEntity<RegistrationResponseDTO> registerUser(@Valid @RequestBody RegistrationRequestDTO registrationRequestDTO) {
        log.info("Registering new user {}", registrationRequestDTO);
        RegistrationResponseDTO registeredUser = registrationUserService.registerUser(registrationRequestDTO);
        return ResponseEntity.ok(registeredUser);
    }



    //inicio de sesion
//    public ResponseEntity<?> login(@Valid @RequestBody LoginRequestDTO request) {
//        RegistrationResponseDTO user = userDatabase.get(request.identifier());
//        if (user == null) {
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("User not found for the given identifier: " + request.identifier());
//        }
//
//        // Verificar la contraseña
//        if (!checkPassword(user, request.password())) {
//            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Bad credentials");
//        }
//    }

}