package com.mx.gritsolutions.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;

@Entity
@Data
@Table(name = "items", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Item implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ItemId", nullable = false, updatable = false)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String code;

    public Item() {
    }

    public Item(String inputName, String inputCode) {
        this.name = inputName;
        this.code = inputCode;
    }
}
