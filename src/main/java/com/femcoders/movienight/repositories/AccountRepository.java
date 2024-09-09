package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Profile, Integer> {
}
