package com.mx.gritsolutions.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
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
}
