package com.femcoders.movienight.services;

import com.femcoders.movienight.models.Content;
import com.femcoders.movienight.models.Genre;
import com.femcoders.movienight.models.Profile;
import com.femcoders.movienight.repositories.ContentRepository;
import com.femcoders.movienight.repositories.GenreRepsitory;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ContentService {
    private final ContentRepository contentRepository;
    private final GenreRepsitory genreRepository;
    private final ProfileService profileService;

    @Transactional
    public ResponseEntity<Object> addProfileContent(int profileId, Content content) {
        Profile profile = profileService.findById(profileId);
        Content existingContent = contentRepository.findByApiId(content.getApiId());
        if (existingContent != null) {
            content = existingContent;
        } else {
            List<Genre> newGenres = new ArrayList<>();
            for (Genre gen : content.getGenres()) {
                Genre genre = genreRepository.findByName(gen.getName());
                if (genre == null) {
                    genre = new Genre();
                    genre.setName(gen.getName());
                    genreRepository.save(genre);
                }
                newGenres.add(genre);
            }
            content.setGenres(newGenres);
            contentRepository.save(content);
        }

        if (!profile.getContent().contains(content)) {
            profile.getContent().add(content);
            profileService.updateProfile(profileId, profile);
            return new ResponseEntity<>("Contenido añadido correctamente a la lista.", HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>("El usuario ya tiene este contenido en su lista.", HttpStatus.CONFLICT);
        }
    }
}