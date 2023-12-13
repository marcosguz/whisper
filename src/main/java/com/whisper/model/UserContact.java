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
@Table(name = "USER_CONTACT")
public class UserContact {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_USER_CONTACT", nullable = false, updatable = false)
    private String idUserContact;

    @Column(name = "USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name = "ID_USER", foreignKey = @ForeignKey(name = "FK_USER_CONTACT_CONTACT"))
    private User idUser;

    @ManyToOne
    @JoinColumn(name = "ID_CONT", foreignKey = @ForeignKey(name = "FK_USER_CONTACT_USER"))
    private User idCont;

    @Column(name = "CREATE_AT")
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateDate;

    @Column(name = "STATUS")
    private boolean status;
}
