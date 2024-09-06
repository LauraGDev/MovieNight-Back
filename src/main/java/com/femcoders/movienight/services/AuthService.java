package com.femcoders.movienight.services;

import com.femcoders.movienight.auth.AuthResponse;
import com.femcoders.movienight.auth.LoginRequest;
import com.femcoders.movienight.auth.RegisterRequest;
import com.femcoders.movienight.models.Role;
import com.femcoders.movienight.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import com.femcoders.movienight.models.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;

    public AuthResponse login(LoginRequest request) {
        return null;
    }

    public AuthResponse register(RegisterRequest request) {
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(request.getPassword())
                .role(Role.USER)
                .build();
        userRepository.save(user);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
