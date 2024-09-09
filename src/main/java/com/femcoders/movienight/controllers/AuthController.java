package com.femcoders.movienight.controllers;

import com.femcoders.movienight.controllers.responses.AuthResponse;
import com.femcoders.movienight.services.AuthService;
import com.femcoders.movienight.controllers.requests.LoginRequest;
import com.femcoders.movienight.controllers.requests.RegisterRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthController {

    private final AuthService authService;

    @CrossOrigin("*")
    @PostMapping(value = "login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {
        AuthResponse response = authService.login(request);
        String welcomeMessage = "Bienvenid@ de nuevo " + response.getUser().getName();
        response.setMessage(welcomeMessage);
        return ResponseEntity.ok(response);
    }

    @PostMapping(value = "register")
    public ResponseEntity<AuthResponse>  register(@RequestBody RegisterRequest request) {
        AuthResponse response = authService.register(request);
        String welcomeMessage = "Usuario registrado con éxito, ya puedes iniciar sesión.";
        response.setMessage(welcomeMessage);
        return ResponseEntity.ok(response);
    }
}
