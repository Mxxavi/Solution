package com.mx.gritsolutions.entities;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "UserId", nullable = false, updatable = false)
    private Long id;
    private String name;
    private String mail;


    public User(){};

    public User(String name, String mail) {
        this.name = name;
        this.mail = mail;
    }

    //getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }
}

