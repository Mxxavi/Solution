package com.mx.gritsolutions.repositories;

import com.mx.gritsolutions.entities.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock,Long> {
    Stock findStockByItemId (Long idItem);
}
