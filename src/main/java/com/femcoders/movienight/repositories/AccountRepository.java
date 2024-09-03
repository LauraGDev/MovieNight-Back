package com.femcoders.movienight.repositories;

import com.femcoders.movienight.models.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Integer> {
}
