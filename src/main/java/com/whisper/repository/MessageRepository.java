package com.whisper.repository;

import com.whisper.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, String> {
    @Query("SELECT M " +
            "FROM User U " +
            "JOIN Message M ON U.idUser = M.idSender.idUser " +
            "WHERE U.idUser = ?1 " +
            "ORDER BY M.creationDate DESC")
    List<Message> getMessagesListById(String id);

    @Query("SELECT M FROM Message M " +
            "WHERE M.idMess = ?1")
    Message isPresentMessageById(String id);
}
