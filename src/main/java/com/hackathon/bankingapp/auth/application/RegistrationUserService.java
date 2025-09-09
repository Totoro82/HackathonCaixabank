package com.hackathon.bankingapp.auth.application;

import com.hackathon.bankingapp.auth.domain.User;
import com.hackathon.bankingapp.auth.infrastructure.dto.RegistrationRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.RegistrationResponseDTO;
import com.hackathon.bankingapp.auth.infrastructure.repository.UserRepository;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.UUID;
@AllArgsConstructor
@Service
public class RegistrationUserService {
    private final UserRepository userRepository;

    public RegistrationResponseDTO registerUser(RegistrationRequestDTO registrationRequestDTO) {
        Assert.notNull(registrationRequestDTO, "registrationRequestDTO cannot be null");
        User user = new User(registrationRequestDTO.name(), registrationRequestDTO.email(), registrationRequestDTO.password(), registrationRequestDTO.address(), registrationRequestDTO.phoneNumber());
        if(userRepository.emailOrPhoneExists(user)){ //comprobaciones
            // todo excepcion
            throw new RuntimeException("kk");
        } else {
            userRepository.saveUser(user);
            return createRegistrationResponseDTO(registrationRequestDTO);
        }
    }


    private RegistrationResponseDTO createRegistrationResponseDTO(RegistrationRequestDTO registrationRequestDTO) {
        String accountNumber = UUID.randomUUID().toString(); //guardar en el modelo
        String hashedPassword = hashPassword(registrationRequestDTO.password());
        return new RegistrationResponseDTO(
                registrationRequestDTO.name(),
                registrationRequestDTO.email(),
                registrationRequestDTO.phoneNumber(),
                registrationRequestDTO.address(),
                accountNumber,
                hashedPassword
        );
    }

    private String hashPassword(@NotBlank String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder.encode(password);
    }
}
