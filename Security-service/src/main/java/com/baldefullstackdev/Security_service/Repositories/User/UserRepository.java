package com.baldefullstackdev.Security_service.Repositories.User;

import com.baldefullstackdev.Security_service.Models.User.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
