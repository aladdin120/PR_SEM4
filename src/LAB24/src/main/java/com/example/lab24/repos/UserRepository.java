package com.example.lab24.repos;

import com.example.lab24.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByLogin(String login);
}
