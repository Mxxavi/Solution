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

    public Stock() {
    }

    public Stock(String inputId, int inputQuantity, LocalDateTime inputCreationDate, Item inputItem) {
        if(inputId != null && !inputId.equals("null"))
            this.id = Long.parseLong(inputId);
        this.quantity = inputQuantity;
        this.creationDate = inputCreationDate;
        this.item = inputItem;
    }
}
