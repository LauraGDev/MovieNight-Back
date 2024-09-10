package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
    List<Profile> findByUserId(int userId);
}
