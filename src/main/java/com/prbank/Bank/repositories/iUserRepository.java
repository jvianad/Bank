package com.prbank.Bank.repositories;
import com.prbank.Bank.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface iUserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String Email);
}
