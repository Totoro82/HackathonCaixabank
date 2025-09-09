package com.hackathon.bankingapp.auth.application;

import com.hackathon.bankingapp.auth.infrastructure.dto.LoginRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.LoginResponseDTO;
import com.hackathon.bankingapp.auth.infrastructure.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@AllArgsConstructor
@Service
public class LoginUserService {
    private final UserRepository userRepository;
    private final JWSProvider jwsProvider;

    public LoginResponseDTO loginUser(LoginRequestDTO loginRequestDTO) {
        Assert.notNull(loginRequestDTO, "loginRequestDTO cannot be null");
        if (userRepository.emailExists(loginRequestDTO.identifier())) {
            if(userRepository.passwordMatchesEmail(loginRequestDTO.identifier(), loginRequestDTO.password())) {
                userRepository.logInUser(loginRequestDTO.identifier());
                return createLoginResponseDTO(loginRequestDTO.identifier());
            } else {
                //todo exception
//                If the password is invalid it returns the following with Status Code 401:
//                Bad credentials
            }
        } else {
            // todo exception
//            If the identifier is invalid it returns the following with Status Code 400:
//            User not found for the given identifier: nuwee@nuwe.com

        }
        return null;
    }

    private LoginResponseDTO createLoginResponseDTO(String identifier) {
        String token = jwsProvider.createToken(identifier);
        System.out.println(token);
        return new LoginResponseDTO(token);
    }
}
