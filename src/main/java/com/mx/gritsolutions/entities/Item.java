package com.mx.gritsolutions.entities;

import jakarta.persistence.*;

import java.io.Serializable;

@Entity
@Table(name = "items", uniqueConstraints = @UniqueConstraint(columnNames = "code"))
public class Item implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ItemId", nullable = false, updatable = false)
    private Long id;
    private String name;
    @Column(nullable = false, unique = true)
    private String code;

    public Item(){}

    public Item(String inputName,String code){
        this.name = inputName;
        this.code = code;
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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
