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
@Table(name = "[USER]")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "ID_USER", nullable = false, updatable = false)
    private String idUser;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "NAME")
    private String name;

    @Column(name = "SURNAME")
    private String surname;

    @Column(name = "AGE")
    private int age;

    @Column(name = "GENDER")
    private char gender;

    @Column(name = "PHONE")
    private String phone;

    @Column(name = "EMAIL")
    private String email;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "CREATE_AT")
    private LocalDateTime creationDate;

    @Column(name = "UPDATE_AT")
    private LocalDateTime updateDate;

    @Column(name = "STATUS")
    private boolean status;

    @Column(name = "PROFILE_IMAGE")
    private byte[] profileImage;

}
