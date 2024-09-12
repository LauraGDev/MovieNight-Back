package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepsitory extends JpaRepository<Genre, Integer> {
    Genre findByName(String name);
}
