package com.femcoders.movienight.services;

import com.femcoders.movienight.config.jwt.JwtService;
import com.femcoders.movienight.exceptions.EmailAlreadyExistsException;
import com.femcoders.movienight.exceptions.EmailNotFoundException;
import com.femcoders.movienight.controllers.responses.UserDTO;
import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.models.Role;
import com.femcoders.movienight.models.User;
import com.femcoders.movienight.controllers.responses.AuthResponse;
import com.femcoders.movienight.controllers.requests.LoginRequest;
import com.femcoders.movienight.controllers.requests.RegisterRequest;
import com.femcoders.movienight.repositories.UserRepository;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final ProfileService profileService;

    public AuthResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail()).orElseThrow(() ->
                new EmailNotFoundException("No se encontró ningún usuario con ese email."));
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                request.getEmail(), request.getPassword()));
        UserDTO userDTO = UserDTO.builder()
                .id(user.getId())
                .email(user.getEmail())
                .name(user.getName()).build();
        String token = jwtService.getToken(user);
        return AuthResponse.builder()
                .token(token)
                .user(userDTO)
                .build();
    }

    public AuthResponse register(RegisterRequest request) {
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new EmailAlreadyExistsException("Ya existe un usuario con ese email.");
        }
        User user = User.builder()
                .name(request.getName())
                .email(request.getEmail())
                .password(passwordEncoder.encode(request.getPassword()))
                .role(Role.USER)
                .build();
        userRepository.save(user);

        Profile profile = new Profile();
        profile.setUser(user);
        profile.setName(user.getName());
        profileService.addProfile(profile);

        return AuthResponse.builder()
                .token(jwtService.getToken(user))
                .build();
    }
}
