package com.femcoders.movienight.controllers;

import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.services.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/profiles")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProfileController {
    private final ProfileService profileService;

    @PostMapping(value = "new-profile")
    public ResponseEntity<Object> addProfile(@RequestBody Profile profile) {
        ResponseEntity<Object> response = profileService.addProfile(profile);
        return ResponseEntity.ok(response);
    }
}
