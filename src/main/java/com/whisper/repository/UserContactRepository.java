package com.whisper.repository;

import com.whisper.model.UserContact;
import com.whisper.service.dto.UserContactDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserContactRepository extends JpaRepository<UserContact, String> {
    @Query("SELECT UC " +
            "FROM User U " +
            "JOIN UserContact UC ON U.idUser = UC.idUser.idUser " +
            "WHERE U.idUser = ?1 AND UC.status = true " +
            "ORDER BY UC.creationDate DESC")
    List<UserContact> getContacts(String id);

    @Query("SELECT UC " +
            "FROM UserContact UC " +
            "WHERE UC.idCont.idUser = ?1 AND UC.status = true")
    UserContact deleteContact(String idContact);

    @Query("SELECT UC " +
            "FROM UserContact UC " +
            "WHERE UC.username = ?1")
    UserContact getUserContact(String username);
}
