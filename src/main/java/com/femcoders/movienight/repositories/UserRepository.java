package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
