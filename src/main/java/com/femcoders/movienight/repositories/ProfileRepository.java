package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {
}
