package com.femcoders.movienight.services;

import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.models.User;
import com.femcoders.movienight.repositories.ProfileRepository;
import com.femcoders.movienight.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProfileService {

    private final ProfileRepository profileRepository;
    private final UserRepository userRepository;

    public ResponseEntity<Object> addProfile(Profile profile, int userId) {
        User user = userRepository.findById(userId)
                .orElseThrow();
        profile.setUser(user);
        if (profile.getProfile_photo() == null || profile.getProfile_photo().isEmpty()) {
            profile.setProfile_photo("https://res.cloudinary.com/dugbix24o/image/upload/v1725884108/Foto_perfil_inicial_fdrdes.svg");
        }
        profileRepository.save(profile);
        return new ResponseEntity<>(profile, HttpStatus.CREATED);
    }

    public List<Profile> getProfilesByUserId(int userId) {
        return profileRepository.findByUserId(userId);
    }
}
