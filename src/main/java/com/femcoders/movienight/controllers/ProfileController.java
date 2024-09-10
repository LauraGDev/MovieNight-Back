package com.femcoders.movienight.controllers;

import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST})
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping(value = "/new-profile/{userId}")
    public ResponseEntity<Object> addProfile(@RequestBody Profile profile, @PathVariable int userId) {
        ResponseEntity<Object> response = profileService.addProfile(profile, userId);
        return ResponseEntity.ok(response);
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @GetMapping("/getProfiles/{userId}")
    public ResponseEntity<Object> getProfilesByUserId(@PathVariable int userId) {
        try {
            List<Profile> profiles = profileService.getProfilesByUserId(userId);
            if (profiles.isEmpty()) {
                return new ResponseEntity<>("El usuario no tiene ningún perfil", HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(profiles, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener los perfiles", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
