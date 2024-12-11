package com.mx.gritsolutions.entities;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String mail;

    public User(String inputName, String inputMail) {
        this.name = inputName;
        this.mail = inputMail;
    }
}

