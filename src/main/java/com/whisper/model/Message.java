package com.whisper.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "[MESSAGE]")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_MESS", nullable = false, updatable = false)
    private String idMess;

    @ManyToOne
    @JoinColumn(name = "ID_SENDER", foreignKey = @ForeignKey(name = "FK_SENDER_USER"))
    private User idSender;

    @ManyToOne
    @JoinColumn(name = "ID_RECEIVER", foreignKey = @ForeignKey(name = "FK_RECEIVER_USER"))
    private User idReceiver;

    @Column(name = "TEXT")
    private String text;

    @Column(name = "CREATE_AT")
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateDate;

    @Column(name = "STATUS")
    private boolean status;
}
