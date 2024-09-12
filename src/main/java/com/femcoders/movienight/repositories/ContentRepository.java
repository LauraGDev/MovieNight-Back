package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Content;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContentRepository extends JpaRepository<Content, Integer> {
    Content findByApiId(String apiId);
}
