package com.femcoders.movienight.services;

import com.femcoders.movienight.exceptions.UserNotFoundException;
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
                .orElseThrow(() -> new UserNotFoundException("No existe un usuario con id "
                        + userId));
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

    public Profile findById(int profileId) {
        return profileRepository.findById(profileId).orElseThrow(() -> new RuntimeException("Profile not found"));
    }

    public ResponseEntity<Object> updateProfile(int profileId, Profile profile) {
        try {
            Profile existingProfile = profileRepository.findById(profileId).get();
            if (profile.getUser() != null){
                existingProfile.setUser(profile.getUser());
            }
            if (profile.getName() != null) {
                existingProfile.setName(profile.getName());
            }
            if (profile.getProfile_photo() != null) {
                existingProfile.setProfile_photo(profile.getProfile_photo());
            }
            if (profile.getContent() != null) {
                existingProfile.setContent(profile.getContent());
            }
            profileRepository.save(existingProfile);
            return new ResponseEntity<>(existingProfile, HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
