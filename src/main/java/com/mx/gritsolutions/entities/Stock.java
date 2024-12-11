package com.mx.gritsolutions.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "StockId", nullable = false, updatable = false)
    private Long id;
    private LocalDateTime creationDate;
    @ManyToOne
    private Item item;
    private int quantity;
}
