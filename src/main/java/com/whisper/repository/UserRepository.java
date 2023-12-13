package com.whisper.repository;

import com.whisper.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    @Query("SELECT U FROM User U " +
            "WHERE U.email = ?1")
    Optional<User> isPresentUserByEmail(String email);

    @Query("SELECT U FROM User U " +
            "WHERE U.idUser = ?1")
    User getUserById(String id);

    @Query("SELECT U FROM User U " +
            "WHERE U.idUser = ?1")
    Optional<User> isPresentUserById(String id);
}
