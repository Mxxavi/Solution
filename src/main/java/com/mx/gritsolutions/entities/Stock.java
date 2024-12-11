package com.mx.gritsolutions.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

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

    public Stock(){}
    public Stock(int quantityInput, LocalDateTime creationDateInput, Item itemInput){
        this.quantity = quantityInput;
        this.creationDate = creationDateInput;
        this.item  = itemInput;
    }
    public Stock(Long id,int quantityInput, LocalDateTime creationDateInput, Item itemInput){
        this.id = id;
        this.quantity = quantityInput;
        this.creationDate = creationDateInput;
        this.item  = itemInput;
    }
    //getter & setter

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
