package com.hackathon.bankingapp.auth.application;

import com.hackathon.bankingapp.auth.domain.User;
import com.hackathon.bankingapp.auth.infrastructure.dto.UserInfoRequestDTO;
import com.hackathon.bankingapp.auth.infrastructure.dto.UserInfoResponseDTO;
import com.hackathon.bankingapp.auth.infrastructure.repository.UserRepository;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UserInfoUserService {
    private final UserRepository userRepository;
    private final JWSProvider jwsProvider;

    public UserInfoResponseDTO fetchUserInfo(@Valid UserInfoRequestDTO userInfoRequestDTO) {
        String userEmail = jwsProvider.decodeToken(userInfoRequestDTO.token());
        User user = userRepository.getUser(userEmail);
        UserInfoResponseDTO userInfoResponseDTO = new UserInfoResponseDTO(user.getName(), user.getEmail(), user.getPhoneNumber(),
                user.getAddress(), user.getAccountNumber(), user.getHashedPassword());
        return userInfoResponseDTO;
    }
}
