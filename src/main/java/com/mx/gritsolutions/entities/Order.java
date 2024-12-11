package com.mx.gritsolutions.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "OrderId", nullable = false, updatable = false)
    private Long id;
    private int quantity;
    private LocalDateTime creationDate = LocalDateTime.now();
    @ManyToOne
    private Item item;
    @ManyToOne
    private User user;
    private boolean orderIsCompleted;

    public Order(){}

    public Order (int quantity,Item item,User user,Boolean orderIsCompleted){
        this.quantity = quantity;
        this.item = item;
        this.user = user;
        this.orderIsCompleted = orderIsCompleted;
    }
    //getter & setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isOrderIsCompleted() {
        return orderIsCompleted;
    }

    public void setOrderIsCompleted(boolean orderIsCompleted) {
        this.orderIsCompleted = orderIsCompleted;
    }
}
