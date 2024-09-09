package com.femcoders.movienight.services;

import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.repositories.ProfileRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@RequiredArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;

    public ResponseEntity<Object> addProfile(Profile profile) {
        if (profile.getProfile_photo() == null || profile.getProfile_photo().isEmpty()) {
            profile.setProfile_photo("https://res.cloudinary.com/dugbix24o/image/upload/v1725884108/Foto_perfil_inicial_fdrdes.svg");
        }
        profileRepository.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }
}
